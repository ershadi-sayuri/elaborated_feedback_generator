package comtest.feedbackgeneratortest.controllerstest.algorithmstest.learningmaterialtest;

import com.feedbackgenerator.other.InitialLearningMaterialRecommender;
import com.feedbackgenerator.algorithms.total.TotalKnowledge;
import org.junit.Test;

/**
 * Created by Ershadi Sayuri on 3/12/2016.
 */
public class InitialLearningMaterialRecommenderTest {

    @Test
    public void testFindRecommendMaterial() throws Exception {
        InitialLearningMaterialRecommender initialLearningMaterialRecommender = new InitialLearningMaterialRecommender();
        TotalKnowledge totalKnowledge = new TotalKnowledge();
//        ArrayList<Knowledge> knowledges = totalKnowledge.calculateUserTotalKnowledge(3, 2, true);
//        initialLearningMaterialRecommender.filterRecommendationsByTopic(knowledges.get(1));
    }
}