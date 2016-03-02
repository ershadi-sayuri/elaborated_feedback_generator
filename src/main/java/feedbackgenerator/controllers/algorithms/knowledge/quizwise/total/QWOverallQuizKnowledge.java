package feedbackgenerator.controllers.algorithms.knowledge.quizwise.total;

import feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories.QWDifficultyOrTopicKnowledge;
import feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories.QWDifficultyTopicKnowledge;
import feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories.QWQuestionKnowledge;
import feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/13/2016.
 */
public class QWOverallQuizKnowledge {

    public double findQuizKnowledge(int userId, int quizId) throws Exception {
        QWQuestionKnowledge qwQuestionKnowledge = new QWQuestionKnowledge();
        double averageQuestionAttemptGrade = qwQuestionKnowledge.findAverageQuestionAttemptGrade(userId, quizId);
        double questionAttemptProgress = qwQuestionKnowledge.findQuestionAttemptProgress(userId, quizId);

        // difficulty
        QWDifficultyOrTopicKnowledge qwDifficultyOrTopicKnowledge = new QWDifficultyOrTopicKnowledge();
        double advancedQuestionGrade = qwDifficultyOrTopicKnowledge.findAverageDifficultyOrTopicGrade(userId, quizId,
                "advanced");
        double advancedQuestionProgress = qwDifficultyOrTopicKnowledge.findDifficultyOrTopicProgress(userId, quizId,
                "advanced");
        double easyQuestionGrade = qwDifficultyOrTopicKnowledge.findAverageDifficultyOrTopicGrade(userId, quizId,
                "easy");
        double easyQuestionProgress = qwDifficultyOrTopicKnowledge.findDifficultyOrTopicProgress(userId, quizId,
                "easy");

        // find different topics of the quiz
        QuizSlot quizSlot = new QuizSlot();
        ArrayList<String> differentNamesOfQuestions = quizSlot.getDifferentNamesOfQuestionsByQuiz(quizId);
        double averageDifficultyOrTopicGrade = 0;
        double difficultyOrTopicProgress = 0;
        double averageAdvancedTopicGrade = 0;
        double averageAdvancedTopicProgress = 0;
        double averageEasyTopicGrade = 0;
        double averageEasyTopicProgress = 0;
        for (int i = 0; i < differentNamesOfQuestions.size(); i++) {
            // topic
            averageDifficultyOrTopicGrade += qwDifficultyOrTopicKnowledge.findAverageDifficultyOrTopicGrade(userId,
                    quizId, differentNamesOfQuestions.get(i));
            difficultyOrTopicProgress += qwDifficultyOrTopicKnowledge.findDifficultyOrTopicProgress(userId, quizId,
                    differentNamesOfQuestions.get(i));

            //difficulty topic
            QWDifficultyTopicKnowledge qwDifficultyTopicKnowledge = new QWDifficultyTopicKnowledge();
            averageAdvancedTopicGrade += qwDifficultyTopicKnowledge.findAverageDifficultyOrTopicGrade(userId, quizId,
                    differentNamesOfQuestions.get(i), "advanced");
            averageAdvancedTopicProgress += qwDifficultyTopicKnowledge.findDifficultyOrTopicProgress(userId, quizId,
                    differentNamesOfQuestions.get(i), "advanced");
            averageEasyTopicGrade += qwDifficultyTopicKnowledge.findAverageDifficultyOrTopicGrade(userId, quizId,
                    differentNamesOfQuestions.get(i), "easy");
            averageEasyTopicProgress += qwDifficultyTopicKnowledge.findDifficultyOrTopicProgress(userId, quizId,
                    differentNamesOfQuestions.get(i), "easy");
        }

        double totalQWKnowledge = averageQuestionAttemptGrade + questionAttemptProgress + advancedQuestionGrade +
                advancedQuestionProgress + easyQuestionGrade + easyQuestionProgress + averageDifficultyOrTopicGrade +
                difficultyOrTopicProgress + averageAdvancedTopicGrade + averageAdvancedTopicProgress +
                averageEasyTopicGrade + averageEasyTopicProgress;

        return totalQWKnowledge;
    }
}
