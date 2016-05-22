package com.feedbackgenerator.algorithms.knowledge.progress;

import com.feedbackgenerator.models.QuestionAttempt;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/28/2016.
 */
public class Progress {
    /**
     * find the progress (improvement) of different categories
     *
     * @param questionIds
     * @param userId
     * @return double quizGradingProgress
     * @throws Exception
     */
    public static double findQuizProgress(ArrayList<Integer> questionIds, int userId) throws Exception {
        double questionGradingProgress = 0;

        for (int i = 0; i < questionIds.size(); i++) {
            // get attempt data of each question of the user
            QuestionAttempt questionAttempt = new QuestionAttempt();
            ArrayList<QuestionAttempt> questionAttemptDataOfAQuiz = questionAttempt.getQuestionAttemptDataOfAQuiz(userId, questionIds.get(i));

            double questionAttemptProgress = 0;
            ArrayList<Integer> attemptGrades = new ArrayList<Integer>();

            for (int j = 0; j < questionAttemptDataOfAQuiz.size(); j++) {
                if (questionAttemptDataOfAQuiz.get(j).getRightAnswer().equals(questionAttemptDataOfAQuiz.get(j).getResponseSummary())) {
                    attemptGrades.add(1);
                } else {
                    attemptGrades.add(0);
                }
            }

            for (int j = 0; j < attemptGrades.size() - 1; j++) {
                if (attemptGrades.get(j + 1) >= attemptGrades.get(j)) {
                    questionAttemptProgress += 1;
                }
            }

            double averageAttemptGradingProgress = 0;
            if (questionAttemptProgress != 0 && attemptGrades.size() > 1) {
                averageAttemptGradingProgress = questionAttemptProgress / (attemptGrades.size() - 1);
            }

            questionGradingProgress += averageAttemptGradingProgress;
        }

        // progress out of 1
        double quizGradingProgress = questionGradingProgress / questionIds.size();
        return quizGradingProgress;
    }
}
