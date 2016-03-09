package comtest.feedbackgeneratortest.propertiestest;

import com.feedbackgenerator.properties.AccessProperties;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 2/10/2016.
 */
public class AccessPropertiesTest {

    @Test
    public void testReadPropertyValue() throws Exception {
        String result = AccessProperties.readPropertyValue("DATABASE_USER_NAME");
        assertEquals("root", result);
    }
}