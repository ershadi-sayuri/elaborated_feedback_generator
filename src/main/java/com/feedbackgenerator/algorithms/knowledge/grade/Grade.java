package com.feedbackgenerator.algorithms.knowledge.grade;

import com.feedbackgenerator.models.QuestionAttempt;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/28/2016.
 */
public class Grade {
    /**
     * finds quiz grade based on the question attempts
     *
     * @param questionIds
     * @param userId
     * @return double averageQuizGrade
     * @throws Exception
     */
    public static double findQuizGrade(ArrayList<Integer> questionIds, int userId) throws Exception {
        double quizGrade = 0;

        for (int i = 0; i < questionIds.size(); i++) {
            // get attempt data of each question of the user
            QuestionAttempt questionAttempt = new QuestionAttempt();
            ArrayList<QuestionAttempt> questionAttemptDataOfAQuiz = questionAttempt.getQuestionAttemptDataOfAQuiz
                    (userId, questionIds.get(i));

            double questionAttemptGrade = 0;

            for (int j = 0; j < questionAttemptDataOfAQuiz.size(); j++) {
                if (questionAttemptDataOfAQuiz.get(j).getRightAnswer().equals(questionAttemptDataOfAQuiz.get(j).
                        getResponseSummary())) {
                    questionAttemptGrade += 1;
                }
            }

            double questionGrade = 0;
            if (questionAttemptGrade != 0) {
                questionGrade = questionAttemptGrade / questionAttemptDataOfAQuiz.size();
            }

            quizGrade += questionGrade;
        }

        double averageQuizGrade = 0;
        if (questionIds.size() > 0) {
            averageQuizGrade = quizGrade / questionIds.size();
        }

        return averageQuizGrade;
    }
}
