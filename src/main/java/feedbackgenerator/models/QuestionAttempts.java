package feedbackgenerator.models;

import feedbackgenerator.dbconnection.DBConnectionPool;
import feedbackgenerator.dbconnection.DataSource;
import feedbackgenerator.dbhandler.DBHandler;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */
public class QuestionAttempts {
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

//    public QuestionAttempts getQuestionAttemptsData(QuestionAttempts questionAttempts) throws Exception {
//        String query = "SELECT * FROM mdl_quiz_attempts WHERE userid = " + questionAttempts.getQuestionUsageId();
//        Connection connection = DataSource.getConnection();
//        ResultSet resultSet = DBHandler.getData(connection, query);
//
//
//        if (resultSet.next()) {
//            questionAttempts.setId(Integer.parseInt(resultSet.getString(1)));
//            questionAttempts.setQui(resultSet.getString(3));
//            questionAttempts.setAddress(resultSet.getString(4));
//            questionAttempts.setContactNumber(resultSet.getString(5));
//        }
////        return customer;
//    }
}
