package com.feedbackgenerator.controllers.algorithms.user.knowledge.allround.categories;

import com.feedbackgenerator.models.QuizAttempt;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/27/2016.
 */
public class ARQuestionKnowledge {
    public double findQuizAttemptProgress(int userId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);

        double userProgress = 0;

        for (int i = 0; i < userQuizIds.size(); i++) {
            ArrayList<QuizAttempt> quizAttempts = quizAttempt.getUserQuizAttempts(userQuizIds.get(i));

            double attemptProgress = 0;
            for (int j = 0; j < quizAttempts.size() - 1; j++) {
                if (quizAttempts.get(j + 1).getSumGrades() > quizAttempts.get(j + 1).getSumGrades()) {
                    attemptProgress += 1;
                }
            }

            double quizProgress = 0;
            if (attemptProgress != 0 && quizAttempts.size() > 1) {
                quizProgress = attemptProgress / (quizAttempts.size() - 1);
            }

            userProgress += quizProgress;
        }

        double averageUserProgress = 0;
        if (userProgress != 0) {
            averageUserProgress = userProgress / userQuizIds.size();
        }

        return averageUserProgress;
    }

    public double findQuizGrade(int userId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);

        double userGrade = 0;

        for (int i = 0; i < userQuizIds.size(); i++) {
            ArrayList<QuizAttempt> quizAttempts = quizAttempt.getUserQuizAttempts(userQuizIds.get(i));

            double quizGrade = 0;

            for (int j = 0; j < quizAttempts.size() - 1; j++) {
                quizGrade += quizAttempts.get(j).getSumGrades();
            }

            double averageQuizGrade = 0;
            if (quizGrade != 0) {
                averageQuizGrade = quizGrade / quizAttempts.size();
            }

            userGrade += averageQuizGrade;
        }

        double averageUserGrade = 0;
        if (userGrade != 0) {
            averageUserGrade = userGrade / userQuizIds.size();
        }

        return averageUserGrade;
    }
}
