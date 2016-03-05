package feedbackgenerator.models;

import feedbackgenerator.dbconnection.DBConnectionPool;
import feedbackgenerator.dbconnection.DataSource;
import feedbackgenerator.dbhandler.DBHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 2/14/2016.
 */
public class Quiz {
    private int id;
    private int course;
    private String name;
    private String intro;
    private int introFormat;
    private long timeOpen;
    private long timeClose;
    private int timeLimit;
    private String overDueHandling;
    private int gracePeriod;
    private String preferredBehaviour;
    private int canReDoQuestions;
    private int attempts;
    private int attemptOnLast;
    private int gradeMethod;
    private int decimalPoints;
    private int questionDecimalPoints;
    private int reviewAttempt;
    private int reviewCorrectness;
    private int reviewMarks;
    private int reviewSpecificFeedback;
    private int reviewGeneralFeedback;
    private int reviewRightAnswer;
    private int reviewOverallFeedback;
    private int questionsPerPage;
    private String navMethod;
    private int shuffleAnswers;
    private double sumGrades;
    private double grade;
    private long timeCreated;
    private long timeModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getIntroFormat() {
        return introFormat;
    }

    public void setIntroFormat(int introFormat) {
        this.introFormat = introFormat;
    }

    public long getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(long timeOpen) {
        this.timeOpen = timeOpen;
    }

