package com.feedbackgenerator.other;

import com.feedbackgenerator.filehandling.CSVFileReader;
import com.feedbackgenerator.models.Knowledge;
import com.feedbackgenerator.models.LearningMaterial;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/11/2016.
 */
public class InitialLearningMaterialRecommender {
    /**
     * @param knowledge
     * @return knowledge
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Knowledge filterRecommendationsByTopic(Knowledge knowledge) throws SQLException, ClassNotFoundException {
        CSVFileReader obj = new CSVFileReader();
        ArrayList<LearningMaterial> learningMaterials = obj.readCSVFile();

        ArrayList<LearningMaterial> topicFilteredLM = new ArrayList<LearningMaterial>();

        for (LearningMaterial learningMaterial : learningMaterials) {
            // check whether the topic area of the knowledge is similar to learning material topic are
            if (knowledge.getTopic().contains(learningMaterial.getTopic())) {
                topicFilteredLM.add(learningMaterial);
            }
        }

        ArrayList<LearningMaterial> preferenceFilteredLM = filterRecommendationsByUserPreference(knowledge, topicFilteredLM);
        ArrayList<LearningMaterial> knowledgeFilteredLM = filterRecommendationsByUserKnowledge(knowledge, preferenceFilteredLM);
        ArrayList<LearningMaterial> historyFilteredLM = checkHistory(knowledgeFilteredLM);

        if (historyFilteredLM.size() > 0) {
            for (LearningMaterial url : historyFilteredLM) {
                System.out.println(url.getUrl());
            }
            knowledge.setRecommendation(historyFilteredLM.get(0).getUrl());
        } else if (knowledgeFilteredLM.size() > 0) {
            knowledge.setRecommendation(knowledgeFilteredLM.get(0).getUrl());
        } else if (preferenceFilteredLM.size() > 0) {
            knowledge.setRecommendation(preferenceFilteredLM.get(0).getUrl());
        } else if (topicFilteredLM.size() > 0) {
            knowledge.setRecommendation(topicFilteredLM.get(0).getUrl());
        } else {
            knowledge.setRecommendation(learningMaterials.get(0).getUrl());
        }

        return knowledge;
    }

    /**
     * @param knowledge
     * @param learningMaterials
     * @return filteredLM
     */
    public static ArrayList<LearningMaterial> filterRecommendationsByUserPreference(Knowledge knowledge, ArrayList<LearningMaterial> learningMaterials) {
        ArrayList<LearningMaterial> filteredLM = new ArrayList<LearningMaterial>();

        for (LearningMaterial learningMaterial : learningMaterials) {
            if (knowledge.getSensoryOrIntuitive() < -8 && knowledge.getSensoryOrIntuitive() < 8 &&
                    knowledge.getVisualOrVerbal() < -8 && knowledge.getSequentialOrGlobal() < -8) {
                if (learningMaterial.isFactsAndProcedures() && !learningMaterial.isParagraph() &&
                        learningMaterial.getImages() > 0 && learningMaterial.isStepsGiven() &&
                        learningMaterial.isPractical()) {
                    if (!filteredLM.contains(learningMaterial)) {
                        filteredLM.add(learningMaterial);
                    }
                }
            } else {
                if (knowledge.getSensoryOrIntuitive() < -8) {
                    if (learningMaterial.isFactsAndProcedures() && !learningMaterial.isParagraph()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getSensoryOrIntuitive() < -4) {
                    if (learningMaterial.isFactsAndProcedures() && learningMaterial.isTheoriesAndMeaning()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getSensoryOrIntuitive() < 0) {
                    if (learningMaterial.isFactsAndProcedures() || learningMaterial.isTheoriesAndMeaning()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getSensoryOrIntuitive() < 4) {
                    if (learningMaterial.isTheoriesAndMeaning() || learningMaterial.isParagraph()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getSensoryOrIntuitive() < 8) {
                    if (learningMaterial.isTheoriesAndMeaning() && learningMaterial.isParagraph()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else {
                    if (learningMaterial.isParagraph()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                }


                if (knowledge.getVisualOrVerbal() < -8) {
                    if (learningMaterial.getImages() > 0 && learningMaterial.isFactsAndProcedures() && !learningMaterial.isParagraph()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getVisualOrVerbal() < -4) {
                    if (learningMaterial.getImages() > 0 && learningMaterial.isFactsAndProcedures()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getVisualOrVerbal() < 0) {
                    if (learningMaterial.getImages() > 0 || learningMaterial.isFactsAndProcedures()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getVisualOrVerbal() < 4) {
                    if (learningMaterial.getVideo() > 0 || learningMaterial.isBullets()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getVisualOrVerbal() < 8) {
                    if (learningMaterial.getVideo() > 0 && learningMaterial.isBullets()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else {
                    if (learningMaterial.getVideo() > 0) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                }

                if (knowledge.getSequentialOrGlobal() < 0) {
                    if (learningMaterial.isStepsGiven()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else {
                    if (!learningMaterial.isStepsGiven()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                }

                if (knowledge.getActiveOrReflective() < -8) {
                    if (learningMaterial.isPractical()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getActiveOrReflective() < -4) {
                    if (learningMaterial.isPractical() || learningMaterial.isExamples()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getActiveOrReflective() < 0) {
                    if (learningMaterial.isPractical() && learningMaterial.isExamples()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getActiveOrReflective() < 4) {
                    if (learningMaterial.isThinking() && learningMaterial.isExamples()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else if (knowledge.getActiveOrReflective() < 8) {
                    if (learningMaterial.isThinking() || learningMaterial.isExamples()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }
                    }
                } else {
                    if (learningMaterial.isThinking()) {
                        if (!filteredLM.contains(learningMaterial)) {
                            filteredLM.add(learningMaterial);
                        }

                    }
                }
            }
        }

        return filteredLM;
    }

    /**
     * @param knowledge
     * @param learningMaterials
     * @return filteredLM
     */
    public static ArrayList<LearningMaterial> filterRecommendationsByUserKnowledge(Knowledge knowledge,
                                                                                   ArrayList<LearningMaterial>
                                                                                           learningMaterials) {
        ArrayList<LearningMaterial> filteredLM = new ArrayList<LearningMaterial>();

        for (LearningMaterial learningMaterial : learningMaterials) {
            if (knowledge.getTopicKnowledge() < 0.3) {
                if (learningMaterial.isEasy() && learningMaterial.isMedium() && learningMaterial.isAdvanced()) {
                    if (!filteredLM.contains(learningMaterial)) {
                        filteredLM.add(learningMaterial);
                    }
                } else if (learningMaterial.isEasy() && learningMaterial.isMedium()) {
                    if (!filteredLM.contains(learningMaterial)) {
                        filteredLM.add(learningMaterial);
                    }
                } else if (learningMaterial.isEasy()) {
                    if (!filteredLM.contains(learningMaterial)) {
                        filteredLM.add(learningMaterial);
                    }
                }
            } else if (knowledge.getTopicKnowledge() < 0.6) {
                if (learningMaterial.isMedium() && learningMaterial.isAdvanced()) {
                    if (!filteredLM.contains(learningMaterial)) {
                        filteredLM.add(learningMaterial);
                    }
                } else if (learningMaterial.isMedium()) {
                    if (!filteredLM.contains(learningMaterial)) {
                        filteredLM.add(learningMaterial);
                    }
                }
            } else {
                if (learningMaterial.isAdvanced()) {
                    if (!filteredLM.contains(learningMaterial)) {
                        filteredLM.add(learningMaterial);
                    }
                }
            }
        }

        return filteredLM;
    }

    /**
     * @param learningMaterials
     * @return filteredLM
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<LearningMaterial> checkHistory(ArrayList<LearningMaterial> learningMaterials) throws
            ClassNotFoundException, SQLException {

        ArrayList<String> learningMaterialUrls = new ArrayList<String>();
        for (LearningMaterial learningMaterial : learningMaterials) {
            learningMaterialUrls.add(learningMaterial.getUrl());
        }

        Class.forName("org.sqlite.JDBC");

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("History").getFile());

        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from  urls order by visit_count & typed_count desc;");

        ArrayList<LearningMaterial> filteredLM = new ArrayList<LearningMaterial>();
        while (rs.next()) {
            if (learningMaterialUrls.contains(rs.getString("url"))) {
                filteredLM.add(learningMaterials.get(learningMaterialUrls.indexOf(rs.getString("url"))));
            }
        }

        rs.close();
        conn.close();

        return filteredLM;
    }
}