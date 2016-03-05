package feedbackgeneratortest.controllerstest.algorithmstest.knowledgetest.quizwisetest.categoriestest;

import feedbackgenerator.controllers.algorithms.knowledge.quizwise.total.QWOverallQuizKnowledge;
import org.junit.Test;

/**
 * Created by Ershadi Sayuri on 2/25/2016.
 */
public class QWOverallQuizKnowledgeTest {

    @Test
    public void testFindQuizWiseQuizGradingProgress() throws Exception {
        QWOverallQuizKnowledge qwOverallQuizKnowledge = new QWOverallQuizKnowledge();
        double qwQuizGradingProgress = qwOverallQuizKnowledge.findQuizKnowledge(4, 2);
        System.out.println(qwQuizGradingProgress);
    }

    @Test
    public void testFindQuizWiseAverageGrade() throws Exception {
        QWOverallQuizKnowledge qwOverallQuizKnowledge = new QWOverallQuizKnowledge();
        double qwAverageGrade = qwOverallQuizKnowledge.findQuizKnowledge(4, 2);
        System.out.println(qwAverageGrade);
    }
}