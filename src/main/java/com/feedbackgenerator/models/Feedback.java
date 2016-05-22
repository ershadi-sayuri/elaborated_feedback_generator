package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 4/16/2016.
 */
public class Feedback {
    private String description;
    private LearningMaterial[] learningMaterials;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LearningMaterial[] getLearningMaterials() {
        return learningMaterials;
    }

    public void setLearningMaterials(LearningMaterial[] learningMaterials) {
        this.learningMaterials = learningMaterials;
    }
}
