package com.feedbackgenerator.algorithms.knowledge.quizwise;

import com.feedbackgenerator.algorithms.knowledge.grade.Grade;
import com.feedbackgenerator.algorithms.knowledge.progress.Progress;
import com.feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/27/2016.
 */
public class QWDifficultyTopicKnowledge {
    public double findTopicDifficultyProgress(int userId, int quizId, String topic, String difficulty) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getDifficultyAndTopicWiseQuestionIdsOfAQuiz(quizId, topic, difficulty);

        Progress progress = new Progress();
        double quizGradingProgress = progress.findQuizProgress(questionIds, userId);

        double averageQuizGradingProgress = 0;
        if (quizGradingProgress != 0 && questionIds.size() > 1) {
            averageQuizGradingProgress = quizGradingProgress / (questionIds.size() - 1);
        }

        return averageQuizGradingProgress;
    }

    public double findTopicDifficultyGrade(int userId, int quizId, String topic, String difficulty) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getDifficultyAndTopicWiseQuestionIdsOfAQuiz(quizId, topic, difficulty);

        Grade grade = new Grade();
        double quizGrade = grade.findQuizGrade(questionIds, userId);

        double averageQuizGrade = 0;
        if (quizGrade != 0) {
            averageQuizGrade = quizGrade / questionIds.size();
        }

        return averageQuizGrade;
    }
}
