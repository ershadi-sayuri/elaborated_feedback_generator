package com.feedbackgenerator.algorithms.knowledge.allround;

import com.feedbackgenerator.algorithms.knowledge.grade.Grade;
import com.feedbackgenerator.algorithms.knowledge.progress.Progress;
import com.feedbackgenerator.models.QuizAttempt;
import com.feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/27/2016.
 */
public class ARDifficultyOrTopicKnowledge {
    /**
     * find the progress of a topic or certain difficulty
     *
     * @param userId
     * @param topic
     * @return quizGradingProgress
     * @throws Exception
     */
    public static double findTopicOrDifficultyProgress(int userId, String topic) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);

        ArrayList<Double> userQuizGrades = new ArrayList<Double>();

        for (int i = 0; i < userQuizIds.size(); i++) {
            QuizSlot quizSlot = new QuizSlot();
            // get the question ids of questions belonging to a particular quiz
            ArrayList<Integer> questionIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(userQuizIds.get(i), topic);

            double quizGradingProgress = Progress.findQuizProgress(questionIds, userId);

            userQuizGrades.add(quizGradingProgress);
        }

        double quizProgress = 0;

        for (int i = 0; i < userQuizGrades.size() - 1; i++) {
            if (userQuizGrades.get(i + 1) >= userQuizGrades.get(i)) {
                quizProgress += 1;
            }
        }

        double quizGradingProgress = 0;
        if (quizProgress != 0 && userQuizGrades.size() > 1) {
            quizGradingProgress = quizProgress / (userQuizGrades.size() - 1);
        }

        return quizGradingProgress;
    }

    /**
     * find the grade obtained for a particular topic or difficulty level
     *
     * @param userId
     * @param topic
     * @return averageQuizGrade
     * @throws Exception
     */
    public static double findTopicOrDifficultyGrade(int userId, String topic) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);

        ArrayList<Double> userQuizGrades = new ArrayList<Double>();

        for (int i = 0; i < userQuizIds.size(); i++) {
            QuizSlot quizSlot = new QuizSlot();
            // get the question ids of questions belonging to a particular quiz
            ArrayList<Integer> questionIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(userQuizIds.get(i), topic);

            double quizGrade = Grade.findQuizGrade(questionIds, userId);

            userQuizGrades.add(quizGrade);
        }

        double quizGrade = 0;

        for (int i = 0; i < userQuizGrades.size(); i++) {
            quizGrade += userQuizGrades.get(i);
        }

        double averageQuizGrade = 0;
        if (quizGrade != 0 && userQuizGrades.size() > 0) {
            averageQuizGrade = quizGrade / userQuizGrades.size();
        }

        return averageQuizGrade;
    }
}
