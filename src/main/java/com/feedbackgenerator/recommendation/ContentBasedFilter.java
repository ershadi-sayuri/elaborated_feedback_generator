package com.feedbackgenerator.recommendation;

/**
 * Created by Ershadi Sayuri on 3/17/2016.
 */

import com.feedbackgenerator.filehandling.CSVFileReader;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils;
import weka.gui.explorer.ClustererPanel;
import weka.gui.visualize.PlotData2D;

import java.io.File;

/**
 *
 */
public class ContentBasedFilter {
    public void filterContentBased(String trainDataSetFile, String testDataSetFile, String trainClusteredDataSetFile,
                                   String testClusteredDataSetFile, int userId) throws Exception {

        CSVFileReader fileReader = new CSVFileReader();
        Instances trainData = fileReader.getInstancesForCBF(trainDataSetFile, userId);

        SimpleKMeans model = new SimpleKMeans(); //clustering using KMeans

        model.setNumClusters(8);
        model.setDistanceFunction(new weka.core.ManhattanDistance()); //set distance function
        model.buildClusterer(trainData);

        // evaluates the cluster using the ClusterEvaluation class by using separate train and test data sets
        ClusterEvaluation trainEval = new ClusterEvaluation();
        trainEval.setClusterer(model);
        trainEval.evaluateClusterer(trainData);

        ContentBasedFilter contentBasedFilter = new ContentBasedFilter();
        CSVSaver saver = new CSVSaver();
        contentBasedFilter.writeArff(trainClusteredDataSetFile, trainData, trainEval);

        String testDataSet = testDataSetFile; //load test data set
        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(testDataSet).getFile());
        ConverterUtils.DataSource testSource = new ConverterUtils.DataSource(file.getAbsolutePath());
        Instances testData = testSource.getDataSet();

        // evaluates the cluster using the ClusterEvaluation class by using separate train and test data sets
        ClusterEvaluation testEval = new ClusterEvaluation();
        testEval.setClusterer(model);
        testEval.evaluateClusterer(testData); //this should be the test data set
        contentBasedFilter.writeArff(testClusteredDataSetFile, testData, testEval);
    }

    public void writeArff(String fileName, Instances data, ClusterEvaluation eval) throws Exception {
        PlotData2D plotData = ClustererPanel.setUpVisualizableInstances(data, eval);
        CSVSaver saver = new CSVSaver();
        saver.setInstances(plotData.getPlotInstances());

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        saver.setFile(file);
        saver.writeBatch();
    }
}
