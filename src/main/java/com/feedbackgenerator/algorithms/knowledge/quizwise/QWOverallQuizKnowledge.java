package com.feedbackgenerator.algorithms.knowledge.quizwise;

import com.feedbackgenerator.models.Quiz;
import com.feedbackgenerator.models.QuizAttempt;
import com.feedbackgenerator.models.QuizGrade;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/13/2016.
 */
public class QWOverallQuizKnowledge {
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
        if (quizGradingProgress != 0 && quizTotals.size() > 1) {
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
        QuizGrade quizGrade = new QuizGrade();
        quizGrade = quizGrade.getQuizGradesData(userId, quizId);

        double quizAverageGrade = quizGrade.getGrade() / 10;

        return quizAverageGrade;
    }
}
