package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.knowledgetest.allroundtest.categorytest;

import com.feedbackgenerator.algorithms.knowledge.allround.ARDifficultyTopicKnowledge;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ershadi Sayuri on 3/4/2016.
 */
public class ARDifficultyTopicKnowledgeTest {

    @Test
    public void testFindTopicDifficultyProgress() throws Exception {
        ARDifficultyTopicKnowledge arDifficultyTopicKnowledge = new ARDifficultyTopicKnowledge();

        double topicDifficultyProgress1 = arDifficultyTopicKnowledge.findTopicDifficultyProgress(366, "a", "a");
        assertEquals(0, topicDifficultyProgress1, 0);
    }

    @Test
    public void testFindTopicDifficultyGrade() throws Exception {
        ARDifficultyTopicKnowledge arDifficultyTopicKnowledge = new ARDifficultyTopicKnowledge();

        double topicDifficultyGrade1 = arDifficultyTopicKnowledge.findTopicDifficultyGrade(3, "flow control, easy", "advanced");
        System.out.println(topicDifficultyGrade1);
    }
}