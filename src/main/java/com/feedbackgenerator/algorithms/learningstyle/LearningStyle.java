package com.feedbackgenerator.algorithms.learningstyle;

import com.feedbackgenerator.models.QuestionAttempt;
import com.feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/9/2016.
 */
public class LearningStyle {
    /**
     * finding learning style model value of an user
     *
     * @param userId
     * @return ArrayList<Integer> learningStyles
     * @throws Exception
     */
    public static ArrayList<Integer> findLearningStyleModel(int userId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> activeOrReflectiveIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(4, "Active / Reflective");
        ArrayList<Integer> sensoryOrIntuitiveIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(4, "Sensing / Intuitive");
        ArrayList<Integer> visualOrVerbalIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(4, "Visual / Verbal");
        ArrayList<Integer> sequentialOrGlobalIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(4, "Sequential / Global");

        ArrayList<Integer> learningStyles = new ArrayList<Integer>();

        int activeOrReflectiveGrade = calculateLearningStyle(activeOrReflectiveIds, userId);
        learningStyles.add(activeOrReflectiveGrade);

        int sensoryOrIntuitiveGrade = calculateLearningStyle(sensoryOrIntuitiveIds, userId);
        learningStyles.add(sensoryOrIntuitiveGrade);

        int visualOrVerbalGrade = calculateLearningStyle(visualOrVerbalIds, userId);
        learningStyles.add(visualOrVerbalGrade);

        int sequentialOrGlobalGrade = calculateLearningStyle(sequentialOrGlobalIds, userId);
        learningStyles.add(sequentialOrGlobalGrade);

        return learningStyles;
    }

    /**
     * calculate value for the learning style based on FSLSM
     *
     * @param questionIds
     * @param userId
     * @return int grade
     * @throws Exception
     */
    private static int calculateLearningStyle(ArrayList<Integer> questionIds, int userId) throws Exception {
        int grade = 0;
        for (int questionId : questionIds) {
            QuestionAttempt questionAttempt = new QuestionAttempt();
            ArrayList<QuestionAttempt> questionAttemptDataOfAQuiz = questionAttempt.getQuestionAttemptDataOfAQuiz(userId, questionId);

            if (questionAttemptDataOfAQuiz.size() > 0) {
                if (questionAttemptDataOfAQuiz.get(0).getRightAnswer().equals(questionAttemptDataOfAQuiz.get(0).getResponseSummary())) {
                    grade += 1;
                } else {
                    grade -= 1;
                }
            }
        }

        return grade;
    }
}

