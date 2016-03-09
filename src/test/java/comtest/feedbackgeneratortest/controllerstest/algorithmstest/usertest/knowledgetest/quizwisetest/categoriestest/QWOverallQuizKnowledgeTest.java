package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.knowledgetest.quizwisetest.categoriestest;

import com.feedbackgenerator.controllers.algorithms.user.knowledge.quizwise.categories.QWOverallQuizKnowledge;
import org.junit.Test;

/**
 * Created by Ershadi Sayuri on 2/25/2016.
 */
public class QWOverallQuizKnowledgeTest {

    @Test
    public void testFindQuizWiseQuizGradingProgress() throws Exception {
        QWOverallQuizKnowledge qwOverallQuizKnowledge = new QWOverallQuizKnowledge();
        double qwQuizGradingProgress = qwOverallQuizKnowledge.findQuizGradingProgress(4, 2);
        System.out.println(qwQuizGradingProgress);
    }

    @Test
    public void testFindQuizWiseAverageGrade() throws Exception {
        QWOverallQuizKnowledge qwOverallQuizKnowledge = new QWOverallQuizKnowledge();
        double qwAverageGrade = qwOverallQuizKnowledge.findAverageGrade(4, 2);
        System.out.println(qwAverageGrade);
    }
}