package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.interactiondatatest.quizwisetest;

import com.feedbackgenerator.controllers.algorithms.user.interactiondata.quizwise.QWInteractionData;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 3/4/2016.
 */
public class QWInteractionDataTest {

    @Test
    public void testFindQuizTiming() throws Exception {
        QWInteractionData qwInteractionData = new QWInteractionData();

        double quizTiming1 = qwInteractionData.findQuizTiming(4, 3);
        assertNotEquals(0, quizTiming1, 0);

        double quizTiming2 = qwInteractionData.findQuizTiming(2, 2);
        assertEquals(0, quizTiming2, 0);

        double quizTiming3 = qwInteractionData.findQuizTiming(6, 1000);
        assertEquals(0, quizTiming3, 0);

        double quizTiming4 = qwInteractionData.findQuizTiming(3, 1000);
        assertEquals(0, quizTiming4, 0);

        double quizTiming5 = qwInteractionData.findQuizTiming(3, 2);
        assertNotEquals(0, quizTiming5, 0);
    }

    @Test
    public void testFindQuizTimingProgress() throws Exception {
        QWInteractionData qwInteractionData = new QWInteractionData();

        double quizTimingProgress1 = qwInteractionData.findQuizTimingProgress(2, 2);
        assertEquals(0, quizTimingProgress1, 0);

        double quizTimingProgress2 = qwInteractionData.findQuizTimingProgress(4, 3);
        System.out.println(quizTimingProgress2);
        assertEquals(0, quizTimingProgress2, 0);

        double quizTimingProgress3 = qwInteractionData.findQuizTimingProgress(6, 1000);
        assertEquals(0, quizTimingProgress3, 0);

        double quizTimingProgress4 = qwInteractionData.findQuizTimingProgress(3, 1000);
        assertEquals(0, quizTimingProgress4, 0);

        double quizTimingProgress5 = qwInteractionData.findQuizTimingProgress(3, 2);
        assertNotEquals(0, quizTimingProgress5, 0);
    }
}