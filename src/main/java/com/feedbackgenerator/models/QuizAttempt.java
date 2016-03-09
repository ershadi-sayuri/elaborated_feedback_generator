package com.feedbackgenerator.models;

import com.feedbackgenerator.dbconnection.DBConnectionPool;
import com.feedbackgenerator.dbhandler.DBHandler;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */
public class QuizAttempt {
    private int id;
    private int quiz;
    private int userId;
    private int attempt;
    private int uniqueId;
    private String layout;
    private int currentPage;
    private int preview;
    private String state;
    private long timeStart;
    private long timeFinish;
    private long timeModified;
    private String timeCheckState;
    private double sumGrades;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPreview() {
        return preview;
    }

    public void setPreview(int preview) {
        this.preview = preview;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    public long getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(long timeFinish) {
        this.timeFinish = timeFinish;
    }

    public long getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(long timeModified) {
        this.timeModified = timeModified;
    }

    public String getTimeCheckState() {
        return timeCheckState;
    }

    public void setTimeCheckState(String timeCheckState) {
        this.timeCheckState = timeCheckState;
    }

    public double getSumGrades() {
        return sumGrades;
    }

    public void setSumGrades(double sumGrades) {
        this.sumGrades = sumGrades;
    }

    /**
     * gets the attempt data of a particular quiz of a user
     *
     * @param userId
     * @param quizId
     * @return quizAttempts
     * @throws Exception
     */
    public ArrayList<QuizAttempt> getAttemptDataOfAQuiz(int userId, int quizId) throws Exception {
        String query = "SELECT * FROM mdl_quiz_attempts WHERE userid = " + userId + " && quiz=" + quizId;
        ResultSet resultSet = DBHandler.getData(DBConnectionPool.getConnectionToDB(), query);

        ArrayList<QuizAttempt> quizAttempts = new ArrayList<QuizAttempt>();

        while (resultSet.next()) {
            QuizAttempt quizAttempt = new QuizAttempt();

            quizAttempt.setId(Integer.parseInt(resultSet.getString(1)));
            quizAttempt.setQuiz(Integer.parseInt(resultSet.getString(2)));
            quizAttempt.setUserId(Integer.parseInt(resultSet.getString(3)));
            quizAttempt.setAttempt(Integer.parseInt(resultSet.getString(4)));
            quizAttempt.setUniqueId(Integer.parseInt(resultSet.getString(5)));
            quizAttempt.setLayout(resultSet.getString(6));
            quizAttempt.setCurrentPage(Integer.parseInt(resultSet.getString(7)));
            quizAttempt.setPreview(Integer.parseInt(resultSet.getString(8)));
            quizAttempt.setState(resultSet.getString(9));
            quizAttempt.setTimeStart(Long.parseLong(resultSet.getString(10)));
            quizAttempt.setTimeFinish(Long.parseLong(resultSet.getString(11)));
            quizAttempt.setTimeModified(Long.parseLong(resultSet.getString(12)));
            quizAttempt.setTimeCheckState(resultSet.getString(13));
            quizAttempt.setSumGrades(Double.parseDouble(resultSet.getString(14)));

            quizAttempts.add(quizAttempt);
        }

        return quizAttempts;
    }

    public ArrayList<Integer> getUserQuizIds(int userId) throws Exception {
        String query = "SELECT quiz FROM mdl_quiz_attempts WHERE userid = " + userId + " GROUP BY quiz";
        ResultSet resultSet = DBHandler.getData(DBConnectionPool.getConnectionToDB(), query);

        ArrayList<Integer> quizIds = new ArrayList<Integer>();

        while (resultSet.next()) {
            quizIds.add(Integer.parseInt(resultSet.getString(1)));
        }

        return quizIds;
    }

    public ArrayList<QuizAttempt> getUserQuizAttempts(int quizId) throws Exception {
        String query = "SELECT * FROM mdl_quiz_attempts WHERE quiz=" + quizId;
        ResultSet resultSet = DBHandler.getData(DBConnectionPool.getConnectionToDB(), query);

        ArrayList<QuizAttempt> quizAttempts = new ArrayList<QuizAttempt>();

        while (resultSet.next()) {
            QuizAttempt quizAttempt = new QuizAttempt();

            quizAttempt.setId(Integer.parseInt(resultSet.getString(1)));
            quizAttempt.setQuiz(Integer.parseInt(resultSet.getString(2)));
            quizAttempt.setUserId(Integer.parseInt(resultSet.getString(3)));
            quizAttempt.setAttempt(Integer.parseInt(resultSet.getString(4)));
            quizAttempt.setUniqueId(Integer.parseInt(resultSet.getString(5)));
            quizAttempt.setLayout(resultSet.getString(6));
            quizAttempt.setCurrentPage(Integer.parseInt(resultSet.getString(7)));
            quizAttempt.setPreview(Integer.parseInt(resultSet.getString(8)));
            quizAttempt.setState(resultSet.getString(9));
            quizAttempt.setTimeStart(Long.parseLong(resultSet.getString(10)));
            quizAttempt.setTimeFinish(Long.parseLong(resultSet.getString(11)));
            quizAttempt.setTimeModified(Long.parseLong(resultSet.getString(12)));
            quizAttempt.setTimeCheckState(resultSet.getString(13));
            quizAttempt.setSumGrades(Double.parseDouble(resultSet.getString(14)));

            quizAttempts.add(quizAttempt);
        }

        return quizAttempts;
    }
}
