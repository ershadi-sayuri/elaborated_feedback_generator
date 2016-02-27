package feedbackgeneratortest.controllerstest.algorithmstest.knowledgetest.quizwisetest;

import feedbackgenerator.controllers.algorithms.knowledge.quizwise.QWQuestionKnowledge;
import org.junit.Test;

/**
 * Created by Ershadi Sayuri on 2/25/2016.
 */
public class QWQuestionKnowledgeTest {

    @Test
    public void testFindQuestionAttemptProgress() throws Exception {
        QWQuestionKnowledge qwQuestionKnowledge = new QWQuestionKnowledge();
        double questionGradingProgress = qwQuestionKnowledge.findQuestionAttemptProgress(3, 2);
        System.out.println(questionGradingProgress);
    }

    @Test
    public void testFindAverageQuestionAttemptGrade() throws Exception {
        QWQuestionKnowledge qwQuestionKnowledge = new QWQuestionKnowledge();
        double questionGradingProgress = qwQuestionKnowledge.findAverageQuestionAttemptGrade(3, 2);
        System.out.println(questionGradingProgress);
    }
}