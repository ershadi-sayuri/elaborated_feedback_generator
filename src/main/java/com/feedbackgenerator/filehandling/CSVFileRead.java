package com.feedbackgenerator.filehandling;

import com.feedbackgenerator.models.LearningMaterial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Ershadi Sayuri on 3/11/2016.
 */
public class CSVFileRead {
    private static final String FILE_PATH = "material 11.csv";

    public ArrayList<LearningMaterial> readCSVFile() {
        String csvFile = "material 11.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        ArrayList<LearningMaterial> learningMaterials = new ArrayList<LearningMaterial>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] material = line.split(cvsSplitBy);

                LearningMaterial learningMaterial = new LearningMaterial();
                learningMaterial.setUrl(material[0]);
                learningMaterial.setTitle(material[1]);
                learningMaterial.setVideo(Integer.parseInt(material[2]));
                learningMaterial.setImages(Integer.parseInt(material[3]));
                learningMaterial.setParagraph(Boolean.parseBoolean(material[4]));
                learningMaterial.setBullets(Boolean.parseBoolean(material[5]));
                learningMaterial.setExamples(Boolean.parseBoolean(material[6]));
                learningMaterial.setAdvanced(Boolean.parseBoolean(material[7]));
                learningMaterial.setMedium(Boolean.parseBoolean(material[8]));
                learningMaterial.setEasy(Boolean.parseBoolean(material[9]));
                learningMaterial.setTopic(material[10]);
                learningMaterial.setFactsAndProcedures(Boolean.parseBoolean(material[11]));
                learningMaterial.setTheoriesAndMeaning(Boolean.parseBoolean(material[12]));
                learningMaterial.setStepsGiven(Boolean.parseBoolean(material[13]));
                learningMaterial.setPractical(Boolean.parseBoolean(material[14]));
                learningMaterial.setThinking(Boolean.parseBoolean(material[15]));

                learningMaterials.add(learningMaterial);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");

        return learningMaterials;
    }
}
