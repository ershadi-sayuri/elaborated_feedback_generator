package feedbackgenerator.controllers.algorithms.knowledge.grade;

import feedbackgenerator.models.QuestionAttempts;

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
     * @return
     * @throws Exception
     */
    public double findQuizGrade(ArrayList<Integer> questionIds, int userId) throws Exception {
        double quizGrade = 0;

        for (int i = 0; i < questionIds.size(); i++) {
            // get attempt data of each question of the user
            QuestionAttempts questionAttempt = new QuestionAttempts();
            ArrayList<QuestionAttempts> questionAttemptDataOfAQuiz = questionAttempt.getQuestionAttemptDataOfAQuiz(userId, questionIds.get(i));

            double questionAttemptGrade = 0;
            ArrayList<Integer> attemptGrades = new ArrayList<Integer>();

            for (int j = 0; j < questionAttemptDataOfAQuiz.size(); j++) {
                if (questionAttemptDataOfAQuiz.get(j).getRightAnswer().equals(questionAttemptDataOfAQuiz.get(j).getResponseSummary())) {
                    questionAttemptGrade += 1;
                }
            }

            double questionGrade = 0;
            if (questionAttemptGrade != 0) {
                questionGrade = questionAttemptGrade / attemptGrades.size();
            }

            quizGrade += questionGrade;
        }

        return quizGrade;
    }
}
