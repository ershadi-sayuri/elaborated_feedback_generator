package com.feedbackgenerator.filehandling;

import com.feedbackgenerator.models.Knowledge;
import com.feedbackgenerator.models.UserProfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/5/2016.
 */
public class CSVFileWriter {
    public void writeKnowledgeData(String fileName, ArrayList<Knowledge> knowledges, boolean createNew) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        String file1 = classLoader.getResource(fileName).getFile();

        File file = new File(file1);

        FileWriter writer;

        if (createNew || !file.exists()) {
            writer = new FileWriter(file);

            writer.append("topic,topicKnowledge,overAllTopicKnowledge,quizWiseTopicKnowledge,advanceTopicKnowledge," +
                    "overAllAdvanceTopicKnowledge,quizWiseAdvanceTopicKnowledge,easyTopicKnowledge," +
                    "overAllEasyTopicKnowledge,quizWiseEasyTopicKnowledge,knowledge,overAllKnowledge," +
                    "quizWiseKnowledge,advancedKnowledge,overAllAdvancedKnowledge,quizWiseAdvancedKnowledge," +
                    "easyKnowledge,overAllEasyKnowledge,quizWiseEasyKnowledge,timeSpentViewingMaterial," +
                    "overAllAttemptAverage,quizWiseAttemptAverage," + "activeOrReflective,sensoryOrIntuitive," +
                    "visualOrVerbal,sequentialOrGlobal," +
                    "recommendation" + '\n');

        } else {
            writer = new FileWriter(file, true);//if file exists append to file.
        }

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
    }

    public void writeUserProfileData(String fileName, ArrayList<UserProfile> profiles) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        String filePath = classLoader.getResource(fileName).getFile();
        File file = new File(filePath);

        FileWriter writer;

        if (file.exists()) {
            writer = new FileWriter(file, true);//if file exists append to file.
        } else {
            writer = new FileWriter(file);
            writer.append("user id,video,images,paragraph,bullets,examples,advanced,medium,easy,topic," +
                    "facts and procedures,theories and meaning,steps given,practical,thinking" + '\n');
        }

        for (UserProfile profile : profiles) {
            writer.append(profile.getUserId() + "," + profile.isVideo() + "," + profile.isImages() + "," +
                    profile.isParagraph() + "," + profile.isBullets() + "," + profile.isExamples() + "," + profile.isAdvanced() +
                    "," + profile.isMedium() + "," + profile.isEasy() + "," + profile.getTopic() + "," +
                    profile.isFactsAndProcedures() + "," + profile.isTheoriesAndMeaning() + "," + profile.isStepsGiven() + "," +
                    profile.isPractical() + "," + profile.isThinking() + '\n');

        }

        writer.flush();
        writer.close();
    }

}
