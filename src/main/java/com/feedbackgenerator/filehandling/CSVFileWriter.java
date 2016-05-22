package com.feedbackgenerator.filehandling;

import com.feedbackgenerator.models.Knowledge;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/5/2016.
 */
public class CSVFileWriter {
    public void writeCsvFile(String fileName, ArrayList<Knowledge> knowledges) {
        try {
            FileWriter writer = new FileWriter(fileName);

            writer.append("topic,topicKnowledge,overAllTopicKnowledge,quizWiseTopicKnowledge,advanceTopicKnowledge," +
                    "overAllAdvanceTopicKnowledge,quizWiseAdvanceTopicKnowledge,easyTopicKnowledge," +
                    "overAllEasyTopicKnowledge,quizWiseEasyTopicKnowledge,knowledge,overAllKnowledge," +
                    "quizWiseKnowledge,advancedKnowledge,overAllAdvancedKnowledge,quizWiseAdvancedKnowledge," +
                    "easyKnowledge,overAllEasyKnowledge,quizWiseEasyKnowledge,timeSpentViewingMaterial," +
                    "overAllAttemptAverage,quizWiseAttemptAverage," + "activeOrReflective,sensoryOrIntuitive," +
                    "visualOrVerbal,sequentialOrGlobal," +
                    "recommendation" + '\n');

            for (Knowledge knowledge : knowledges) {
                writer.append(knowledge.getTopic() + "," + knowledge.getTopicKnowledge() + "," +
                        knowledge.getOverAllTopicKnowledge() + "," + knowledge.getQuizWiseTopicKnowledge() + "," +
                        knowledge.getAdvanceTopicKnowledge() + "," + knowledge.getOverAllAdvanceTopicKnowledge() + "," +
                        knowledge.getQuizWiseAdvanceTopicKnowledge() + "," + knowledge.getEasyTopicKnowledge() + "," +
                        knowledge.getOverAllEasyTopicKnowledge() + "," + knowledge.getQuizWiseEasyTopicKnowledge() + "," +
                        knowledge.getKnowledge() + "," + knowledge.getOverAllKnowledge() + "," +
                        knowledge.getQuizWiseKnowledge() + "," + knowledge.getAdvancedKnowledge() + "," +
                        knowledge.getOverAllAdvancedKnowledge() + "," + knowledge.getQuizWiseAdvancedKnowledge() + "," +
                        knowledge.getEasyKnowledge() + "," + knowledge.getOverAllEasyKnowledge() + "," +
                        knowledge.getQuizWiseEasyKnowledge() + "," + knowledge.getTimeSpentViewingMaterial() + "," +
                        knowledge.getOverAllAttemptAverage() + "," + knowledge.getQuizWiseAttemptAverage() + "," +
                        knowledge.getActiveOrReflective() + "," + knowledge.getSensoryOrIntuitive() + "," +
                        knowledge.getVisualOrVerbal() + "," + knowledge.getSequentialOrGlobal() + "," +
                        knowledge.getRecommendation() + '\n');
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
