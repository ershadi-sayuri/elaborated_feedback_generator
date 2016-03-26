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

package com.feedbackgenerator.recommendation.collaborative;
//import required classes

import com.feedbackgenerator.filehandling.CSVFileReader;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;

public class CollaborativeFilter {
    public static void main(String args[]) throws Exception {
        //load training dataset
        CSVFileReader csvFileReader = new CSVFileReader();
        Instances trainDataset = csvFileReader.readDataFile("test26.csv");
        //set class index to the last attribute
        trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
        //get number of classes
        int numClasses = trainDataset.numClasses();
        //print out class values in the training dataset
        for (int i = 0; i < numClasses; i++) {
            //get class string value using the class index
            String classValue = trainDataset.classAttribute().value(i);
            System.out.println("Class Value " + i + " is " + classValue);
        }
        //create and build the classifier
        IBk nb = new IBk();
        nb.buildClassifier(trainDataset);
        //output model
        System.out.println(nb);

        //load new dataset
        Instances testDataset = csvFileReader.readDataFile("test25.csv");
        //set class index to the last attribute
        testDataset.setClassIndex(testDataset.numAttributes() - 1);

        //loop through the new dataset and make predictions
        System.out.println("===================");
        System.out.println("Actual Class, NB Predicted");
        for (int i = 0; i < testDataset.numInstances(); i++) {
            //get class double value for current instance
            double actualClass = testDataset.instance(i).classValue();
            //get class string value using the class index using the class's int value
            String actual = testDataset.classAttribute().value(( int ) actualClass);
            //get Instance object of current instance
            Instance newInst = testDataset.instance(i);
            //call classifyInstance, which returns a double value for the class
            double predNB = nb.classifyInstance(newInst);
            //use this value to get string value of the predicted class
            String predString = testDataset.classAttribute().value(( int ) predNB);

            if (!actual.equals(predString)) {
                System.out.println(actual + ", " + predString);
            }
        }

    }
}
