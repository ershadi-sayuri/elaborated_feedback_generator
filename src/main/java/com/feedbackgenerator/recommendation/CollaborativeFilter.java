/*
 *  How to use WEKA API in Java 
 *  Copyright (C) 2014 
 *  @author Dr Noureddin M. Sadawi (noureddin.sadawi@gmail.com)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it as you wish ... 
 *  I ask you only, as a professional courtesy, to cite my name, web page 
 *  and my YouTube Channel!
 *  
 */

package com.feedbackgenerator.recommendation;
//import required classes

import com.feedbackgenerator.filehandling.CSVFileReader;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;

import java.io.File;
import java.util.ArrayList;

public class CollaborativeFilter {
    public ArrayList<String> filterCollaborative(String trainDataSetFile, String testDataSetFile, int attribute) throws Exception {

        CSVFileReader fileReader = new CSVFileReader();

        ClassLoader classLoader = getClass().getClassLoader();
        File file1 = new File(classLoader.getResource(trainDataSetFile).getFile());

        Instances trainDataSet = fileReader.readDataFile(file1.getAbsolutePath());
        trainDataSet.setClassIndex(trainDataSet.numAttributes() - attribute);

        int numClasses = trainDataSet.numClasses();
        for (int i = 0; i < numClasses; i++) {
            trainDataSet.classAttribute().value(i);
        }

        IBk nb = new IBk(); //create and build the classifier
        nb.buildClassifier(trainDataSet);

        File file2 = new File(classLoader.getResource(testDataSetFile).getFile());

        Instances testDataSet = fileReader.readDataFile(file2.getAbsolutePath());
        testDataSet.setClassIndex(trainDataSet.numAttributes() - attribute);

        ArrayList<String> recommendations = new ArrayList<String>();

        for (int i = 0; i < testDataSet.numInstances(); i++) {
            double actualClass = testDataSet.instance(i).classValue();
            String actual = testDataSet.classAttribute().value(( int ) actualClass);
            Instance newInst = testDataSet.instance(i);
            try {
                double predNB = nb.classifyInstance(newInst);
                String predString = testDataSet.classAttribute().value(( int ) predNB);

                System.out.println(actual + ", " + predString);
                recommendations.add(predString);
            } catch (Exception e) {

            }
        }

        return recommendations;
    }
}
