package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.knowledgetest.allroundtest.categorytest;

import com.feedbackgenerator.controllers.algorithms.user.knowledge.allround.categories.ARQuestionKnowledge;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ershadi Sayuri on 3/4/2016.
 */
public class ARQuestionKnowledgeTest {

    @Test
    public void testFindQuizAttemptProgress() throws Exception {
        ARQuestionKnowledge arQuestionKnowledge = new ARQuestionKnowledge();

        double quizAttemptProgress1 = arQuestionKnowledge.findQuizAttemptProgress(4);
        System.out.println(quizAttemptProgress1);

        double quizAttemptProgress2 = arQuestionKnowledge.findQuizAttemptProgress(3);
        System.out.println(quizAttemptProgress2);

        double quizAttemptProgress3 = arQuestionKnowledge.findQuizAttemptProgress(6);
        assertEquals(0, quizAttemptProgress3, 0);

        double quizAttemptProgress4 = arQuestionKnowledge.findQuizAttemptProgress(4545);
        assertEquals(0, quizAttemptProgress4, 0);
    }

    @Test
    public void testFindQuizGrade() throws Exception {
        ARQuestionKnowledge arQuestionKnowledge = new ARQuestionKnowledge();

        double quizAttemptProgress1 = arQuestionKnowledge.findQuizGrade(4);
        System.out.println(quizAttemptProgress1);

        double quizAttemptProgress2 = arQuestionKnowledge.findQuizGrade(3);
        System.out.println(quizAttemptProgress2);

        double quizAttemptProgress3 = arQuestionKnowledge.findQuizGrade(6);
        assertEquals(0, quizAttemptProgress3, 0);

        double quizAttemptProgress4 = arQuestionKnowledge.findQuizGrade(4545);
        assertEquals(0, quizAttemptProgress4, 0);
    }
}