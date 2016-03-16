package comtest.feedbackgeneratortest.controllerstest.algorithmstest.learningmaterialtest;

import com.feedbackgenerator.controllers.algorithms.learningmaterial.LearningMaterialRecommender;
import com.feedbackgenerator.controllers.algorithms.user.total.TotalKnowledge;
import com.feedbackgenerator.models.Knowledge;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/12/2016.
 */
public class LearningMaterialRecommenderTest {

    @Test
    public void testFindRecommendMaterial() throws Exception {
        LearningMaterialRecommender learningMaterialRecommender = new LearningMaterialRecommender();
        TotalKnowledge totalKnowledge = new TotalKnowledge();
        ArrayList<Knowledge> knowledges = totalKnowledge.calculateUserTotalKnowledge(3, 2);
        learningMaterialRecommender.filterRecommendationsByTopic(knowledges.get(1));
    }
}