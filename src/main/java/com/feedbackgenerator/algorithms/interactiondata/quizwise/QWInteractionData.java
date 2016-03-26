package com.feedbackgenerator.algorithms.interactiondata.quizwise;

import com.feedbackgenerator.models.Quiz;
import com.feedbackgenerator.models.QuizAttempt;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/20/2016.
 */
public class QWInteractionData {

    public double findQuizTiming(int userId, int quizId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<QuizAttempt> quizAttempts = quizAttempt.getAttemptDataOfAQuiz(userId, quizId);

        Quiz quiz = new Quiz();
        quiz = quiz.getQuizData(quizId);
        double quizTimeLimit = quiz.getTimeLimit();

        double quizTiming = 0;

        ArrayList<Long> quizTimes = new ArrayList<Long>();

        for (int i = 0; i < quizAttempts.size(); i++) {
            long quizTime = quizAttempts.get(i).getTimeFinish() - quizAttempts.get(i).getTimeStart();
            quizTimes.add(quizTime);
        }

        if (quizTimeLimit <= 1800) {
            for (int i = 0; i < quizTimes.size(); i++) {
                if (quizTimeLimit - quizTimes.get(i) <= 0) {
                    quizTiming += 0.96;
                } else if (quizTimeLimit - quizTimes.get(i) < 5) {
                    quizTiming += 0.7;
                } else if (quizTimeLimit - quizTimes.get(i) < 10) {
                    quizTiming += 0.5;
                } else if (quizTimeLimit - quizTimes.get(i) < 15) {
                    quizTiming += 0;
                } else if (quizTimeLimit - quizTimes.get(i) < 20) {
                    quizTiming += -0.7;
                } else {
                    quizTiming += -0.9;
                }
            }
        } else if (quizTimeLimit <= 3600) {
            for (int i = 0; i < quizTimes.size(); i++) {
                if (quizTimeLimit - quizTimes.get(i) <= 0) {
                    quizTiming += 0.97;
                } else if (quizTimeLimit - quizTimes.get(i) < 5) {
                    quizTiming += 0.85;
                } else if (quizTimeLimit - quizTimes.get(i) < 10) {
                    quizTiming += 0.8;
                } else if (quizTimeLimit - quizTimes.get(i) < 15) {
                    quizTiming += 0.75;
                } else if (quizTimeLimit - quizTimes.get(i) < 20) {
                    quizTiming += 0.6;
                } else if (quizTimeLimit - quizTimes.get(i) < 30) {
                    quizTiming += 0;
                } else {
                    quizTiming += -0.3;
                }
            }
        } else if (quizTimeLimit <= 7200) {
            for (int i = 0; i < quizTimes.size(); i++) {
                if (quizTimeLimit - quizTimes.get(i) <= 0) {
                    quizTiming += 0.98;
                } else if (quizTimeLimit - quizTimes.get(i) < 5) {
                    quizTiming += 0.89;
                } else if (quizTimeLimit - quizTimes.get(i) < 10) {
                    quizTiming += 0.82;
                } else if (quizTimeLimit - quizTimes.get(i) < 15) {
                    quizTiming += 0.77;
                } else if (quizTimeLimit - quizTimes.get(i) < 20) {
                    quizTiming += 0.7;
                } else if (quizTimeLimit - quizTimes.get(i) < 30) {
                    quizTiming += 0.6;
                } else {
                    quizTiming += 0.1;
                }
            }
        } else {
            for (int i = 0; i < quizTimes.size(); i++) {
                if (quizTimeLimit - quizTimes.get(i) <= 0) {
                    quizTiming += 0.99;
                } else if (quizTimeLimit - quizTimes.get(i) < 5) {
                    quizTiming += 0.9;
                } else if (quizTimeLimit - quizTimes.get(i) < 10) {
                    quizTiming += 0.85;
                } else if (quizTimeLimit - quizTimes.get(i) < 15) {
                    quizTiming += 0.80;
                } else if (quizTimeLimit - quizTimes.get(i) < 20) {
                    quizTiming += 0.77;
                } else if (quizTimeLimit - quizTimes.get(i) < 30) {
                    quizTiming += 0.67;
                } else {
                    quizTiming += 0.2;
                }
            }
        }

        double averageQuizTiming = 0;
        if (quizTiming != 0) {
            averageQuizTiming = quizTiming / quizTimes.size();
        }
        return averageQuizTiming;
    }

    public double findQuizTimingProgress(int userId, int quizId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<QuizAttempt> quizAttempts = quizAttempt.getAttemptDataOfAQuiz(userId, quizId);

        double quizTimingProgress = 0;

        ArrayList<Long> quizTimes = new ArrayList<Long>();

        for (int i = 0; i < quizAttempts.size(); i++) {
            long quizTime = quizAttempts.get(i).getTimeFinish() - quizAttempts.get(i).getTimeStart();
            quizTimes.add(quizTime);
        }

        for (int i = 0; i < quizTimes.size() - 1; i++) {
            if (quizTimes.get(i + 1) > quizTimes.get(i)) {
                quizTimingProgress += 1;
            }
        }

        double averageQuizTimingProgress = 0;
        if (quizTimingProgress != 0 && quizTimes.size() > 1) {
            averageQuizTimingProgress = quizTimingProgress / (quizTimes.size() - 1);
        }
        return averageQuizTimingProgress;
    }
}
