package com.feedbackgenerator.controllers.algorithms.user.learningstyle;

import com.feedbackgenerator.enums.FSLSModels;
import com.feedbackgenerator.models.QuestionAttempts;
import com.feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 3/9/2016.
 */
public class LearningStyle {
    public ArrayList<FSLSModels> findLearningStyleModel(int userId) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> activeOrReflectiveIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(4, "Active / Reflective");
        ArrayList<Integer> sensoryOrIntuitiveIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(4, "Sensing / Intuitive");
        ArrayList<Integer> visualOrVerbalIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(4, "Visual / Verbal");
        ArrayList<Integer> sequentialOrGlobalIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(4, "Sequential / Global");

        ArrayList<FSLSModels> learningStyles = new ArrayList<FSLSModels>();

        double activeOrReflectiveGrade = calculateLearningStyle(activeOrReflectiveIds, userId);
        if (activeOrReflectiveGrade > 0) {
            learningStyles.add(FSLSModels.ACTIVE);
        } else {
            learningStyles.add(FSLSModels.REFLECTIVE);
        }

        double sensoryOrIntuitiveGrade = calculateLearningStyle(sensoryOrIntuitiveIds, userId);
        if (sensoryOrIntuitiveGrade > 0) {
            learningStyles.add(FSLSModels.SENSORY);
        } else {
            learningStyles.add(FSLSModels.INTUITIVE);
        }

        double visualOrVerbalGrade = calculateLearningStyle(visualOrVerbalIds, userId);
        if (visualOrVerbalGrade > 0) {
            learningStyles.add(FSLSModels.VISUAL);
        } else {
            learningStyles.add(FSLSModels.VERBAL);
        }

        double sequentialOrGlobalGrade = calculateLearningStyle(sequentialOrGlobalIds, userId);
        if (sequentialOrGlobalGrade > 0) {
            learningStyles.add(FSLSModels.SEQUENTIAL);
        } else {
            learningStyles.add(FSLSModels.GLOBAL);
        }

        return learningStyles;
    }

    private double calculateLearningStyle(ArrayList<Integer> questionIds, int userId) throws Exception {
        double grade = 0;
        for (int questionId : questionIds) {
            QuestionAttempts questionAttempt = new QuestionAttempts();
            ArrayList<QuestionAttempts> questionAttemptDataOfAQuiz = questionAttempt.getQuestionAttemptDataOfAQuiz(userId, questionId);

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

