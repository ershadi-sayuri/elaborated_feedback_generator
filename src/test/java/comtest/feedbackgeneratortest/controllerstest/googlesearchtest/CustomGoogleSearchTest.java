package comtest.feedbackgeneratortest.controllerstest.googlesearchtest;

import com.feedbackgenerator.controllers.googlesearch.CustomGoogleSearch;
import org.junit.Test;

/**
 * Created by Ershadi Sayuri on 3/10/2016.
 */
public class CustomGoogleSearchTest {

    @Test
    public void testGoogleSearch() throws Exception {
        CustomGoogleSearch customGoogleSearch = new CustomGoogleSearch();
        customGoogleSearch.googleSearch("advanced java threads");
    }
}