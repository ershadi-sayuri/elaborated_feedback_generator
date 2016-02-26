package feedbackgenerator.controllers.algorithms.knowledge.quizwise;

import feedbackgenerator.models.QuestionAttempts;
import feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;


/**
 * Created by Ershadi Sayuri on 2/13/2016.
 */
public class QWQuestionKnowledge {

    /**
     * find the grading progress of a question based on its attempts by a particular user and a quiz
     *
     * @param userId
     * @param quizId
     * @return
     * @throws Exception
     */
    public double findQuestionGradingProgress(int userId, int quizId) throws Exception {
        QuestionAttempts questionAttempt = new QuestionAttempts();

        // gets the unique question ids of a user
        ArrayList<Integer> questionIds = questionAttempt.getQuestionIdsOfAQuizOfAUser(userId, quizId);

        double questionGradingProgress = 0;

        for (int i = 0; i < questionIds.size(); i++) {
            // gets the question attempt data for each question id of a user
            ArrayList<QuestionAttempts> questionAttempts = questionAttempt.getQuestionAttemptsData(questionIds.get(i));

            double attemptCorrectness = 0;
            for (int j = 0; j < questionAttempts.size() - j; j++) {
                if (questionAttempts.get(j).getRightAnswer().equals(questionAttempts.get(j).getResponseSummary())) {
                    attemptCorrectness += 1;
                }
            }

            double averageAttemptCorrectness;
            if (attemptCorrectness != 0) {
                averageAttemptCorrectness = attemptCorrectness / questionAttempts.size();
            } else {
                averageAttemptCorrectness = 0;
            }

            questionGradingProgress += averageAttemptCorrectness;
        }

        double averageQuestionGradingProgress = questionGradingProgress / questionIds.size();

        return averageQuestionGradingProgress;
    }
}
