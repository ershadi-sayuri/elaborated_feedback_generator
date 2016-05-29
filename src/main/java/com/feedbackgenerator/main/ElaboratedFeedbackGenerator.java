package com.feedbackgenerator.main;

import com.feedbackgenerator.algorithms.total.TotalKnowledge;
import com.feedbackgenerator.filehandling.CSVFileWriter;
import com.feedbackgenerator.other.UserProfiling;
import com.feedbackgenerator.models.*;
import com.feedbackgenerator.recommendation.CBRecommendation;
import com.feedbackgenerator.recommendation.CollaborativeFilter;
import com.feedbackgenerator.recommendation.ContentBasedFilter;
import com.feedbackgenerator.recommendation.HybridRecommendation;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ershadi Sayuri on 3/11/2016.
 */

public class ElaboratedFeedbackGenerator {
    public static void main(String[] args) {
        try {
            ElaboratedFeedbackGenerator elaboratedFeedbackGenerator = new ElaboratedFeedbackGenerator();
            elaboratedFeedbackGenerator.selectOption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectOption() throws Exception {
        while (true) {
            System.out.print("What do you want to do? Select an option from below." + "\n" +
                    "1) Create initial training data set" + "\n" +
                    "2) Create recommendations for a user using content based filtering" + "\n" +
                    "3) Create recommendations for a user using collaborative filtering" + "\n" +
                    "4) Create recommendations for a user using hybrid filtering" + "\n" +
                    "5) Exit" + "\n" +
                    "Enter your option now: ");

            Scanner input = new Scanner(System.in);
            int option = 0;
            try {
                option = input.nextInt();
            } catch (InputMismatchException ex) {
                selectOption();
            }

            TotalKnowledge totalKnowledge = new TotalKnowledge();
            CSVFileWriter csvFileWriter = new CSVFileWriter();

            CollaborativeFilter collaborativeFilter = new CollaborativeFilter();
            ContentBasedFilter contentBasedFilter = new ContentBasedFilter();

            CBRecommendation cbRecommendation = new CBRecommendation();

            switch (option) {
                case 1:
                    ArrayList<Knowledge> knowledgesWithR = totalKnowledge.calculateUserTotalKnowledge(3, 2, true);
                    // write calculated knowledge in a csv file
                    csvFileWriter.writeKnowledgeData("trainData.csv", knowledgesWithR, false);
                    System.out.println("Created file trainData.csv");
                    break;
                case 2:
                    // content based filtering
                    ArrayList<Knowledge> knowledgesToFindCBFR = totalKnowledge.calculateUserTotalKnowledge(15, 5, false);
                    ArrayList<UserProfile> userProfiles = UserProfiling.createUserProfile(15, knowledgesToFindCBFR);
                    csvFileWriter.writeUserProfileData("testProfile.csv", userProfiles);
                    // generate recommendations with CF
                    contentBasedFilter.filterContentBased("trainProfile.csv", "testProfile.csv", "trainCData.csv", "testCData.csv", 15);
                    cbRecommendation.recommendCBLM("trainCData.csv", 15);
                    break;
                case 3:
                    // collaborative filtering
                    ArrayList<Knowledge> knowledgesToFindCFR = totalKnowledge.calculateUserTotalKnowledge(3, 5, true);
                    // write calculated knowledge in a csv file
                    csvFileWriter.writeKnowledgeData("testData.csv", knowledgesToFindCFR, true);
                    // generate recommendations with CF
                    collaborativeFilter.filterCollaborative("trainData.csv", "testData.csv", 1);
                    break;
                case 4:
                    // hybrid recommendation
                    ArrayList<Knowledge> knowledgesToFindHR = totalKnowledge.calculateUserTotalKnowledge(4, 2, true);
                    ArrayList<UserProfile> hUserProfiles = UserProfiling.createUserProfile(4, knowledgesToFindHR);
                    csvFileWriter.writeUserProfileData("testProfile.csv", hUserProfiles);
                    // generate recommendations with content based
                    contentBasedFilter.filterContentBased("trainProfile.csv", "testProfile.csv", "trainCData.csv", "testCData.csv", 15);
                    Instances cbRecommendations = cbRecommendation.recommendCBLM("trainCData.csv", 15);

                    // collaborative
                    csvFileWriter.writeKnowledgeData("testData.csv", knowledgesToFindHR, true);
                    ArrayList<String> cRecommendations = collaborativeFilter.filterCollaborative("trainData.csv", "testData.csv", 1);
                    ArrayList<LearningMaterial> learningMaterials = HybridRecommendation.generateHybridRecommendation
                            (cbRecommendations, cRecommendations,hUserProfiles.get(0));

                    User user = new User();
                    user = user.getUserData(4);

                    Feedback feedback = new Feedback();
                    feedback.setDescription("Hello " + user.getFirstName() + ", following are the recommended learning materials for you");
                    feedback.setLearningMaterials(learningMaterials);
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }

    }
}
