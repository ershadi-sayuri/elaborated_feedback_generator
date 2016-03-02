package feedbackgenerator.controllers.algorithms.knowledge.allround.categories;

import feedbackgenerator.controllers.algorithms.knowledge.grade.Grade;
import feedbackgenerator.controllers.algorithms.knowledge.progress.Progress;
import feedbackgenerator.models.QuizAttempt;
import feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/27/2016.
 */
public class ARDifficultyOrTopicKnowledge {
    public double findTopicOrDifficultyProgress(int userId, String topic) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);

        ArrayList<Double> userQuizGrades = new ArrayList<Double>();

        for (int i = 0; i < userQuizIds.size(); i++) {
            QuizSlot quizSlot = new QuizSlot();
            // get the question ids of questions belonging to a particular quiz
            ArrayList<Integer> questionIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(userQuizIds.get(i), topic);

            Progress progress = new Progress();
            double quizGradingProgress = progress.findQuizProgress(questionIds, userId);

            userQuizGrades.add(quizGradingProgress);
        }

        double quizProgress = 0;

        for (int i = 0; i < userQuizGrades.size() - 1; i++) {
            if (userQuizGrades.get(i + 1) >= userQuizGrades.get(i)) {
                quizProgress += 1;
            }
        }

        double quizGradingProgress = 0;
        if (quizProgress != 0) {
            quizGradingProgress = quizProgress / (userQuizGrades.size() - 1);
        }

        return quizGradingProgress;
    }

    public double findTopicOrDifficultyGrade(int userId, String topic) throws Exception {
        QuizAttempt quizAttempt = new QuizAttempt();
        ArrayList<Integer> userQuizIds = quizAttempt.getUserQuizIds(userId);

        ArrayList<Double> userQuizGrades = new ArrayList<Double>();

        for (int i = 0; i < userQuizIds.size(); i++) {
            QuizSlot quizSlot = new QuizSlot();
            // get the question ids of questions belonging to a particular quiz
            ArrayList<Integer> questionIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(userQuizIds.get(i), topic);

            Grade grade = new Grade();
            double quizGrade = grade.findQuizGrade(questionIds, userId);

            userQuizGrades.add(quizGrade);
        }

        double quizGrade = 0;

        for (int i = 0; i < userQuizGrades.size() - 1; i++) {
            quizGrade += userQuizGrades.get(i);
        }

        double averageQuizGrade = 0;
        if (quizGrade != 0) {
            averageQuizGrade = quizGrade / userQuizGrades.size();
        }

        return averageQuizGrade;
    }
}
