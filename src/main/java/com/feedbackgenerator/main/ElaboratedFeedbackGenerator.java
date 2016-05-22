package com.feedbackgenerator.main;

import com.feedbackgenerator.algorithms.total.TotalKnowledge;
import com.feedbackgenerator.filehandling.CSVFileWriter;
import com.feedbackgenerator.models.Knowledge;
import com.feedbackgenerator.recommendation.CollaborativeFilter;
import com.feedbackgenerator.recommendation.ContentBasedFilter;

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

            switch (option) {
                case 1:
                    ArrayList<Knowledge> knowledgesWithR = totalKnowledge.calculateUserTotalKnowledge(3, 5, true);
                    // write calculated knowledge in a csv file
                    csvFileWriter.writeCsvFile("data/trainData.csv", knowledgesWithR);
                    System.out.println("Created file trainData.csv");
                    break;
                case 2:
                    // content based filtering
                    ArrayList<Knowledge> knowledgesToFindCBFR = totalKnowledge.calculateUserTotalKnowledge(3, 5, false);
                    // write calculated knowledge in a csv file
                    csvFileWriter.writeCsvFile("data/testData.csv", knowledgesToFindCBFR);
                    // generate recommendations with CF
                    contentBasedFilter.filterContentBased("data/trainData.csv", "data/testData.csv", "data/trainCData.csv", "data/testCData.csv");
                    break;
//            case 3:
//                // collaborative filtering
//                ArrayList<Knowledge> knowledgesToFindCFR = totalKnowledge.calculateUserTotalKnowledge(3, 5, true);
//                // write calculated knowledge in a csv file
//                csvFileWriter.writeCsvFile("data/testData.csv", knowledgesToFindCFR);
//                // generate recommendations with CF
//                collaborativeFilter.filterCollaborative("data/trainData.csv", "data/testData.csv", 1);
//                break;
//            case 4:
//                // hybrid recommendation
//                ArrayList<Knowledge> knowledgesToFindHR = totalKnowledge.calculateUserTotalKnowledge(3, 5, false);
//                csvFileWriter.writeCsvFile("data/testData.csv", knowledgesToFindHR);
//                contentBasedFilter.filterContentBased("data/trainData.csv", "data/testData.csv", "data/trainHData.csv", "data/testHData.csv");
//                collaborativeFilter.filterCollaborative("data/trainHData.csv", "data/testHData.csv", 2);
//                break;
                case 5:
                    System.exit(0);
                    break;

            }
        }

    }

    public void get(int userId, int quizId, boolean setRec, int attributeNo) throws Exception {
//        // hybrid recommendation
//        TotalKnowledge totalKnowledge = new TotalKnowledge();
//        CSVFileWriter csvFileWriter = new CSVFileWriter();
//
//        CollaborativeFilter collaborativeFilter = new CollaborativeFilter();
//        ContentBasedFilter contentBasedFilter = new ContentBasedFilter();
//
//        ArrayList<Knowledge> knowledgesToFindHR = totalKnowledge.calculateUserTotalKnowledge(userId, quizId, setRec);
//        csvFileWriter.writeCsvFile("data/trainData.csv", knowledgesToFindHR);
//        contentBasedFilter.filterContentBased("data/trainData.csv", "data/testData.csv",
//                "data/trainContentFilteredData.csv", "data/testContentFilteredData.csv");
//        collaborativeFilter.filterCollaborative("data/trainContentFilteredData.csv", "data/testContentFilteredData.csv",
//                attributeNo);
    }
}
