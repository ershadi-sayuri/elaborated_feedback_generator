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
     * get the question ids of questions belonging to a particular quiz of a user
     *
     * @param quizId
     * @return
     * @throws Exception
     */
    public ArrayList<Integer> getQuestionIdsOfAQuiz(int quizId) throws Exception {
        String query = "SELECT questionid FROM mdl_quiz_slots WHERE quizid = " + quizId;

        Connection connection = DataSource.getConnection();
        ResultSet resultSet = DBHandler.getData(connection, query);

        ArrayList<Integer> questionIds = new ArrayList<Integer>();

        while (resultSet.next()) {
            questionIds.add(Integer.parseInt(resultSet.getString(1)));
        }

        return questionIds;
    }

    /**
     * get the difficulty wise question ids of questions belonging to a particular quiz of a user
     *
     * @param quizId
     * @return
     * @throws Exception
     */
    public ArrayList<Integer> getNameWiseQuestionIdsOfAQuiz(int quizId, String topic) throws Exception {
        String query = "SELECT questionid FROM mdl_quiz_slots WHERE quizid = " + quizId + " && questionid IN (SELECT " +
                "id from mdl_question WHERE name like '%" + topic + "%')";

        Connection connection = DataSource.getConnection();
        ResultSet resultSet = DBHandler.getData(connection, query);

        ArrayList<Integer> questionIds = new ArrayList<Integer>();

        while (resultSet.next()) {
            questionIds.add(Integer.parseInt(resultSet.getString(1)));
        }

        return questionIds;
    }

    public ArrayList<Integer> getDifficultyAndTopicWiseQuestionIdsOfAQuiz(int quizId, String topic, String difficulty) throws Exception {
        String query = "SELECT questionid FROM mdl_quiz_slots WHERE quizid = " + quizId + " && questionid IN (SELECT " +
                "id from mdl_question WHERE name like '%" + topic + "%' AND name like '%" + difficulty + "%')";

        Connection connection = DataSource.getConnection();
        ResultSet resultSet = DBHandler.getData(connection, query);

        ArrayList<Integer> questionIds = new ArrayList<Integer>();

        while (resultSet.next()) {
            questionIds.add(Integer.parseInt(resultSet.getString(1)));
        }

        return questionIds;
    }

    public ArrayList<String> getDifferentNamesOfQuestionsByQuiz(int quizId) throws Exception {
        String query = "SELECT name from mdl_question WHERE id IN (SELECT id from mdl_question GROUP BY name) && id " +
                "IN (SELECT questionid FROM mdl_quiz_slots WHERE quizid = " + quizId + ")";

        Connection connection = DataSource.getConnection();
        ResultSet resultSet = DBHandler.getData(connection, query);

        ArrayList<String> questionNames = new ArrayList<String>();

        while (resultSet.next()) {
            questionNames.add(resultSet.getString(1));
        }

        return questionNames;
    }

    public ArrayList<String> getDifferentNamesOfQuestions() throws Exception {
        String query = "SELECT name from mdl_question WHERE id IN (SELECT id from mdl_question GROUP BY name)";

        Connection connection = DataSource.getConnection();
        ResultSet resultSet = DBHandler.getData(connection, query);

        ArrayList<String> questionNames = new ArrayList<String>();

        while (resultSet.next()) {
            questionNames.add(resultSet.getString(1));
        }

        return questionNames;
    }
}