    public long getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(long timeClose) {
        this.timeClose = timeClose;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getOverDueHandling() {
        return overDueHandling;
    }

    public void setOverDueHandling(String overDueHandling) {
        this.overDueHandling = overDueHandling;
    }

    public int getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(int gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public String getPreferredBehaviour() {
        return preferredBehaviour;
    }

    public void setPreferredBehaviour(String preferredBehaviour) {
        this.preferredBehaviour = preferredBehaviour;
    }

    public int getCanReDoQuestions() {
        return canReDoQuestions;
    }

    public void setCanReDoQuestions(int canReDoQuestions) {
        this.canReDoQuestions = canReDoQuestions;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAttemptOnLast() {
        return attemptOnLast;
    }

    public void setAttemptOnLast(int attemptOnLast) {
        this.attemptOnLast = attemptOnLast;
    }

    public int getGradeMethod() {
        return gradeMethod;
    }

    public void setGradeMethod(int gradeMethod) {
        this.gradeMethod = gradeMethod;
    }

    public int getDecimalPoints() {
        return decimalPoints;
    }

    public void setDecimalPoints(int decimalPoints) {
        this.decimalPoints = decimalPoints;
    }

    public int getQuestionDecimalPoints() {
        return questionDecimalPoints;
    }

    public void setQuestionDecimalPoints(int questionDecimalPoints) {
        this.questionDecimalPoints = questionDecimalPoints;
    }

    public int getReviewAttempt() {
        return reviewAttempt;
    }

    public void setReviewAttempt(int reviewAttempt) {
        this.reviewAttempt = reviewAttempt;
    }

    public int getReviewCorrectness() {
        return reviewCorrectness;
    }

    public void setReviewCorrectness(int reviewCorrectness) {
        this.reviewCorrectness = reviewCorrectness;
    }

    public int getReviewMarks() {
        return reviewMarks;
    }

    public void setReviewMarks(int reviewMarks) {
        this.reviewMarks = reviewMarks;
    }

    public int getReviewSpecificFeedback() {
        return reviewSpecificFeedback;
    }

    public void setReviewSpecificFeedback(int reviewSpecificFeedback) {
        this.reviewSpecificFeedback = reviewSpecificFeedback;
    }

    public int getReviewGeneralFeedback() {
        return reviewGeneralFeedback;
    }

    public void setReviewGeneralFeedback(int reviewGeneralFeedback) {
        this.reviewGeneralFeedback = reviewGeneralFeedback;
    }

    public int getReviewRightAnswer() {
        return reviewRightAnswer;
    }

    public void setReviewRightAnswer(int reviewRightAnswer) {
        this.reviewRightAnswer = reviewRightAnswer;
    }

    public int getReviewOverallFeedback() {
        return reviewOverallFeedback;
    }

    public void setReviewOverallFeedback(int reviewOverallFeedback) {
        this.reviewOverallFeedback = reviewOverallFeedback;
    }

    public int getQuestionsPerPage() {
        return questionsPerPage;
    }

    public void setQuestionsPerPage(int questionsPerPage) {
        this.questionsPerPage = questionsPerPage;
    }

    public String getNavMethod() {
        return navMethod;
    }

    public void setNavMethod(String navMethod) {
        this.navMethod = navMethod;
    }

    public int getShuffleAnswers() {
        return shuffleAnswers;
    }

    public void setShuffleAnswers(int shuffleAnswers) {
        this.shuffleAnswers = shuffleAnswers;
    }

    public double getSumGrades() {
        return sumGrades;
    }

    public void setSumGrades(double sumGrades) {
        this.sumGrades = sumGrades;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(long timeModified) {
        this.timeModified = timeModified;
    }

    public Quiz getQuizData(int quizId) throws Exception {
        String query = "SELECT * FROM mdl_quiz WHERE id=" + quizId;
        ResultSet resultSet = DBHandler.getData(DBConnectionPool.getConnectionToDB(), query);

        Quiz quiz = new Quiz();

        if (resultSet.next()) {
            quiz.setId(Integer.parseInt(resultSet.getString(1)));
            quiz.setCourse(Integer.parseInt(resultSet.getString(2)));
            quiz.setName(resultSet.getString(3));
            quiz.setIntro(resultSet.getString(4));
            quiz.setIntroFormat(Integer.parseInt(resultSet.getString(5)));
            quiz.setTimeOpen(Long.parseLong(resultSet.getString(6)));
            quiz.setTimeClose(Long.parseLong(resultSet.getString(7)));
            quiz.setTimeLimit(Integer.parseInt(resultSet.getString(8)));
            quiz.setOverDueHandling(resultSet.getString(9));
            quiz.setGracePeriod(Integer.parseInt(resultSet.getString(10)));
            quiz.setPreferredBehaviour(resultSet.getString(11));
            quiz.setCanReDoQuestions(Integer.parseInt(resultSet.getString(12)));
            quiz.setAttempts(Integer.parseInt(resultSet.getString(13)));
            quiz.setAttemptOnLast(Integer.parseInt(resultSet.getString(14)));
            quiz.setGradeMethod(Integer.parseInt(resultSet.getString(15)));
            quiz.setDecimalPoints(Integer.parseInt(resultSet.getString(16)));
            quiz.setQuestionDecimalPoints(Integer.parseInt(resultSet.getString(17)));
            quiz.setReviewAttempt(Integer.parseInt(resultSet.getString(18)));
            quiz.setReviewCorrectness(Integer.parseInt(resultSet.getString(19)));
            quiz.setReviewMarks(Integer.parseInt(resultSet.getString(20)));
            quiz.setReviewSpecificFeedback(Integer.parseInt(resultSet.getString(21)));
            quiz.setReviewGeneralFeedback(Integer.parseInt(resultSet.getString(22)));
            quiz.setReviewRightAnswer(Integer.parseInt(resultSet.getString(23)));
            quiz.setReviewOverallFeedback(Integer.parseInt(resultSet.getString(24)));
            quiz.setQuestionsPerPage(Integer.parseInt(resultSet.getString(25)));
            quiz.setNavMethod(resultSet.getString(26));
            quiz.setShuffleAnswers(Integer.parseInt(resultSet.getString(27)));
            quiz.setSumGrades(Double.parseDouble(resultSet.getString(28)));
            quiz.setGrade(Double.parseDouble(resultSet.getString(29)));
            quiz.setTimeCreated(Long.parseLong(resultSet.getString(30)));
            quiz.setTimeModified(Long.parseLong(resultSet.getString(31)));
        }

        return quiz;
    }
}
