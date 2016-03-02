package feedbackgenerator.controllers.algorithms.knowledge.allround.total;

import feedbackgenerator.controllers.algorithms.knowledge.allround.categories.ARDifficultyOrTopicKnowledge;
import feedbackgenerator.controllers.algorithms.knowledge.allround.categories.ARDifficultyTopicKnowledge;
import feedbackgenerator.controllers.algorithms.knowledge.allround.categories.ARQuestionKnowledge;
import feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories.QWDifficultyTopicKnowledge;
import feedbackgenerator.models.Quiz;
import feedbackgenerator.models.QuizAttempt;
import feedbackgenerator.models.QuizGrades;
import feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/27/2016.
 */
public class AROverallAllRoundKnowledge {
    public double findQuizGradingProgress(int userId, int quizId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<QuizAttempt> quizAttempts = quizAttempt.getAttemptDataOfAQuiz(userId, quizId);

        Quiz quiz = new Quiz();
        quiz = quiz.getQuizData(quizId);
        double quizMaxTotal = quiz.getSumGrades();

        double quizGradingProgress = 0;

        ArrayList<Double> quizTotals = new ArrayList<Double>();

        for (int i = 0; i < quizAttempts.size(); i++) {
            double quizTotal = quizAttempts.get(i).getSumGrades() / quizMaxTotal * 100;

            quizTotals.add(quizTotal);
        }

        for (int i = 0; i < quizTotals.size() - 1; i++) {
            if (quizTotals.get(i + 1) - quizTotals.get(i) < -90) {
                quizGradingProgress += -0.9;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < -70) {
                quizGradingProgress += -0.7;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < -50) {
                quizGradingProgress += -0.5;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < -30) {
                quizGradingProgress += -0.3;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < -20) {
                quizGradingProgress += -0.2;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < -10) {
                quizGradingProgress += -0.1;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < -5) {
                quizGradingProgress += -0.05;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < 0) {
                quizGradingProgress += 0;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < 5) {
                quizGradingProgress += 0.05;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < 10) {
                quizGradingProgress += 0.1;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < 20) {
                quizGradingProgress += 0.2;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < 30) {
                quizGradingProgress += 0.3;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < 50) {
                quizGradingProgress += 0.5;
            } else if (quizTotals.get(i + 1) - quizTotals.get(i) < 70) {
                quizGradingProgress += 0.7;
            } else {
                quizGradingProgress += 0.9;
            }
        }

        double averageQuizGradingProgress;
        if (quizGradingProgress != 0.0) {
            averageQuizGradingProgress = quizGradingProgress / (quizTotals.size() - 1);
        } else {
            averageQuizGradingProgress = 0;
        }

        return averageQuizGradingProgress;
    }

    /**
     * this is the average grade of a user per a particular quiz out of 10
     *
     * @param userId
     * @param quizId
     * @return
     */
    public double findAverageGrade(int userId, int quizId) throws Exception {
        QuizGrades quizGrade = new QuizGrades();
        quizGrade = quizGrade.getQuizGradesData(userId, quizId);

        double quizAverageGrade = quizGrade.getGrade() / 10;

        return quizAverageGrade;
    }

    public double findAllRoundKnowledge(int userId, int quizId) throws Exception {
        AROverallAllRoundKnowledge arOverallAllRoundKnowledge = new AROverallAllRoundKnowledge();
        double quizGradingProgress = arOverallAllRoundKnowledge.findQuizGradingProgress(userId, quizId);
        double averageGrade = arOverallAllRoundKnowledge.findAverageGrade(userId, quizId);

        ARQuestionKnowledge arQuestionKnowledge = new ARQuestionKnowledge();
        double quizAttemptProgress = arQuestionKnowledge.findQuizAttemptProgress(userId);
        double quizGrade = arQuestionKnowledge.findQuizGrade(userId);

        ARDifficultyOrTopicKnowledge arDifficultyOrTopicKnowledge = new ARDifficultyOrTopicKnowledge();
        double advancedQuestionGrade = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId, "advanced");
        double advancedQuestionProgress = arDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId, "advanced");
        double easyQuestionGrade = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId, "easy");
        double easyQuestionProgress = arDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId, "easy");

        QuizSlot quizSlot = new QuizSlot();
        ArrayList<String> differentNamesOfQuestions = quizSlot.getDifferentNamesOfQuestions();
        double averageDifficultyOrTopicGrade = 0;
        double difficultyOrTopicProgress = 0;
        double averageAdvancedTopicGrade = 0;
        double averageAdvancedTopicProgress = 0;
        double averageEasyTopicGrade = 0;
        double averageEasyTopicProgress = 0;
        for (int i = 0; i < differentNamesOfQuestions.size(); i++) {
            // topic
            averageDifficultyOrTopicGrade += arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId,
                    differentNamesOfQuestions.get(i));
            difficultyOrTopicProgress += arDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId,
                    differentNamesOfQuestions.get(i));

            //difficulty topic
            ARDifficultyTopicKnowledge arDifficultyTopicKnowledge = new ARDifficultyTopicKnowledge();
            averageAdvancedTopicGrade += arDifficultyTopicKnowledge.findTopicDifficultyGrade(userId,
                    differentNamesOfQuestions.get(i), "advanced");
            averageAdvancedTopicProgress += arDifficultyTopicKnowledge.findTopicDifficultyProgress(userId,
                    differentNamesOfQuestions.get(i), "advanced");
            averageEasyTopicGrade += arDifficultyTopicKnowledge.findTopicDifficultyGrade(userId,
                    differentNamesOfQuestions.get(i), "easy");
            averageEasyTopicProgress += arDifficultyTopicKnowledge.findTopicDifficultyProgress(userId,
                    differentNamesOfQuestions.get(i), "easy");
        }

        double totalARKnowledge = quizGradingProgress + averageGrade + quizAttemptProgress + quizGrade +
                advancedQuestionGrade + advancedQuestionProgress + easyQuestionGrade + easyQuestionProgress +
                averageDifficultyOrTopicGrade + difficultyOrTopicProgress + averageAdvancedTopicGrade +
                averageAdvancedTopicProgress + averageEasyTopicGrade + averageEasyTopicProgress;

        return totalARKnowledge;
    }
}