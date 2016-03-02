package feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories;

import feedbackgenerator.controllers.algorithms.knowledge.grade.Grade;
import feedbackgenerator.controllers.algorithms.knowledge.progress.Progress;
import feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/13/2016.
 */
public class QWDifficultyOrTopicKnowledge {
    public double findDifficultyOrTopicProgress(int userId, int quizId, String topic) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(quizId, topic);

        Progress progress = new Progress();
        double quizGradingProgress = progress.findQuizProgress(questionIds, userId);

        double averageQuizGradingProgress = 0;
        if (quizGradingProgress != 0) {
            averageQuizGradingProgress = quizGradingProgress / (questionIds.size() - 1);
        }

        return averageQuizGradingProgress;
    }

    public double findAverageDifficultyOrTopicGrade(int userId, int quizId, String topic) throws Exception {
        QuizSlot quizSlot = new QuizSlot();
        // get the question ids of questions belonging to a particular quiz
        ArrayList<Integer> questionIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(quizId, topic);

        Grade grade = new Grade();
        double quizGrade = grade.findQuizGrade(questionIds, userId);

        double averageQuizGrade = 0;
        if (quizGrade != 0) {
            averageQuizGrade = quizGrade / questionIds.size();
        }

        return averageQuizGrade;
    }
}
