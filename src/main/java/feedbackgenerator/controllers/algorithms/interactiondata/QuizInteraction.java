package feedbackgenerator.controllers.algorithms.interactiondata;

import feedbackgenerator.models.Quiz;
import feedbackgenerator.models.QuizAttempt;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/20/2016.
 */
public class QuizInteraction {

    public double findQuizTimingProgress(int userId, int quizId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<QuizAttempt> quizAttempts = quizAttempt.getAttemptDataOfAQuiz(userId, quizId);

        Quiz quiz = new Quiz();
        quiz = quiz.getQuizData(quizId);
        double quizTimeLimit = quiz.getTimeLimit();

        double quizTimingProgress = 0;

        ArrayList<Long> quizTimes = new ArrayList<Long>();

        for (int i = 0; i < quizAttempts.size(); i++) {
            long quizTime = quizAttempts.get(i).getTimeFinish() - quizAttempts.get(i).getTimeStart();
            System.out.println(quizTime);
            quizTimes.add(quizTime);
        }

        if (quizTimeLimit <= 1800) {
            for (int i = 0; i < quizTimes.size() - 1; i++) {
                if (quizTimeLimit - quizTimes.get(i) <= 0) {
                    quizTimingProgress += 0.96;
                } else if (quizTimeLimit - quizTimes.get(i) < 5) {
                    quizTimingProgress += 0.7;
                } else if (quizTimeLimit - quizTimes.get(i) < 10) {
                    quizTimingProgress += 0.5;
                } else if (quizTimeLimit - quizTimes.get(i) < 15) {
                    quizTimingProgress += 0;
                } else if (quizTimeLimit - quizTimes.get(i) < 20) {
                    quizTimingProgress += -0.7;
                } else {
                    quizTimingProgress += -0.9;
                }
            }
        } else if (quizTimeLimit <= 3600) {
            for (int i = 0; i < quizTimes.size() - 1; i++) {
                if (quizTimeLimit - quizTimes.get(i) <= 0) {
                    quizTimingProgress += 0.97;
                } else if (quizTimeLimit - quizTimes.get(i) < 5) {
                    quizTimingProgress += 0.85;
                } else if (quizTimeLimit - quizTimes.get(i) < 10) {
                    quizTimingProgress += 0.8;
                } else if (quizTimeLimit - quizTimes.get(i) < 15) {
                    quizTimingProgress += 0.75;
                } else if (quizTimeLimit - quizTimes.get(i) < 20) {
                    quizTimingProgress += 0.6;
                } else if (quizTimeLimit - quizTimes.get(i) < 30) {
                    quizTimingProgress += 0;
                } else {
                    quizTimingProgress += -0.3;
                }
            }
        } else if (quizTimeLimit <= 7200) {
            for (int i = 0; i < quizTimes.size() - 1; i++) {
                if (quizTimeLimit - quizTimes.get(i) <= 0) {
                    quizTimingProgress += 0.98;
                } else if (quizTimeLimit - quizTimes.get(i) < 5) {
                    quizTimingProgress += 0.89;
                } else if (quizTimeLimit - quizTimes.get(i) < 10) {
                    quizTimingProgress += 0.82;
                } else if (quizTimeLimit - quizTimes.get(i) < 15) {
                    quizTimingProgress += 0.77;
                } else if (quizTimeLimit - quizTimes.get(i) < 20) {
                    quizTimingProgress += 0.7;
                } else if (quizTimeLimit - quizTimes.get(i) < 30) {
                    quizTimingProgress += 0.6;
                } else {
                    quizTimingProgress += 0.1;
                }
            }
        } else {
            for (int i = 0; i < quizTimes.size() - 1; i++) {
                if (quizTimeLimit - quizTimes.get(i) <= 0) {
                    quizTimingProgress += 0.99;
                } else if (quizTimeLimit - quizTimes.get(i) < 5) {
                    quizTimingProgress += 0.9;
                } else if (quizTimeLimit - quizTimes.get(i) < 10) {
                    quizTimingProgress += 0.85;
                } else if (quizTimeLimit - quizTimes.get(i) < 15) {
                    quizTimingProgress += 0.80;
                } else if (quizTimeLimit - quizTimes.get(i) < 20) {
                    quizTimingProgress += 0.77;
                } else if (quizTimeLimit - quizTimes.get(i) < 30) {
                    quizTimingProgress += 0.67;
                } else {
                    quizTimingProgress += 0.2;
                }
            }
        }

        double averageQuizTimingProgress = quizTimingProgress / (quizTimes.size());
        return averageQuizTimingProgress;
    }
}
