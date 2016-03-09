package com.feedbackgenerator.filehandling;

import com.feedbackgenerator.controllers.algorithms.user.total.TotalKnowledge;
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
public class WriteExcelFile {
    private static final String FILE_PATH = "testWriteStudents.csv";
    //We are making use of a single instance to prevent multiple write access to same file.
    private static final WriteExcelFile INSTANCE = new WriteExcelFile();

    public static WriteExcelFile getInstance() {
        return INSTANCE;
    }

    private WriteExcelFile() {
    }

    public static void main(String args[]) {
        TotalKnowledge totalKnowledge = new TotalKnowledge();
        try {
            ArrayList<Knowledge> knowledges = totalKnowledge.calculateUserTotalKnowledge(3, 2);
            ArrayList<Knowledge> knowledges2 = totalKnowledge.calculateUserTotalKnowledge(4, 2);
            ArrayList<Knowledge> knowledges3 = totalKnowledge.calculateUserTotalKnowledge(4, 3);

            knowledges.addAll(knowledges2);
            knowledges.addAll(knowledges3);

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

        headerRow.createCell(headerCellIndex++).setCellValue("Topic");
        headerRow.createCell(headerCellIndex++).setCellValue("TopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("OverAllTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("QuizWiseTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("AdvanceTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("OverAllAdvanceTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("QuizWiseAdvanceTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("EasyTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("OverAllEasyTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("QuizWiseEasyTopicKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("Knowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("OverAllKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("QuizWiseKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("AdvancedKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("OverAllAdvancedKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("QuizWiseAdvancedKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("EasyKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("OverAllEasyKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("QuizWiseEasyKnowledge");
        headerRow.createCell(headerCellIndex++).setCellValue("OverallInteractionData");
        headerRow.createCell(headerCellIndex++).setCellValue("QuizWiseInteractionData");
        headerRow.createCell(headerCellIndex++).setCellValue("ActiveOrReflective");
        headerRow.createCell(headerCellIndex++).setCellValue("SensoryOrIntuitiveIds");
        headerRow.createCell(headerCellIndex++).setCellValue("VisualOrVerbalIds");
        headerRow.createCell(headerCellIndex++).setCellValue("SequentialOrGlobalIds");

        int rowIndex = 1;
        for (Knowledge knowledge : knowledges) {
            Row row = workbookSheet.createRow(rowIndex++);
            int cellIndex = 0;
            //first place in row is name
            row.createCell(cellIndex++).setCellValue(knowledge.getTopic());
            row.createCell(cellIndex++).setCellValue(knowledge.getTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getOverAllTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getQuizWiseTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getAdvanceTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getOverAllAdvanceTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getQuizWiseAdvanceTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getEasyTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getOverAllEasyTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getQuizWiseEasyTopicKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getOverAllKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getQuizWiseKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getAdvancedKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getOverAllAdvancedKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getQuizWiseAdvancedKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getEasyKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getOverAllEasyKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getQuizWiseEasyKnowledge());
            row.createCell(cellIndex++).setCellValue(knowledge.getOverallInteractionData());
            row.createCell(cellIndex++).setCellValue(knowledge.getQuizWiseInteractionData());
            row.createCell(cellIndex++).setCellValue(knowledge.getActiveOrReflective() + "");
            row.createCell(cellIndex++).setCellValue(knowledge.getSensoryOrIntuitive() + "");
            row.createCell(cellIndex++).setCellValue(knowledge.getVisualOrVerbal() + "");
            row.createCell(cellIndex++).setCellValue(knowledge.getSequentialOrGlobal() + "");
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
