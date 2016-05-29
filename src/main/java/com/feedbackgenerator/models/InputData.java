package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 4/16/2016.
 */
public class InputData {
    private int userId;
    private int quizId;

    public InputData() {

    }

    public InputData(int userId, int quizId) {
        this.userId = userId;
        this.quizId = quizId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
}
