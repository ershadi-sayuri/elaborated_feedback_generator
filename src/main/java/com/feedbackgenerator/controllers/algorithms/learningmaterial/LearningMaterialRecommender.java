package com.feedbackgenerator.controllers.algorithms.learningmaterial;

import com.feedbackgenerator.enums.FSLSModels;
import com.feedbackgenerator.filehandling.CSVFileReader;
import com.feedbackgenerator.models.Knowledge;
import com.feedbackgenerator.models.LearningMaterial;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/11/2016.
 */
public class LearningMaterialRecommender {
    public Knowledge filterRecommendationsByTopic(Knowledge knowledge) {
        CSVFileReader obj = new CSVFileReader();
        ArrayList<LearningMaterial> learningMaterials = obj.readCSVFile();

        ArrayList<LearningMaterial> matchedLM = new ArrayList<LearningMaterial>();

        for (LearningMaterial learningMaterial : learningMaterials) {
            // check whether the topic area of the knowledge is similar to learning material topic are
            if (knowledge.getTopic().contains(learningMaterial.getTopic())) {
                System.out.println(knowledge.getTopic() + "  " + learningMaterial.getTopic() + "  " + learningMaterial.getTitle());
                matchedLM.add(learningMaterial);
            }
        }

        ArrayList<LearningMaterial> learningMaterials1 = filterRecommendationsByUserPreference(knowledge, matchedLM);

        if (learningMaterials1.size() > 0) {
            knowledge.setRecommendation(learningMaterials1.get(0).getUrl());
        } else if (matchedLM.size() > 0) {
            knowledge.setRecommendation(matchedLM.get(0).getUrl());
        } else {
            knowledge.setRecommendation(learningMaterials.get(0).getUrl());
        }

        return knowledge;
    }

    public ArrayList<LearningMaterial> filterRecommendationsByUserPreference(Knowledge knowledge, ArrayList<LearningMaterial> learningMaterials) {
        ArrayList<LearningMaterial> learningMaterials1 = new ArrayList<LearningMaterial>();

        for (LearningMaterial learningMaterial : learningMaterials) {
            if (knowledge.getSensoryOrIntuitive().equals(FSLSModels.SENSORY)) {
                if (learningMaterial.isFactsAndProcedures()) {
                    learningMaterials1.add(learningMaterial);
                }
            }
            if (knowledge.getSensoryOrIntuitive().equals(FSLSModels.INTUITIVE)) {
                if (learningMaterial.isTheoriesAndMeaning()) {
                    learningMaterials1.add(learningMaterial);
                }
            }

            if (knowledge.getVisualOrVerbal().equals(FSLSModels.VISUAL)) {
                if (learningMaterial.getImages() > 0) {
                    learningMaterials1.add(learningMaterial);
                }
            }
            if (knowledge.getVisualOrVerbal().equals(FSLSModels.VERBAL)) {
                if (learningMaterial.getVideo() > 0) {
                    learningMaterials1.add(learningMaterial);
                } else if (learningMaterial.isBullets()) {
                    learningMaterials1.add(learningMaterial);
                }
            }

            if (knowledge.getSequentialOrGlobal().equals(FSLSModels.SEQUENTIAL)) {
                if (learningMaterial.isStepsGiven()) {
                    learningMaterials1.add(learningMaterial);
                }
            }
            if (knowledge.getSequentialOrGlobal().equals(FSLSModels.GLOBAL)) {
                if (!learningMaterial.isStepsGiven()) {
                    learningMaterials1.add(learningMaterial);
                }
            }

            if (knowledge.getActiveOrReflective().equals(FSLSModels.ACTIVE)) {
                if (learningMaterial.isPractical()) {
                    learningMaterials1.add(learningMaterial);
                }
            }
            if (knowledge.getActiveOrReflective().equals(FSLSModels.REFLECTIVE)) {
                if (learningMaterial.isThinking()) {
                    learningMaterials1.add(learningMaterial);
                }
            }
        }

        return learningMaterials1;
    }

    public ArrayList<LearningMaterial> filterRecommendationsByUserKnowledge(Knowledge knowledge, ArrayList<LearningMaterial> learningMaterials) {
        ArrayList<LearningMaterial> learningMaterials2 = new ArrayList<LearningMaterial>();

        for (LearningMaterial learningMaterial : learningMaterials) {
            if (knowledge.getTopicKnowledge() < 0.3) {
                if (learningMaterial.isEasy()) {
                    learningMaterials2.add(learningMaterial);
                }
            } else if (knowledge.getTopicKnowledge() < 0.6) {
                if (learningMaterial.isMedium()) {
                    learningMaterials2.add(learningMaterial);
                }
            } else {
                if (learningMaterial.isAdvanced()) {
                    learningMaterials2.add(learningMaterial);
                }
            }
        }

        return learningMaterials2;
    }
}