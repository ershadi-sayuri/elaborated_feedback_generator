package feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories;

import feedbackgenerator.controllers.algorithms.knowledge.quizwise.grade.QWGrade;
import feedbackgenerator.controllers.algorithms.knowledge.quizwise.progress.QWProgress;
import feedbackgenerator.models.QuestionAttempts;
import feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;


/**
 * Created by Ershadi Sayuri on 2/13/2016.
 */
public class QWQuestionKnowledge {

    /**
     * find the grading progress of a question based on its attempts by a particular user and a quiz
     *
     * @param userId
     * @param quizId
     * @return
     * @throws Exception
     */
    public double findQuestionAttemptProgress(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getQuestionIdsOfAQuiz(quizId);

        QWProgress qwProgress = new QWProgress();
        double questionGradingProgress = qwProgress.findQuizProgress(questionIds, userId);

        double averageQuestionGradingProgress = 0;
        if (questionGradingProgress != 0) {
            averageQuestionGradingProgress = questionGradingProgress / (questionIds.size() - 1);
        }

        return averageQuestionGradingProgress;
    }

    public double findAverageQuestionAttemptGrade(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getQuestionIdsOfAQuiz(quizId);

        QWGrade qwGrade = new QWGrade();
        double questionGrade = qwGrade.findQuizGrade(questionIds, userId);

        double averageQuestionGrade = 0;
        if (questionGrade != 0) {
            averageQuestionGrade = questionGrade / questionIds.size();
        }

        return averageQuestionGrade;
    }
}
