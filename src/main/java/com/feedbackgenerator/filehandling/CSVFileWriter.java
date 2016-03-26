package com.feedbackgenerator.filehandling;

import com.feedbackgenerator.learningmaterial.LearningMaterialRecommender;
import com.feedbackgenerator.algorithms.total.TotalKnowledge;
import com.feedbackgenerator.models.Knowledge;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/5/2016.
 */
public class CSVFileWriter {
    private static final String FILE_PATH = "test12.csv";
    //We are making use of a single instance to prevent multiple write access to same file.
    private static final CSVFileWriter INSTANCE = new CSVFileWriter();

    public static CSVFileWriter getInstance() {
        return INSTANCE;
    }

    public static void main(String args[]) {
        TotalKnowledge totalKnowledge = new TotalKnowledge();
        try {
            ArrayList<Knowledge> knowledges = totalKnowledge.calculateUserTotalKnowledge(3, 2);
            ArrayList<Knowledge> knowledges1 = totalKnowledge.calculateUserTotalKnowledge(24, 5);
            ArrayList<Knowledge> knowledges2 = totalKnowledge.calculateUserTotalKnowledge(4, 2);
            ArrayList<Knowledge> knowledges3 = totalKnowledge.calculateUserTotalKnowledge(4, 3);
            ArrayList<Knowledge> knowledges4 = totalKnowledge.calculateUserTotalKnowledge(5, 2);
            ArrayList<Knowledge> knowledges5 = totalKnowledge.calculateUserTotalKnowledge(6, 2);
            ArrayList<Knowledge> knowledges6 = totalKnowledge.calculateUserTotalKnowledge(27, 2);
            ArrayList<Knowledge> knowledges7 = totalKnowledge.calculateUserTotalKnowledge(22, 5);
            ArrayList<Knowledge> knowledges8 = totalKnowledge.calculateUserTotalKnowledge(24, 2);
            ArrayList<Knowledge> knowledges9 = totalKnowledge.calculateUserTotalKnowledge(3, 5);
            ArrayList<Knowledge> knowledges10 = totalKnowledge.calculateUserTotalKnowledge(22, 5);
            ArrayList<Knowledge> knowledges11 = totalKnowledge.calculateUserTotalKnowledge(27, 5);

            knowledges.addAll(knowledges1);
            knowledges.addAll(knowledges2);
            knowledges.addAll(knowledges3);
            knowledges.addAll(knowledges4);
            knowledges.addAll(knowledges5);
            knowledges.addAll(knowledges5);
            knowledges.addAll(knowledges6);
            knowledges.addAll(knowledges7);
            knowledges.addAll(knowledges8);
            knowledges.addAll(knowledges9);
            knowledges.addAll(knowledges10);
            knowledges.addAll(knowledges11);

            writeStudentsListToExcel(knowledges);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeStudentsListToExcel(ArrayList<Knowledge> knowledges) {
        // Using XSSF for xlsx format, for xls use HSSF

        Workbook workbook = new XSSFWorkbook();
        Sheet workbookSheet = workbook.createSheet("Knowledge");

        int headerCellIndex = 0;
        Row headerRow = workbookSheet.createRow(0);

        headerRow.createCell(headerCellIndex++).setCellValue("topic");
        headerRow.createCell(headerCellIndex++).setCellValue("topicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("overAllTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("quizWiseTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("advanceTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("overAllAdvanceTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("quizWiseAdvanceTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("easyTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("overAllEasyTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("quizWiseEasyTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("knowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("overAllKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("quizWiseKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("advancedKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("overAllAdvancedKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("quizWiseAdvancedKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("easyKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("overAllEasyKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("quizWiseEasyKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("overallInteractionData");
        headerRow.createCell(headerCellIndex++).setCellValue("quizWiseInteractionData");
        headerRow.createCell(headerCellIndex++).setCellValue("activeOrReflective");
        headerRow.createCell(headerCellIndex++).setCellValue("sensoryOrIntuitive");
        headerRow.createCell(headerCellIndex++).setCellValue("visualOrVerbal");
        headerRow.createCell(headerCellIndex++).setCellValue("sequentialOrGlobal");
        headerRow.createCell(headerCellIndex++).setCellValue("recommendation");

        LearningMaterialRecommender learningMaterialRecommender = new LearningMaterialRecommender();


        int rowIndex = 1;
        for (Knowledge knowledge : knowledges) {
            Knowledge knowledgeVthRec = learningMaterialRecommender.filterRecommendationsByTopic(knowledge);

            Row row = workbookSheet.createRow(rowIndex++);
            int cellIndex = 0;
            //first place in row is name
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getTopic());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getOverAllTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getQuizWiseTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getAdvanceTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getOverAllAdvanceTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getQuizWiseAdvanceTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getEasyTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getOverAllEasyTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getQuizWiseEasyTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getOverAllKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getQuizWiseKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getAdvancedKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getOverAllAdvancedKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getQuizWiseAdvancedKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getEasyKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getOverAllEasyKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getQuizWiseEasyKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getOverallInteractionData());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getQuizWiseInteractionData());
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getActiveOrReflective() + "");
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getSensoryOrIntuitive() + "");
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getVisualOrVerbal() + "");
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getSequentialOrGlobal() + "");
            row.createCell(cellIndex++).setCellValue(knowledgeVthRec.getRecommendation() + "");
        }

        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();

            System.out.println(FILE_PATH + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
