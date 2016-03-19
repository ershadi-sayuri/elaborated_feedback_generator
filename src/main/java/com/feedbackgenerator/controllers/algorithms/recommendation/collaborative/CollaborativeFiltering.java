package com.feedbackgenerator.controllers.algorithms.recommendation.collaborative;

/**
 * Created by Ershadi Sayuri on 3/18/2016.
 */

import com.feedbackgenerator.filehandling.CSVFileReader;
import com.feedbackgenerator.models.Knowledge;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;

/**
 * Nearest Neighbor (also known as Collaborative Filtering or Instance-based Learning) is a useful data mining technique
 * that allows you to use your past data instances, with known output values, to predict an unknown output value of a
 * new data instance.
 * <p/>
 * In WEKA nearest neighbour filtering is done via IBk classifier in the lazy classifier section.
 * <p/>
 * In this class functions are implemented to train, test and use the IBk classifier.
 */
public class CollaborativeFiltering {

    /**
     * train the model with the selected classifier
     *
     * @param fileName
     * @throws Exception
     */
    public Instances getInstance(String fileName) throws Exception {
        CSVFileReader csvFileReader = new CSVFileReader();
        Instances data = csvFileReader.readDataFile(fileName); // get the data set for training

        // Create a IBk classifier
        Classifier classifier = ( Classifier ) new IBk();
        classifier.buildClassifier(data);

        return data;
    }

    public Classifier getClassifier(Instances data) throws Exception {
        // Create a IBk classifier
        Classifier classifier = ( Classifier ) new IBk();
        classifier.buildClassifier(data);

        return classifier;
    }

    public void testIBk(Instances data, Classifier classifier) throws Exception {
        // Test the model
        Evaluation eTest = new Evaluation(data);
        double[] doubles = eTest.evaluateModel(classifier, data);

        // Print the result à la Weka explorer:
        String strSummary = eTest.toSummaryString();
        System.out.println(strSummary);

        // Get the confusion matrix
        double[][] cmMatrix = eTest.confusionMatrix();
    }

