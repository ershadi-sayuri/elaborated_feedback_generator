package feedbackgeneratortest.controllerstest.algorithmstest.knowledgetest.quizwisetest.categoriestest;

import feedbackgenerator.controllers.algorithms.knowledge.quizwise.categories.QWQuestionKnowledge;
import org.junit.Test;

/**
 * Created by Ershadi Sayuri on 2/25/2016.
 */
public class QWQuestionKnowledgeTest {

    @Test
    public void testFindQuestionAttemptProgress() throws Exception {
        QWQuestionKnowledge qwQuestionKnowledge = new QWQuestionKnowledge();
        double quizGradingProgress = qwQuestionKnowledge.findQuestionAttemptProgress(3, 2);
        System.out.println(quizGradingProgress);
    }

    @Test
    public void testFindAverageQuestionAttemptGrade() throws Exception {
        QWQuestionKnowledge qwQuestionKnowledge = new QWQuestionKnowledge();
        double quizGradingProgress = qwQuestionKnowledge.findAverageQuestionAttemptGrade(3, 2);
        System.out.println(quizGradingProgress);
    }
}