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

public class CollaborativeFilter {
    public void filterCollaborative(String trainDataSetFile, String testDataSetFile, int attribute) throws Exception {

        CSVFileReader fileReader = new CSVFileReader();

        Instances trainDataSet = fileReader.readDataFile(trainDataSetFile);
        trainDataSet.setClassIndex(trainDataSet.numAttributes() - attribute);

        int numClasses = trainDataSet.numClasses();
        for(int i = 0; i < numClasses; i++){
            String classValue = trainDataSet.classAttribute().value(i);
            System.out.println("Class Value "+i+" is " + classValue);
        }

        IBk nb = new IBk(); //create and build the classifier
        nb.buildClassifier(trainDataSet);

        Instances testDataSet = fileReader.readDataFile(testDataSetFile);
        testDataSet.setClassIndex(trainDataSet.numAttributes() - attribute);

        //loop through the new data set and make predictions
        System.out.println("Actual Class, NB Predicted");
//        for (int i = 0; i < testDataSet.numInstances(); i++) {
//            double actualClass = testDataSet.instance(i).classValue(); //get class double value for current instance
//            //get class string value using the class index using the class's int value
//            String actual = testDataSet.classAttribute().value(( int ) actualClass);
//            Instance newInst = testDataSet.instance(i); //get Instance object of current instance
//            //call classifyInstance, which returns a double value for the class
//            double predNB = nb.classifyInstance(newInst);
//            //use this value to get string value of the predicted class
//            String predString = testDataSet.classAttribute().value(( int ) predNB);
//
//            System.out.println(actual + ", " + actualClass + ", " + predString + ", " + predNB);
//
//        }








//        System.out.println("Actual Class, NB Predicted");
        for (int i = 0; i < testDataSet.numInstances(); i++) {
            double actualClass = testDataSet.instance(i).classValue();
            String actual = testDataSet.classAttribute().value((int) actualClass);
            Instance newInst = testDataSet.instance(i);
            double predNB = nb.classifyInstance(newInst);
            String predString = testDataSet.classAttribute().value((int) predNB);
            System.out.println(actual+", "+predString);
        }

    }
}
