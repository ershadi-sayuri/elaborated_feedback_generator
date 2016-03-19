package comtest.feedbackgeneratortest.controllerstest.algorithmstest.recommendationtest;

import com.feedbackgenerator.controllers.algorithms.recommendation.collaborative.CollaborativeFiltering;
import com.feedbackgenerator.controllers.algorithms.user.total.TotalKnowledge;
import com.feedbackgenerator.models.Knowledge;
import org.junit.Test;
import weka.classifiers.Classifier;
import weka.core.Instances;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/18/2016.
 */
public class CollaborativeFilteringTest {

    @Test
    public void testGetInstance() throws Exception {
        CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
        collaborativeFiltering.getInstance("test26.csv");
    }

    @Test
    public void testGetClassifier() throws Exception {
        CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
        Instances instance = collaborativeFiltering.getInstance("test26.csv");
        Classifier classifier = collaborativeFiltering.getClassifier(instance);
        System.out.println(classifier);
    }


    @Test
    public void testTestIBk() throws Exception {
        CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
        Instances instance = collaborativeFiltering.getInstance("test26.csv");
        Classifier classifier = collaborativeFiltering.getClassifier(instance);
        collaborativeFiltering.testIBk(instance, classifier);
    }

    @Test
    public void testClassifyDataWithIBk() throws Exception {
        TotalKnowledge totalKnowledge = new TotalKnowledge();
        ArrayList<Knowledge> knowledges = totalKnowledge.calculateUserTotalKnowledge(27, 2);

        CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
        Instances instance = collaborativeFiltering.getInstance("test26.csv");
        Classifier classifier = collaborativeFiltering.getClassifier(instance);

        collaborativeFiltering.classifyDataWithIBk(knowledges, classifier, instance);
    }
}