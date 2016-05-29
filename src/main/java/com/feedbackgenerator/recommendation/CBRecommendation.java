package com.feedbackgenerator.recommendation;

import com.feedbackgenerator.filehandling.CSVFileReader;
import weka.core.Attribute;
import weka.core.Instances;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 5/23/2016.
 */
public class CBRecommendation {
    public Instances recommendCBLM(String fileName, int userId) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file1 = new File(classLoader.getResource(fileName).getFile());
        Instances data = CSVFileReader.readDataFile(file1.getAbsolutePath());

        double id = userId;
        ArrayList<String> clusters = new ArrayList<String>();

        for (int i = 0; i < data.numInstances(); i++) {
            if (data.instance(i).value(1) == id) {
                if (!clusters.contains(data.instance(i).value(16))) {
                    if(!clusters.contains(data.instance(i).stringValue(16))) {
                        clusters.add(data.instance(i).stringValue(16));
                    }
                }
            }
        }

        // find users within the clusters
        ArrayList<Double> users = new ArrayList<Double>();

        for (String cluster : clusters) {
            for (int i = 0; i < data.numInstances(); i++) {
                if (cluster.equals(data.instance(i).stringValue(16))) {
                    if (!users.contains(data.instance(i).value(1)) && data.instance(i).value(1) != id) {
                        users.add(data.instance(i).value(1));
                    }
                }
            }
        }

        // get learning material recommendations
        File file2 = new File(classLoader.getResource("contentData.csv").getFile());
        Instances instances = CSVFileReader.readDataFile(file2.getAbsolutePath());


        for (double user : users) {
            Double d = user;
            Integer i = d.intValue();
            String s_id = i + "";
            Attribute attribute = instances.attribute(s_id);

            for (int j = 0; j < instances.numInstances(); j++) {
                if (attribute != null) {
                    if (instances.instance(j).value(attribute) != 1.0) {
                        instances.delete(j);
                    }
                }
            }
        }

        System.out.println("===================================================");
        for(int i=0; i<instances.numInstances();i++){
            System.out.println(" content " + i + instances.instance(i).stringValue(0));
        }

        return instances;

    }
}
