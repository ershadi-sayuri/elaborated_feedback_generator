package com.feedbackgenerator.algorithms.interactiondata;

import com.feedbackgenerator.models.History;
import com.feedbackgenerator.models.QuizAttempt;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 4/17/2016.
 */
public class Interaction {

    /**
     * find time spent reading materials
     *
     * @param topic
     * @return value
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static long calculateTimSpentViewingMaterial(String topic) throws SQLException, ClassNotFoundException {
        History history = new History();
        long topicTime = history.getTopicViewingDuration(topic);
        long totalTime = history.getTotalBrowsingDuration();

        long value = 0;
        if (topicTime > 0 && totalTime > 0) {
            value = topicTime / totalTime;
        }

        return value;
    }

    /**
     * Find number of attempts of a quiz
     *
     * @param userId
     * @param quizId
     * @return numberOfAttempts
     * @throws Exception
     */
    public static double findQWNumberOfAttempts(int userId, int quizId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        double numberOfAttempts = quizAttempt.getNumberOfAttempts(userId, quizId);

        return numberOfAttempts;
    }

    /**
     *
     * @param userId
     * @return numberOfAttempts
     * @throws Exception
     */
    public static double findARNumberOfAttempts(int userId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> quizIds = quizAttempt.getUserQuizIds(userId);

        double numberOfQuizAttempts = 0;
        for (int quizId : quizIds) {
            numberOfQuizAttempts += quizAttempt.getNumberOfAttempts(userId, quizId);
        }

        double numberOfAttempts = 0;
        if (quizIds.size() != 0) {
            numberOfAttempts = numberOfQuizAttempts / quizIds.size();
        }

        return numberOfAttempts;
    }
}
