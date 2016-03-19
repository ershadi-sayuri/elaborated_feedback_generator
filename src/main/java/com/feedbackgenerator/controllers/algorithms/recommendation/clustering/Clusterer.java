package com.feedbackgenerator.controllers.algorithms.recommendation.clustering;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Ershadi Sayuri on 3/17/2016.
 */
public class Clusterer {

    public void clusterData(String fileName) throws Exception {
        // load data
        Instances data = new Instances(new BufferedReader(new FileReader(fileName)));
        data.setClassIndex(data.numAttributes() - 1);

        // generate data for clusterer (w/o class)
        Remove filter = new Remove();
        filter.setAttributeIndices("" + (data.classIndex() + 1));

        filter.setInputFormat(data);

        Instances dataClusterer = Filter.useFilter(data, filter);

        // train clusterer
        SimpleKMeans clusterer = new SimpleKMeans();
        clusterer.setNumClusters(2);
        clusterer.setSeed(1);
        clusterer.setDisplayStdDevs(true);

        // set further options for EM, if necessary...
        clusterer.buildClusterer(dataClusterer);

        // evaluate clusterer
        ClusterEvaluation eval = new ClusterEvaluation();
        eval.setClusterer(clusterer);
        eval.evaluateClusterer(data);

        // print results
        System.out.println(eval.clusterResultsToString());
    }

    public static void main(String[] args) {
        try {
            Clusterer clusterer = new Clusterer();
            clusterer.clusterData("train_m1.arff");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
