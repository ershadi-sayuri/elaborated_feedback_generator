package feedbackgeneratortest.controllerstest.algorithmstest.knowledgetest.quizwisetest;

import feedbackgenerator.controllers.algorithms.knowledge.quizwise.QWQuizKnowledge;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 2/25/2016.
 */
public class QWQuizKnowledgeTest {

    @Test
    public void testFindQuizWiseQuizGradingProgress() throws Exception {
        QWQuizKnowledge qwQuizKnowledge = new QWQuizKnowledge();
        double qwQuizGradingProgress = qwQuizKnowledge.findQWQuizGradingProgress(4, 2);
        System.out.println(qwQuizGradingProgress);
    }

    @Test
    public void testFindQuizWiseAverageGrade() throws Exception {
        QWQuizKnowledge qwQuizKnowledge = new QWQuizKnowledge();
        double qwAverageGrade = qwQuizKnowledge.findQWAverageGrade(4, 2);
        System.out.println(qwAverageGrade);
    }
}