package com.feedbackgenerator.filehandling;

import com.feedbackgenerator.models.LearningMaterial;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/18/2016.
 */
public class CSVFileReader {
    public static Instances readDataFile(String filename) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource(filename);
        Instances data = source.getDataSet();

        return data;
    }

    public Instances getInstancesForCBF(String fileName, int userId) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        Instances data = readDataFile(file.getAbsolutePath());

        double id = userId;
        String rowHeadings = "";

        if (data.numAttributes() > 17) {
            for (int i = 17; i < data.numAttributes(); i++) {
                if (data.attribute(i).name().equals(id)) {
                    rowHeadings += i + ",";
                }
            }

        }

        Remove remove = new Remove();
        remove.setAttributeIndices(rowHeadings);
        remove.setInvertSelection(false);
        remove.setInputFormat(data);
        Instances newData = Filter.useFilter(data, remove);

        return newData;
    }

    public ArrayList<LearningMaterial> readCSVFile() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        String file = classLoader.getResource("materials.csv").getFile();
        String csvFile = file;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        ArrayList<LearningMaterial> learningMaterials = new ArrayList<LearningMaterial>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] material = line.split(cvsSplitBy);

                LearningMaterial learningMaterial = new LearningMaterial(material[0], material[1],
                        Integer.parseInt(material[2]), Integer.parseInt(material[3]), Boolean.parseBoolean(material[4]),
                        Boolean.parseBoolean(material[5]), Boolean.parseBoolean(material[6]),
                        Boolean.parseBoolean(material[7]), Boolean.parseBoolean(material[8]),
                        Boolean.parseBoolean(material[9]), material[10], (Boolean.parseBoolean(material[11])),
                        Boolean.parseBoolean(material[12]), Boolean.parseBoolean(material[13]),
                        Boolean.parseBoolean(material[14]), Boolean.parseBoolean(material[15]),
                        Double.parseDouble(material[16]));

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

        return learningMaterials;
    }
}
