package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.interactiondatatest.allroundtest;

import com.feedbackgenerator.algorithms.interactiondata.allround.ARInteractionData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ershadi Sayuri on 3/15/2016.
 */
public class ARInteractionDataTest {

    @Test
    public void testFindQuizTiming() throws Exception {
        ARInteractionData arInteractionData = new ARInteractionData();
        double quizTiming = arInteractionData.findQuizTiming(22);
        assertEquals(0.9, quizTiming, 0.9);
    }

    @Test
    public void testFindQuizTimingProgress() throws Exception {
        ARInteractionData arInteractionData = new ARInteractionData();
        double quizTimingProgress = arInteractionData.findQuizTimingProgress(22);
        assertEquals(0.0, quizTimingProgress, 0.0);
    }
}