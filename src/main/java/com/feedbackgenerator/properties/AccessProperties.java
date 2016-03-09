package com.feedbackgenerator.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Ershadi Sayuri on 2/10/2016.
 */
public class AccessProperties {
    private static Properties properties = null;
    private static InputStream inputStream = null;
    private static AccessProperties accessProperties = null;

    /**
     * constructor
     *
     * @throws FileNotFoundException
     */
    private AccessProperties() throws FileNotFoundException {
        properties = new Properties();
        inputStream = new FileInputStream("config.properties");
    }

    /**
     * create new accessProperties if accessProperties is null, else return the accessProperties object
     *
     * @return accessProperties
     */
    private static AccessProperties getAccessProperties() throws FileNotFoundException {
        if (accessProperties == null) {
            accessProperties = new AccessProperties();
        }

        return accessProperties;
    }

    /**
     * read the property value of the given property name
     *
     * @param propertyName
     * @return propertyValue
     * @throws IOException
     */
    public static String readPropertyValue(String propertyName) throws IOException {
        // load properties file
        getAccessProperties().properties.load(inputStream);

        // return the property value
        return properties.getProperty(propertyName);
    }
}