    public void classifyDataWithIBk(ArrayList<Knowledge> knowledges, Classifier classifier, Instances trainingSet) throws Exception {
        Attribute topic = new Attribute("topic", ( FastVector ) null);
        Attribute topicKnowledge = new Attribute("topicKnowledge");
        Attribute overAllTopicKnowledge = new Attribute("overAllTopicKnowledge");
        Attribute quizWiseTopicKnowledge = new Attribute("quizWiseTopicKnowledge");
        Attribute advanceTopicKnowledge = new Attribute("advanceTopicKnowledge");
        Attribute overAllAdvanceTopicKnowledge = new Attribute("overAllAdvanceTopicKnowledge");
        Attribute quizWiseAdvanceTopicKnowledge = new Attribute("quizWiseAdvanceTopicKnowledge");
        Attribute easyTopicKnowledge = new Attribute("easyTopicKnowledge");
        Attribute overAllEasyTopicKnowledge = new Attribute("overAllEasyTopicKnowledge");
        Attribute quizWiseEasyTopicKnowledge = new Attribute("quizWiseEasyTopicKnowledge");
        Attribute knowledge = new Attribute("knowledge");
        Attribute overAllKnowledge = new Attribute("overAllKnowledge");
        Attribute quizWiseKnowledge = new Attribute("quizWiseKnowledge");
        Attribute advancedKnowledge = new Attribute("advancedKnowledge");
        Attribute overAllAdvancedKnowledge = new Attribute("overAllAdvancedKnowledge");
        Attribute quizWiseAdvancedKnowledge = new Attribute("quizWiseAdvancedKnowledge");
        Attribute easyKnowledge = new Attribute("easyKnowledge");
        Attribute overAllEasyKnowledge = new Attribute("overAllEasyKnowledge");
        Attribute quizWiseEasyKnowledge = new Attribute("quizWiseEasyKnowledge");
        Attribute overallInteractionData = new Attribute("overallInteractionData");
        Attribute quizWiseInteractionData = new Attribute("quizWiseInteractionData");

        FastVector activeOrReflectiveFV = new FastVector();
        activeOrReflectiveFV.addElement("ACTIVE");
        activeOrReflectiveFV.addElement("REFLECTIVE");
        Attribute activeOrReflective = new Attribute("activeOrReflective", activeOrReflectiveFV);

        FastVector sensoryOrIntuitiveFV = new FastVector();
        sensoryOrIntuitiveFV.addElement("SENSORY");
        sensoryOrIntuitiveFV.addElement("INTUITIVE");
        Attribute sensoryOrIntuitive = new Attribute("sensoryOrIntuitive", sensoryOrIntuitiveFV);

        FastVector visualOrVerbalFV = new FastVector();
        visualOrVerbalFV.addElement("VISUAL");
        visualOrVerbalFV.addElement("VERBAL");
        Attribute visualOrVerbal = new Attribute("visualOrVerbal", visualOrVerbalFV);

        FastVector sequentialOrGlobalFV = new FastVector();
        sequentialOrGlobalFV.addElement("SEQUENTIAL");
        sequentialOrGlobalFV.addElement("GLOBAL");
        Attribute sequentialOrGlobal = new Attribute("sequentialOrGlobal", sequentialOrGlobalFV);

        Attribute recommendation = new Attribute("recommendation", ( FastVector ) null);

        // create dataset
        FastVector attrs = new FastVector();
        attrs.addElement(topic);
        attrs.addElement(topicKnowledge);
        attrs.addElement(overAllTopicKnowledge);
        attrs.addElement(quizWiseTopicKnowledge);
        attrs.addElement(advanceTopicKnowledge);
        attrs.addElement(overAllAdvanceTopicKnowledge);
        attrs.addElement(quizWiseAdvanceTopicKnowledge);
        attrs.addElement(easyTopicKnowledge);
        attrs.addElement(overAllEasyTopicKnowledge);
        attrs.addElement(quizWiseEasyTopicKnowledge);
        attrs.addElement(knowledge);
        attrs.addElement(overAllKnowledge);
        attrs.addElement(quizWiseKnowledge);
        attrs.addElement(advancedKnowledge);
        attrs.addElement(overAllAdvancedKnowledge);
        attrs.addElement(quizWiseAdvancedKnowledge);
        attrs.addElement(easyKnowledge);
        attrs.addElement(overAllEasyKnowledge);
        attrs.addElement(quizWiseEasyKnowledge);
        attrs.addElement(overallInteractionData);
        attrs.addElement(quizWiseInteractionData);
        attrs.addElement(activeOrReflective);
        attrs.addElement(sensoryOrIntuitive);
        attrs.addElement(visualOrVerbal);
        attrs.addElement(sequentialOrGlobal);
        attrs.addElement(recommendation);

        Instances dataset = new Instances("my_dataset", attrs, 0);

        try {
            for (Knowledge k : knowledges) {
                Instance instance = new Instance(26);
                instance.setValue(topic, k.getTopic());
                instance.setValue(topicKnowledge, k.getTopicKnowledge());
                instance.setValue(overAllTopicKnowledge, k.getOverAllTopicKnowledge());
                instance.setValue(quizWiseTopicKnowledge, k.getQuizWiseTopicKnowledge());
                instance.setValue(advanceTopicKnowledge, k.getAdvanceTopicKnowledge());
                instance.setValue(overAllAdvanceTopicKnowledge, k.getOverAllAdvanceTopicKnowledge());
                instance.setValue(quizWiseAdvanceTopicKnowledge, k.getQuizWiseAdvanceTopicKnowledge());
                instance.setValue(easyTopicKnowledge, k.getEasyTopicKnowledge());
                instance.setValue(overAllEasyTopicKnowledge, k.getOverAllEasyTopicKnowledge());
                instance.setValue(quizWiseEasyTopicKnowledge, k.getQuizWiseEasyTopicKnowledge());
                instance.setValue(knowledge, k.getKnowledge());
                instance.setValue(overAllKnowledge, k.getOverAllKnowledge());
                instance.setValue(quizWiseKnowledge, k.getQuizWiseKnowledge());
                instance.setValue(advancedKnowledge, k.getAdvancedKnowledge());
                instance.setValue(overAllAdvancedKnowledge, k.getOverAllAdvancedKnowledge());
                instance.setValue(quizWiseAdvancedKnowledge, k.getQuizWiseAdvancedKnowledge());
                instance.setValue(easyKnowledge, k.getEasyKnowledge());
                instance.setValue(overAllEasyKnowledge, k.getOverAllEasyKnowledge());
                instance.setValue(quizWiseEasyKnowledge, k.getQuizWiseEasyKnowledge());
                instance.setValue(overallInteractionData, k.getOverallInteractionData());
                instance.setValue(quizWiseInteractionData, k.getQuizWiseInteractionData());
                instance.setValue(activeOrReflective, String.valueOf(k.getActiveOrReflective()));
                instance.setValue(sensoryOrIntuitive, String.valueOf(k.getSensoryOrIntuitive()));
                instance.setValue(visualOrVerbal, String.valueOf(k.getVisualOrVerbal()));
                instance.setValue(sequentialOrGlobal, String.valueOf(k.getSequentialOrGlobal()));

                dataset.add(instance);
            }


            trainingSet.setClassIndex(1);
            dataset.setClassIndex(1);

            //do eval
            Evaluation eval = new Evaluation(trainingSet); //trainset
            eval.evaluateModel(classifier, dataset); //testset
            System.out.println(eval.toSummaryString());
            System.out.println(dataset.attribute(25));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
