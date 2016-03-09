package com.feedbackgenerator.models;

import com.feedbackgenerator.dbconnection.DBConnectionPool;
import com.feedbackgenerator.dbhandler.DBHandler;

import java.sql.ResultSet;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */
public class QuizGrades {
    private int id;
    private int quiz;
    private int userId;
    private double grade;
    private long timeModified;

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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public long getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(long timeModified) {
        this.timeModified = timeModified;
    }

    public QuizGrades getQuizGradesData(int userId, int quizId) throws Exception {
        String query = "SELECT * FROM mdl_quiz_grades WHERE userid = " + userId + " && quiz = " + quizId;
        ResultSet resultSet = DBHandler.getData(DBConnectionPool.getConnectionToDB(), query);

        QuizGrades quizGrade = new QuizGrades();

        if (resultSet.next()) {
            quizGrade.setId(Integer.parseInt(resultSet.getString(1)));
            quizGrade.setQuiz(Integer.parseInt(resultSet.getString(2)));
            quizGrade.setUserId(Integer.parseInt(resultSet.getString(3)));
            quizGrade.setGrade(Double.parseDouble(resultSet.getString(4)));
            quizGrade.setTimeModified(Long.parseLong(resultSet.getString(5)));
        }

        return quizGrade;
    }
}
