package feedbackgenerator.controllers.algorithms.knowledge;

import feedbackgenerator.models.QuizAttempt;
import feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/13/2016.
 */
public class QuizKnowledge {

    public double findQuizGradingProgress(int userId, int quizId) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<QuizAttempt> quizAttempts = quizAttempt.getQuizAttemptsData(userId, quizId);

        QuizSlot quizSlot = new QuizSlot();
        double quizMaxTotal = quizSlot.getQuizMaxTotal(quizId);
//
//        for (int i = 0; i < quizAttempts.size() - 1; i++) {
//            double quizTotal = quizAttempts.get(i).getSumGrades() / quizMaxTotal * 100;
//
//            System.out.println(quizTotal);
//        }

        return 2.0;
    }


    public static void main(String[] args) {
        QuizKnowledge quizKnowledge = new QuizKnowledge();
        try {
            quizKnowledge.findQuizGradingProgress(3, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
