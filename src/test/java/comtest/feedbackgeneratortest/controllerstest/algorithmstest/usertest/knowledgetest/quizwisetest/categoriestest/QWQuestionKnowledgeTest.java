package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.knowledgetest.quizwisetest.categoriestest;

import com.feedbackgenerator.controllers.algorithms.user.knowledge.quizwise.categories.QWQuestionKnowledge;
import org.junit.Test;

/**
 * Created by Ershadi Sayuri on 2/25/2016.
 */
public class QWQuestionKnowledgeTest {

    @Test
    public void testFindQuestionAttemptProgress() throws Exception {
        QWQuestionKnowledge qwQuestionKnowledge = new QWQuestionKnowledge();
        double quizGradingProgress = qwQuestionKnowledge.findQuestionAttemptProgress(4, 2);
        System.out.println(quizGradingProgress);
    }

    @Test
    public void testFindAverageQuestionAttemptGrade() throws Exception {
        QWQuestionKnowledge qwQuestionKnowledge = new QWQuestionKnowledge();
        double quizGradingProgress = qwQuestionKnowledge.findAverageQuestionAttemptGrade(4, 2);
        System.out.println(quizGradingProgress);
    }
}