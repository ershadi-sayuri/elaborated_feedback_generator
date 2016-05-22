package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 3/11/2016.
 */
public class LearningMaterial {

    private String url;
    private String title;
    private int video;
    private int images;
    private boolean paragraph;
    private boolean bullets;
    private boolean examples;
    private boolean advanced;
    private boolean medium;
    private boolean easy;
    private String topic;
    private boolean factsAndProcedures;
    private boolean theoriesAndMeaning;
    private boolean stepsGiven;
    private boolean practical;
    private boolean thinking;

    public double getKeywordRelevance() {
        return keywordRelevance;
    }

    public void setKeywordRelevance(double keywordRelevance) {
        this.keywordRelevance = keywordRelevance;
    }

    private double keywordRelevance;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public boolean isParagraph() {
        return paragraph;
    }

    public void setParagraph(boolean paragraph) {
        this.paragraph = paragraph;
    }

    public boolean isBullets() {
        return bullets;
    }

    public void setBullets(boolean bullets) {
        this.bullets = bullets;
    }

    public boolean isExamples() {
        return examples;
    }

    public void setExamples(boolean examples) {
        this.examples = examples;
    }

    public boolean isAdvanced() {
        return advanced;
    }

    public void setAdvanced(boolean advanced) {
        this.advanced = advanced;
    }

    public boolean isMedium() {
        return medium;
    }

    public void setMedium(boolean medium) {
        this.medium = medium;
    }

    public boolean isEasy() {
        return easy;
    }

    public void setEasy(boolean easy) {
        this.easy = easy;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isFactsAndProcedures() {
        return factsAndProcedures;
    }

    public void setFactsAndProcedures(boolean factsAndProcedures) {
        this.factsAndProcedures = factsAndProcedures;
    }

    public boolean isTheoriesAndMeaning() {
        return theoriesAndMeaning;
    }

    public void setTheoriesAndMeaning(boolean theoriesAndMeaning) {
        this.theoriesAndMeaning = theoriesAndMeaning;
    }

    public boolean isStepsGiven() {
        return stepsGiven;
    }

    public void setStepsGiven(boolean stepsGiven) {
        this.stepsGiven = stepsGiven;
    }

    public boolean isPractical() {
        return practical;
    }

    public void setPractical(boolean practical) {
        this.practical = practical;
    }

    public boolean isThinking() {
        return thinking;
    }

    public void setThinking(boolean thinking) {
        this.thinking = thinking;
    }
}
