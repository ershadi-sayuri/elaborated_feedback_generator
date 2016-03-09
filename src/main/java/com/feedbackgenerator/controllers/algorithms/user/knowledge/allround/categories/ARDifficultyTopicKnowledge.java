package com.feedbackgenerator.controllers.algorithms.user.knowledge.allround.categories;

import com.feedbackgenerator.controllers.algorithms.user.knowledge.grade.Grade;
import com.feedbackgenerator.controllers.algorithms.user.knowledge.progress.Progress;
import com.feedbackgenerator.models.QuizAttempt;
import com.feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/27/2016.
 */
public class ARDifficultyTopicKnowledge {
    public double findTopicDifficultyProgress(int userId, String topic, String difficulty) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);

        ArrayList<Double> userQuizGrades = new ArrayList<Double>();

        for (int i = 0; i < userQuizIds.size(); i++) {
            QuizSlot quizSlot = new QuizSlot();
            // get the question ids of questions belonging to a particular quiz
            ArrayList<Integer> questionIds = quizSlot.getDifficultyAndTopicWiseQuestionIdsOfAQuiz(userQuizIds.get(i), topic, difficulty);

            Progress progress = new Progress();
            double quizGradingProgress = progress.findQuizProgress(questionIds, userId);

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

    public double findTopicDifficultyGrade(int userId, String topic, String difficulty) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);

        ArrayList<Double> userQuizGrades = new ArrayList<Double>();

        for (int i = 0; i < userQuizIds.size(); i++) {
            QuizSlot quizSlot = new QuizSlot();
            // get the question ids of questions belonging to a particular quiz
            ArrayList<Integer> questionIds = quizSlot.getDifficultyAndTopicWiseQuestionIdsOfAQuiz(userQuizIds.get(i), topic, difficulty);

            Grade grade = new Grade();
            double quizGrade = grade.findQuizGrade(questionIds, userId);

            userQuizGrades.add(quizGrade);
        }

        double quizGrade = 0;

        for (int i = 0; i < userQuizGrades.size() - 1; i++) {
            quizGrade += userQuizGrades.get(i);
        }

        double averageQuizGrade = 0;
        if (quizGrade != 0) {
            averageQuizGrade = quizGrade / userQuizGrades.size();
        }

        return averageQuizGrade;
    }
}
