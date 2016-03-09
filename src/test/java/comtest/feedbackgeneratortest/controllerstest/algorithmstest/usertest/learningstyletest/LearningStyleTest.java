package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.learningstyletest;

import com.feedbackgenerator.controllers.algorithms.user.learningstyle.LearningStyle;
import com.feedbackgenerator.enums.FSLSModels;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 3/9/2016.
 */
public class LearningStyleTest {

    @Test
    public void testFindLearningStyleModel() throws Exception {
        LearningStyle learningStyle = new LearningStyle();
        ArrayList<FSLSModels> learningStyleModels = learningStyle.findLearningStyleModel(3);

        for (FSLSModels fslsModel: learningStyleModels){
            System.out.println(fslsModel);
        }
    }
}