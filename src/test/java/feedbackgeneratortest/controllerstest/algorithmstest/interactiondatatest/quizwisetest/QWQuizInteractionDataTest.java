package feedbackgeneratortest.controllerstest.algorithmstest.interactiondatatest.quizwisetest;

import feedbackgenerator.controllers.algorithms.interactiondata.quizwise.QWQuizInteractionData;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 3/4/2016.
 */
public class QWQuizInteractionDataTest {

    @Test
    public void testFindQuizTiming() throws Exception {
        QWQuizInteractionData qwQuizInteractionData = new QWQuizInteractionData();

        double quizTiming1 = qwQuizInteractionData.findQuizTiming(4, 3);
        assertNotEquals(0, quizTiming1, 0);

        double quizTiming2 = qwQuizInteractionData.findQuizTiming(2, 2);
        assertEquals(0, quizTiming2, 0);

        double quizTiming3 = qwQuizInteractionData.findQuizTiming(6, 1000);
        assertEquals(0, quizTiming3, 0);

        double quizTiming4 = qwQuizInteractionData.findQuizTiming(3, 1000);
        assertEquals(0, quizTiming4, 0);

        double quizTiming5 = qwQuizInteractionData.findQuizTiming(3, 2);
        assertNotEquals(0, quizTiming5, 0);
    }

    @Test
    public void testFindQuizTimingProgress() throws Exception {
        QWQuizInteractionData qwQuizInteractionData = new QWQuizInteractionData();

        double quizTimingProgress1 = qwQuizInteractionData.findQuizTimingProgress(2, 2);
        assertEquals(0, quizTimingProgress1, 0);

        double quizTimingProgress2 = qwQuizInteractionData.findQuizTimingProgress(4, 3);
        System.out.println(quizTimingProgress2);
        assertEquals(0, quizTimingProgress2, 0);

        double quizTimingProgress3 = qwQuizInteractionData.findQuizTimingProgress(6, 1000);
        assertEquals(0, quizTimingProgress3, 0);

        double quizTimingProgress4 = qwQuizInteractionData.findQuizTimingProgress(3, 1000);
        assertEquals(0, quizTimingProgress4, 0);

        double quizTimingProgress5 = qwQuizInteractionData.findQuizTimingProgress(3, 2);
        assertNotEquals(0, quizTimingProgress5, 0);
    }
}