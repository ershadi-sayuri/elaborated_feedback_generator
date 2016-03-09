package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.knowledgetest.allroundtest.categorytest;

import com.feedbackgenerator.controllers.algorithms.user.knowledge.allround.categories.ARDifficultyOrTopicKnowledge;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Ershadi Sayuri on 3/4/2016.
 */
public class ARDifficultyOrTopicKnowledgeTest {

    @Test
    public void testFindTopicOrDifficultyProgress() throws Exception {
        ARDifficultyOrTopicKnowledge arDifficultyOrTopicKnowledge = new ARDifficultyOrTopicKnowledge();

        double topicOrDifficultyProgress1 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(4, "a");
        assertEquals(0, topicOrDifficultyProgress1, 0);

        double topicOrDifficultyProgress2 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(4, "easy");
        assertEquals(0, topicOrDifficultyProgress2, 0);

        double topicOrDifficultyProgress3 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(4, "advanced");
        assertEquals(0, topicOrDifficultyProgress3, 0);

        double topicOrDifficultyProgress4 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(4, "exceptions");
        assertEquals(0, topicOrDifficultyProgress4, 0);

        double topicOrDifficultyProgress5 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(900, "advanced");
        assertEquals(0, topicOrDifficultyProgress5, 0);
    }

    @Test
    public void testFindTopicOrDifficultyGrade() throws Exception {
        ARDifficultyOrTopicKnowledge arDifficultyOrTopicKnowledge = new ARDifficultyOrTopicKnowledge();
        double topicOrDifficultyGrade1 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(3, "easy");
        assertNotEquals(0, topicOrDifficultyGrade1, 0);
        System.out.println(topicOrDifficultyGrade1);

        double topicOrDifficultyGrade2 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(3, "advanced");
        assertNotEquals(0, topicOrDifficultyGrade2, 0);
        System.out.println(topicOrDifficultyGrade2);

        double topicOrDifficultyGrade3 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(4, "advanced");
        assertNotEquals(0, topicOrDifficultyGrade3, 0);
        System.out.println(topicOrDifficultyGrade3);

        double topicOrDifficultyGrade4 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(4, "easy");
        assertNotEquals(0, topicOrDifficultyGrade4, 0);
        System.out.println(topicOrDifficultyGrade4);

        double topicOrDifficultyGrade5 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(4, "exceptions");
        assertNotEquals(0, topicOrDifficultyGrade5, 0);
        System.out.println(topicOrDifficultyGrade5);

        double topicOrDifficultyGrade6 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(4, "basic");
        assertEquals(0, topicOrDifficultyGrade6, 0);
        System.out.println(topicOrDifficultyGrade6);

        double topicOrDifficultyGrade7 = arDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(4, "dsd");
        assertEquals(0, topicOrDifficultyGrade7, 0);
        System.out.println(topicOrDifficultyGrade7);
    }
}