package feedbackgenerator.controllers.algorithms.knowledge.quizwise.grade;

import feedbackgenerator.models.QuestionAttempts;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/28/2016.
 */
public class QWGrade {
    public double findQuizGrade(ArrayList<Integer> questionIds, int userId) throws Exception {
        double questionGrade = 0;

        for (int i = 0; i < questionIds.size(); i++) {
            // get attempt data of each question of the user
            QuestionAttempts questionAttempt = new QuestionAttempts();
            ArrayList<QuestionAttempts> questionAttemptDataOfAQuiz = questionAttempt.getQuestionAttemptDataOfAQuiz(userId, questionIds.get(i));

            double questionAttemptGrade = 0;
            ArrayList<Integer> attemptGrades = new ArrayList<Integer>();

            for (int j = 0; j < questionAttemptDataOfAQuiz.size(); j++) {
                if (questionAttemptDataOfAQuiz.get(j).getRightAnswer().equals(questionAttemptDataOfAQuiz.get(j).getResponseSummary())) {
                    questionAttemptGrade += questionAttemptGrade;
                }
            }

            double averageAttemptGrade = 0;
            if (questionAttemptGrade != 0) {
                averageAttemptGrade = questionAttemptGrade / attemptGrades.size();
            }

            questionGrade += averageAttemptGrade;
        }

        return questionGrade;
    }
}
