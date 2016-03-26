package com.feedbackgenerator.models;

import com.feedbackgenerator.dbconnection.DBConnectionPool;
import com.feedbackgenerator.dbhandler.DBHandler;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */
public class QuestionAttempt {
    private int id;
    private int questionUsageId;
    private int slot;
    private String behaviour;
    private int questionId;
    private int variant;
    private double maxMark;
    private double minFraction;
    private double maxFraction;
    private int flagged;
    private String questionSummary;
    private String rightAnswer;
    private String responseSummary;
    private long timeModified;

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public int getQuestionUsageId() {
        return questionUsageId;
    }

    /**
     * @param questionUsageId
     */
    public void setQuestionUsageId(int questionUsageId) {
        this.questionUsageId = questionUsageId;
    }

    /**
     * @return
     */
    public int getSlot() {
        return slot;
    }

    /**
     * @param slot
     */
    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getVariant() {
        return variant;
    }

    public void setVariant(int variant) {
        this.variant = variant;
    }

    public double getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(double maxMark) {
        this.maxMark = maxMark;
    }

    public double getMinFraction() {
        return minFraction;
    }

    public void setMinFraction(double minFraction) {
        this.minFraction = minFraction;
    }

    public double getMaxFraction() {
        return maxFraction;
    }

    public void setMaxFraction(double maxFraction) {
        this.maxFraction = maxFraction;
    }

    public int getFlagged() {
        return flagged;
    }

    public void setFlagged(int flagged) {
        this.flagged = flagged;
    }

    public String getQuestionSummary() {
        return questionSummary;
    }

    public void setQuestionSummary(String questionSummary) {
        this.questionSummary = questionSummary;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getResponseSummary() {
        return responseSummary;
    }

    public void setResponseSummary(String responseSummary) {
        this.responseSummary = responseSummary;
    }

    public long getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(long timeModified) {
        this.timeModified = timeModified;
    }

    /**
     * get question attempt data of questions belonging to a particular question of a user
     *
     * @param userId
     * @param questionId
     * @return
     * @throws Exception
     */
    public ArrayList<QuestionAttempt> getQuestionAttemptDataOfAQuiz(int userId, int questionId) throws Exception {
        String query = "SELECT * FROM mdl_question_attempts WHERE questionid = " + questionId + " && id IN (SELECT " +
                "questionattemptid FROM mdl_question_attempt_steps WHERE userid = " + userId + ")";

        ResultSet resultSet = DBHandler.getData(DBConnectionPool.getConnectionToDB(), query);

        ArrayList<QuestionAttempt> questionAttempts = new ArrayList<QuestionAttempt>();

        while (resultSet.next()) {
            QuestionAttempt questionAttempt = new QuestionAttempt();

            questionAttempt.setId(Integer.parseInt(resultSet.getString(1)));
            questionAttempt.setQuestionUsageId(Integer.parseInt(resultSet.getString(2)));
            questionAttempt.setSlot(Integer.parseInt(resultSet.getString(3)));
            questionAttempt.setBehaviour(resultSet.getString(4));
            questionAttempt.setQuestionId(Integer.parseInt(resultSet.getString(5)));
            questionAttempt.setVariant(Integer.parseInt(resultSet.getString(6)));
            questionAttempt.setMaxMark(Double.parseDouble(resultSet.getString(7)));
            questionAttempt.setMinFraction(Double.parseDouble(resultSet.getString(8)));
            questionAttempt.setMaxFraction(Double.parseDouble(resultSet.getString(9)));
            questionAttempt.setFlagged(Integer.parseInt(resultSet.getString(10)));
            questionAttempt.setQuestionSummary(resultSet.getString(11));
            questionAttempt.setRightAnswer(resultSet.getString(12));
            questionAttempt.setResponseSummary(resultSet.getString(13));
            questionAttempt.setTimeModified(Long.parseLong(resultSet.getString(5)));

            questionAttempts.add(questionAttempt);
        }

        return questionAttempts;
    }
}
