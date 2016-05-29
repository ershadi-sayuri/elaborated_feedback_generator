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
    private double keywordRelevance;


    public LearningMaterial(String url, String title, int video, int images, boolean paragraph, boolean bullets,
                            boolean examples, boolean advanced, boolean medium, boolean easy, String topic,
                            boolean factsAndProcedures, boolean theoriesAndMeaning, boolean stepsGiven,
                            boolean practical, boolean thinking, double keywordRelevance) {
        this.url = url;
        this.title = title;
        this.video = video;
        this.images = images;
        this.paragraph = paragraph;
        this.bullets = bullets;
        this.examples = examples;
        this.advanced = advanced;
        this.medium = medium;
        this.easy = easy;
        this.topic = topic;
        this.factsAndProcedures = factsAndProcedures;
        this.theoriesAndMeaning = theoriesAndMeaning;
        this.stepsGiven = stepsGiven;
        this.practical = practical;
        this.thinking = thinking;
        this.keywordRelevance = keywordRelevance;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public int getVideo() {
        return video;
    }

    public int getImages() {
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

    public boolean isAdvanced() {
        return advanced;
    }

    public boolean isMedium() {
        return medium;
    }

    public boolean isEasy() {
        return easy;
    }

    public String getTopic() {
        return topic;
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

    public double getKeywordRelevance() {
        return keywordRelevance;
    }
}
