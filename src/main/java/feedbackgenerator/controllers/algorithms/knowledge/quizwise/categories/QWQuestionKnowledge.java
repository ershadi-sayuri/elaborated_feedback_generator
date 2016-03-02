package feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories;

import feedbackgenerator.controllers.algorithms.knowledge.grade.Grade;
import feedbackgenerator.controllers.algorithms.knowledge.progress.Progress;
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

        Progress progress = new Progress();
        double quizGradingProgress = progress.findQuizProgress(questionIds, userId);

        double averageQuizGradingProgress = 0;
        if (quizGradingProgress != 0) {
            averageQuizGradingProgress = quizGradingProgress / (questionIds.size() - 1);
        }

        return averageQuizGradingProgress;
    }

    public double findAverageQuestionAttemptGrade(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getQuestionIdsOfAQuiz(quizId);

        Grade grade = new Grade();
        double questionGrade = grade.findQuizGrade(questionIds, userId);

        double averageQuestionGrade = 0;
        if (questionGrade != 0) {
            averageQuestionGrade = questionGrade / questionIds.size();
        }

        return averageQuestionGrade;
    }
}
