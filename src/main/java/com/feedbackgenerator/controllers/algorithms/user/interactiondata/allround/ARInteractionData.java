package com.feedbackgenerator.controllers.algorithms.user.interactiondata.allround;

import com.feedbackgenerator.controllers.algorithms.user.interactiondata.quizwise.QWInteractionData;
import com.feedbackgenerator.models.QuizAttempt;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/2/2016.
 */
public class ARInteractionData {
    public double findQuizTiming(int userId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();

        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);
        QWInteractionData qwInteractionData = new QWInteractionData();

        double quizTiming = 0;
        for (int i = 0; i < userQuizIds.size(); i++) {
            quizTiming += qwInteractionData.findQuizTiming(userId, userQuizIds.get(i));
        }

        double averageQuizTiming = 0;
        if (userQuizIds.size() != 0) {
            averageQuizTiming = quizTiming / userQuizIds.size();
        }

        return averageQuizTiming;
    }

    public double findQuizTimingProgress(int userId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();

        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);
        QWInteractionData qwInteractionData = new QWInteractionData();

        double quizTimingProgress = 0;
        for (int i = 0; i < userQuizIds.size(); i++) {
            quizTimingProgress += qwInteractionData.findQuizTimingProgress(userId, userQuizIds.get(i));
        }

        double averageQuizTimingProgress = 0;
        if (userQuizIds.size() != 0) {
            averageQuizTimingProgress = quizTimingProgress / userQuizIds.size();
        }

        return averageQuizTimingProgress;
    }
}
