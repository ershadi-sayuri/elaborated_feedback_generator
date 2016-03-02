package feedbackgenerator.models;

import feedbackgenerator.dbconnection.DBConnectionPool;
import feedbackgenerator.dbconnection.DataSource;
import feedbackgenerator.dbhandler.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */
public class Question {
    private int id;
    private int category;
    private int parent;
    private String name; // question type
    private String questionText; // question description
    private String questionTextFormat;
    private String generalFeedback;
    private String generalFeedbackFormat;
    private double defaultMark;
    private double penalty; // penalty marks
    private String qType;
    private int length;
    private String stamp;
    private String version;
    private int hidden;
    private long timeCreated;
    private long timeModified;
    private int createdBy;
    private int modifiedBy;

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
    public int getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * @return
     */
    public int getParent() {
        return parent;
    }

    /**
     * @param parent
     */
    public void setParent(int parent) {
        this.parent = parent;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * @param questionText
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    /**
     * @return
     */
    public String getQuestionTextFormat() {
        return questionTextFormat;
    }

    /**
     * @param questionTextFormat
     */
    public void setQuestionTextFormat(String questionTextFormat) {
        this.questionTextFormat = questionTextFormat;
    }

    /**
     * @return
     */
    public String getGeneralFeedback() {
        return generalFeedback;
    }

    /**
     * @param generalFeedback
     */
    public void setGeneralFeedback(String generalFeedback) {
        this.generalFeedback = generalFeedback;
    }

    /**
     * @return
     */
    public String getGeneralFeedbackFormat() {
        return generalFeedbackFormat;
    }

    /**
     * @param generalFeedbackFormat
     */
    public void setGeneralFeedbackFormat(String generalFeedbackFormat) {
        this.generalFeedbackFormat = generalFeedbackFormat;
    }

    /**
     * @return
     */
    public double getDefaultMark() {
        return defaultMark;
    }

    /**
     * @param defaultMark
     */
    public void setDefaultMark(double defaultMark) {
        this.defaultMark = defaultMark;
    }

    /**
     * @return
     */
    public double getPenalty() {
        return penalty;
    }

    /**
     * @param penalty
     */
    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    /**
     * @return
     */
    public String getqType() {
        return qType;
    }

    /**
     * @param qType
     */
    public void setqType(String qType) {
        this.qType = qType;
    }

    /**
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return
     */
    public String getStamp() {
        return stamp;
    }

    /**
     * @param stamp
     */
    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    /**
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return
     */
    public int getHidden() {
        return hidden;
    }

    /**
     * @param hidden
     */
    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    /**
     * @return
     */
    public long getTimeCreated() {
        return timeCreated;
    }

    /**
     * @param timeCreated
     */
    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    /**
     * @return
     */
    public long getTimeModified() {
        return timeModified;
    }

    /**
     * @param timeModified
     */
    public void setTimeModified(long timeModified) {
        this.timeModified = timeModified;
    }

    /**
     * @return
     */
    public int getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return
     */
    public int getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy
     */
    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}
