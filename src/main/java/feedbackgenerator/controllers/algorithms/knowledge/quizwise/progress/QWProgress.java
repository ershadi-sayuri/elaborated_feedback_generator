package feedbackgenerator.controllers.algorithms.knowledge.quizwise.progress;

import feedbackgenerator.models.QuestionAttempts;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/28/2016.
 */
public class QWProgress {
    public double findQuizProgress(ArrayList<Integer> questionIds, int userId) throws Exception {
        double questionGradingProgress = 0;

        for (int i = 0; i < questionIds.size(); i++) {
            // get attempt data of each question of the user
            QuestionAttempts questionAttempt = new QuestionAttempts();
            ArrayList<QuestionAttempts> questionAttemptDataOfAQuiz = questionAttempt.getQuestionAttemptDataOfAQuiz(userId, questionIds.get(i));

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

            double averageAttemptProgress = 0;
            if (questionAttemptProgress != 0) {
                averageAttemptProgress = questionAttemptProgress / (attemptGrades.size() - 1);
            }

            questionGradingProgress += averageAttemptProgress;
        }

        return questionGradingProgress;
    }
}
