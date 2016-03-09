package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */
public class QuestionAnswers {
    private int question;
    private String answer;
    private int answerFormat;

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getAnswerFormat() {
        return answerFormat;
    }

    public void setAnswerFormat(int answerFormat) {
        this.answerFormat = answerFormat;
    }
}
