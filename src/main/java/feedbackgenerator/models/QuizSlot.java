package feedbackgenerator.models;

import feedbackgenerator.dbconnection.DataSource;
import feedbackgenerator.dbhandler.DBHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/13/2016.
 */
public class QuizSlot {
    private int id;
    private int slot;
    private int quizId;
    private int page;
    private int requirePrevious;
    private int questionId;
    private double maxMark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRequirePrevious() {
        return requirePrevious;
    }

    public void setRequirePrevious(int requirePrevious) {
        this.requirePrevious = requirePrevious;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public double getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(double maxMark) {
        this.maxMark = maxMark;
    }

    /**
     * get the maximum of a particular quiz
     *
     * @param quizId
     * @return
     * @throws Exception
     */
//    public double getQuizMaxTotal(int quizId) throws Exception {
//        String query = "SELECT SUM(maxmark) FROM mdl_quiz_slots WHERE quizid = " + quizId;
//        Connection connection = DataSource.getConnection();
//        ResultSet resultSet = DBHandler.getData(connection, query);
//
//        ArrayList<QuizAttempt> quizAttempts = new ArrayList<QuizAttempt>();
//
//        double maxMark = 0;
//
//        if (resultSet.next()) {
//            maxMark = Double.parseDouble(resultSet.getString(1));
//        }
//
//        return maxMark;
//    }
}
