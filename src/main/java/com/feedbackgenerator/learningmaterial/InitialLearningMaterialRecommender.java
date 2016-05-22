package com.feedbackgenerator.learningmaterial;

import com.feedbackgenerator.filehandling.CSVFileRead;
import com.feedbackgenerator.models.Knowledge;
import com.feedbackgenerator.models.LearningMaterial;

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
    public static Knowledge filterRecommendationsByTopic(Knowledge knowledge) throws SQLException, ClassNotFoundException {
        CSVFileRead obj = new CSVFileRead();
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
            if (knowledge.getSensoryOrIntuitive() < -8) {
                if (learningMaterial.isFactsAndProcedures() && !learningMaterial.isParagraph()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getSensoryOrIntuitive() < -4) {
                if (learningMaterial.isFactsAndProcedures() && learningMaterial.isTheoriesAndMeaning()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getSensoryOrIntuitive() < 0) {
                if (learningMaterial.isFactsAndProcedures() || learningMaterial.isTheoriesAndMeaning()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getSensoryOrIntuitive() < 4) {
                if (learningMaterial.isTheoriesAndMeaning() || learningMaterial.isParagraph()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getSensoryOrIntuitive() < 8) {
                if (learningMaterial.isTheoriesAndMeaning() && learningMaterial.isParagraph()) {
                    filteredLM.add(learningMaterial);
                }
            } else {
                if (learningMaterial.isParagraph()) {
                    filteredLM.add(learningMaterial);
                }
            }

            if (knowledge.getVisualOrVerbal() < -8) {
                if (learningMaterial.getImages() > 0 && learningMaterial.isFactsAndProcedures() && !learningMaterial.isParagraph()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getVisualOrVerbal() < -4) {
                if (learningMaterial.getImages() > 0 && learningMaterial.isFactsAndProcedures()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getVisualOrVerbal() < 0) {
                if (learningMaterial.getImages() > 0 || learningMaterial.isFactsAndProcedures()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getVisualOrVerbal() < 4) {
                if (learningMaterial.getVideo() > 0 || learningMaterial.isBullets()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getVisualOrVerbal() < 8) {
                if (learningMaterial.getVideo() > 0 && learningMaterial.isBullets()) {
                    filteredLM.add(learningMaterial);
                }
            } else {
                if (learningMaterial.getVideo() > 0) {
                    filteredLM.add(learningMaterial);
                }
            }

            if (knowledge.getSequentialOrGlobal() < 0) {
                if (learningMaterial.isStepsGiven()) {
                    filteredLM.add(learningMaterial);
                }
            } else {
                if (!learningMaterial.isStepsGiven()) {
                    filteredLM.add(learningMaterial);
                }
            }

            if (knowledge.getActiveOrReflective() < -8) {
                if (learningMaterial.isPractical()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getActiveOrReflective() < -4) {
                if (learningMaterial.isPractical() || learningMaterial.isExamples()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getActiveOrReflective() < 0) {
                if (learningMaterial.isPractical() && learningMaterial.isExamples()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getActiveOrReflective() < 4) {
                if (learningMaterial.isThinking() && learningMaterial.isExamples()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getActiveOrReflective() < 8) {
                if (learningMaterial.isThinking() || learningMaterial.isExamples()) {
                    filteredLM.add(learningMaterial);
                }
            } else {
                if (learningMaterial.isThinking()) {
                    filteredLM.add(learningMaterial);

                }
            }
        }

        return filteredLM;
    }

    /**
     *
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
                    filteredLM.add(learningMaterial);
                } else if (learningMaterial.isEasy() && learningMaterial.isMedium()) {
                    filteredLM.add(learningMaterial);
                } else if (learningMaterial.isEasy()) {
                    filteredLM.add(learningMaterial);
                }
            } else if (knowledge.getTopicKnowledge() < 0.6) {
                if (learningMaterial.isMedium() && learningMaterial.isAdvanced()) {
                    filteredLM.add(learningMaterial);
                } else if (learningMaterial.isMedium()) {
                    filteredLM.add(learningMaterial);
                }
            } else {
                if (learningMaterial.isAdvanced()) {
                    filteredLM.add(learningMaterial);
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
    public static ArrayList<LearningMaterial> checkHistory(ArrayList<LearningMaterial> learningMaterials) throws
            ClassNotFoundException, SQLException {

        ArrayList<String> learningMaterialUrls = new ArrayList<String>();
        for (LearningMaterial learningMaterial : learningMaterials) {
            learningMaterialUrls.add(learningMaterial.getUrl());
        }

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:./History");
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