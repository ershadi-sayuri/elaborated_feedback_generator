package feedbackgenerator.controllers.algorithms.knowledge.quizwise;

import feedbackgenerator.models.QuestionAttempts;

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
    public double findQuestionAttemptProgress(int userId, int quizId) throws Exception {
        QuestionAttempts questionAttempt = new QuestionAttempts();

        // get question attempt data of questions belonging to a particular quiz of a user
        ArrayList<QuestionAttempts> questionAttempts = questionAttempt.getQuestionAttemptDataOfAQuiz(userId, quizId);

        // get the question ids of questions belonging to a particular quiz of a user
        ArrayList<Integer> questionIds = questionAttempt.getQuestionIdsOfAQuiz(userId, quizId);

        double questionGradingProgress = 0;

        for (int i = 0; i < questionIds.size(); i++) {

            // attempts of a question
            ArrayList<Integer> attemptGrades = new ArrayList<Integer>();

            for (QuestionAttempts attempt : questionAttempts) {
                if (questionIds.get(i) == attempt.getQuestionId()) {
                    if (attempt.getRightAnswer().equals(attempt.getResponseSummary())) {
                        attemptGrades.add(1);
                    } else {
                        attemptGrades.add(0);
                    }
                }
            }

            double attemptCorrectness = 0;
            for (int j = 0; j < attemptGrades.size() - 1; j++) {
                if (attemptGrades.get(j + 1) >= attemptGrades.get(j)) {
                    attemptCorrectness += 1;
                }
            }

            double averageAttemptCorrectness = 0;
            if (attemptCorrectness != 0) {
                averageAttemptCorrectness = attemptCorrectness / attemptGrades.size();
            }

            questionGradingProgress += averageAttemptCorrectness;
        }

        double averageQuestionGradingProgress = 0;
        if (questionGradingProgress != 0) {
            averageQuestionGradingProgress = questionGradingProgress / questionIds.size();
        }

        return averageQuestionGradingProgress;
    }

    public double findAverageQuestionAttemptGrade(int userId, int quizId) throws Exception {
        QuestionAttempts questionAttempt = new QuestionAttempts();

        // get question attempt data of questions belonging to a particular quiz of a user
        ArrayList<QuestionAttempts> questionAttempts = questionAttempt.getQuestionAttemptDataOfAQuiz(userId, quizId);

        // get the question ids of questions belonging to a particular quiz of a user
        ArrayList<Integer> questionIds = questionAttempt.getQuestionIdsOfAQuiz(userId, quizId);

        double questionAttemptGrade = 0;

        for (int i = 0; i < questionIds.size(); i++) {

            // attempts of a question
            double attemptCorrectness = 0;
            int numberOfAttempts = 0;

            for (QuestionAttempts attempt : questionAttempts) {
                if (questionIds.get(i) == attempt.getQuestionId()) {
                    numberOfAttempts += 1;
                    if (attempt.getRightAnswer().equals(attempt.getResponseSummary())) {
                        attemptCorrectness += 1;
                    }
                }
            }

            double averageAttemptCorrectness = 0;
            if (attemptCorrectness != 0) {
                averageAttemptCorrectness = attemptCorrectness / numberOfAttempts;
            }

            questionAttemptGrade += averageAttemptCorrectness;
        }

        double averageQuestionAttemptGrade = 0;
        if (questionAttemptGrade != 0) {
            averageQuestionAttemptGrade = questionAttemptGrade / questionIds.size();
        }

        return averageQuestionAttemptGrade;
    }
}
