package feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories;

import feedbackgenerator.controllers.algorithms.knowledge.quizwise.grade.QWGrade;
import feedbackgenerator.controllers.algorithms.knowledge.quizwise.progress.QWProgress;
import feedbackgenerator.models.QuestionAttempts;
import feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/27/2016.
 */
public class QWQuestionDifficultyKnowledge {

    public double findEasyQuestionProgress(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getDifficultyWiseQuestionIdsOfAQuiz(quizId, "easy");

        QWProgress qwProgress = new QWProgress();
        double questionGradingProgress = qwProgress.findQuizProgress(questionIds, userId);

        double averageQuestionGradingProgress = 0;
        if (questionGradingProgress != 0) {
            averageQuestionGradingProgress = questionGradingProgress / (questionIds.size() - 1);
        }

        return averageQuestionGradingProgress;
    }

    public double findAdvancedQuestionProgress(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getDifficultyWiseQuestionIdsOfAQuiz(quizId, "advanced");

        QWProgress qwProgress = new QWProgress();
        double questionGradingProgress = qwProgress.findQuizProgress(questionIds, userId);

        double averageQuestionGradingProgress = 0;
        if (questionGradingProgress != 0) {
            averageQuestionGradingProgress = questionGradingProgress / (questionIds.size() - 1);
        }

        return averageQuestionGradingProgress;
    }

    public double findAverageEasyQuestionGrade(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getDifficultyWiseQuestionIdsOfAQuiz(quizId, "easy");

        QWGrade qwGrade = new QWGrade();
        double questionGrade = qwGrade.findQuizGrade(questionIds, userId);

        double averageQuestionGrade = 0;
        if (questionGrade != 0) {
            averageQuestionGrade = questionGrade / questionIds.size();
        }

        return averageQuestionGrade;
    }

    public double findAverageAdvancedQuestionGrade(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getDifficultyWiseQuestionIdsOfAQuiz(quizId, "advanced");

        QWGrade qwGrade = new QWGrade();
        double questionGrade = qwGrade.findQuizGrade(questionIds, userId);

        double averageQuestionGrade = 0;
        if (questionGrade != 0) {
            averageQuestionGrade = questionGrade / questionIds.size();
        }

        return averageQuestionGrade;
    }
}
