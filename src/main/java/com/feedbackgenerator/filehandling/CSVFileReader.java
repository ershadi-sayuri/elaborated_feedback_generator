package com.feedbackgenerator.filehandling;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 * Created by Ershadi Sayuri on 3/18/2016.
 */
public class CSVFileReader {
    public static Instances readDataFile(String filename) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource(filename);
        Instances data = source.getDataSet();

        return data;
    }
}
