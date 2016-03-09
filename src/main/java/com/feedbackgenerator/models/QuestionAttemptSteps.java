package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */
public class QuestionAttemptSteps {
    private int id;
    private int questionAttemptId;
    private int sequenceNumber;
    private String state;
    private double fraction;
    private long timeCreated;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionAttemptId() {
        return questionAttemptId;
    }

    public void setQuestionAttemptId(int questionAttemptId) {
        this.questionAttemptId = questionAttemptId;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
