package com.feedbackgenerator.models;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 4/16/2016.
 */
public class Feedback {
    private String description;
    private ArrayList<LearningMaterial> learningMaterials;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public ArrayList<LearningMaterial> getLearningMaterials() {
        return learningMaterials;
    }

    public void setLearningMaterials(ArrayList<LearningMaterial> learningMaterials) {
        this.learningMaterials = learningMaterials;
    }
}
