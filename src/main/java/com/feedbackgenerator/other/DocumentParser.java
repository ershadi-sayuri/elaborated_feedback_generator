package com.feedbackgenerator.other;

import com.feedbackgenerator.filehandling.CSVFileReader;
import com.feedbackgenerator.models.LearningMaterial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ershadi Sayuri on 5/21/2016.
 */
public class DocumentParser {
    //This variable will hold all terms of each document in an array.
    private String[] termsDocsArray;
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms

    /**
     * Method to read files and store in array.
     *
     * @param stringUrl : source file path
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void parseFiles(String stringUrl) throws IOException {

        URL url = new URL(stringUrl);
        HttpURLConnection conn = ( HttpURLConnection ) url.openConnection();
        conn.setRequestMethod("GET");
        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }

        String nohtml = sb.toString().replaceAll("\\<.*?>", "");
        String[] tokenizedTerms = nohtml.split("\\W+");   //to get individual terms

        for (String term : tokenizedTerms) {
            if (!allTerms.contains(term)) {  //avoid duplicate entry
                allTerms.add(term);
            }
        }

        termsDocsArray = tokenizedTerms;
        in.close();
    }

    /**
     * Method to create termVector according to its tfidf score.
     */
    public double tfCalculator(String term) {
        double count = 0;  //to count the overall occurrence of the term termToCheck
        for (String s : termsDocsArray) {
            if (s.equalsIgnoreCase(term)) {
                count++;
            }
        }
        return count / termsDocsArray.length;
    }

    public static void main(String args[]) {
        CSVFileReader csvFileRead = new CSVFileReader();
        ArrayList<LearningMaterial> learningMaterials = csvFileRead.readCSVFile();

        for (int i = 0; i < learningMaterials.size(); i++) {
            DocumentParser dp = new DocumentParser();

            double tf = 0;
            double avgTf;
            try {
                dp.parseFiles(learningMaterials.get(i).getUrl());

                String[] topic = learningMaterials.get(i).getTopic().split(" ");

                for (int j = 0; j < topic.length; j++) {
                    tf += dp.tfCalculator(topic[j]);
                }

                avgTf = tf / topic.length;
            } catch (IOException e) {
                e.printStackTrace();
                avgTf = 0;
            }
        }
    }
}
