package com.feedbackgenerator.algorithms.knowledge.quizwise;

import com.feedbackgenerator.algorithms.knowledge.grade.Grade;
import com.feedbackgenerator.algorithms.knowledge.progress.Progress;
import com.feedbackgenerator.models.QuizSlot;

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
     * @return averageQuizGradingProgress
     * @throws Exception
     */
    public static double findQuestionAttemptProgress(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getQuestionIdsOfAQuiz(quizId);

        double quizGradingProgress = Progress.findQuizProgress(questionIds, userId);

        double averageQuizGradingProgress = 0;
        if (quizGradingProgress != 0 && questionIds.size() > 1) {
            averageQuizGradingProgress = quizGradingProgress / (questionIds.size() - 1);
        }

        return averageQuizGradingProgress;
    }

    /**
     * find average question attempt grade of a particular quiz
     *
     * @param userId
     * @param quizId
     * @return averageQuestionGrade
     * @throws Exception
     */
    public static double findAverageQuestionAttemptGrade(int userId, int quizId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getQuestionIdsOfAQuiz(quizId);

        double questionGrade = Grade.findQuizGrade(questionIds, userId);

        double averageQuestionGrade = 0;
        if (questionGrade != 0) {
            averageQuestionGrade = questionGrade / questionIds.size();
        }

        return averageQuestionGrade;
    }
}
