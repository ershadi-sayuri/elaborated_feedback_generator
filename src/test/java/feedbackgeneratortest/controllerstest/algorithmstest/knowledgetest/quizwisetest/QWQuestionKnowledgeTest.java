package feedbackgeneratortest.controllerstest.algorithmstest.knowledgetest.quizwisetest;

import feedbackgenerator.controllers.algorithms.knowledge.quizwise.QWQuestionKnowledge;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 2/25/2016.
 */
public class QWQuestionKnowledgeTest {

    @Test
    public void testFindQuestionGradingProgress() throws Exception {
        QWQuestionKnowledge qwQuestionKnowledge = new QWQuestionKnowledge();
        double questionGradingProgress = qwQuestionKnowledge.findQuestionGradingProgress(4, 2);
        System.out.println(questionGradingProgress);
    }
}