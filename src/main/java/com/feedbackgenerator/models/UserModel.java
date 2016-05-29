package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 5/30/2016.
 */
public class UserModel {
    private int userId;
    private boolean video;
    private boolean images;
    private boolean paragraph;
    private boolean bullets;
    private boolean examples;
    private boolean factsAndProcedures;
    private boolean theoriesAndMeaning;
    private boolean stepsGiven;
    private boolean practical;
    private boolean thinking;

    public UserModel(int userId, boolean video, boolean images, boolean paragraph, boolean bullets, boolean examples,
                     boolean factsAndProcedures, boolean theoriesAndMeaning, boolean stepsGiven,
                     boolean practical, boolean thinking) {
        this.userId = userId;
        this.video = video;
        this.images = images;
        this.paragraph = paragraph;
        this.bullets = bullets;
        this.examples = examples;
        this.factsAndProcedures = factsAndProcedures;
        this.theoriesAndMeaning = theoriesAndMeaning;
        this.stepsGiven = stepsGiven;
        this.practical = practical;
        this.thinking = thinking;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isVideo() {
        return video;
    }

    public boolean isImages() {
        return images;
    }

    public boolean isParagraph() {
        return paragraph;
    }

    public boolean isBullets() {
        return bullets;
    }

    public boolean isExamples() {
        return examples;
    }

    public boolean isFactsAndProcedures() {
        return factsAndProcedures;
    }

    public boolean isTheoriesAndMeaning() {
        return theoriesAndMeaning;
    }

    public boolean isStepsGiven() {
        return stepsGiven;
    }

    public boolean isPractical() {
        return practical;
    }

    public boolean isThinking() {
        return thinking;
    }
}
