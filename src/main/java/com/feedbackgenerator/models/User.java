package com.feedbackgenerator.models;

import com.feedbackgenerator.dbconnection.DBConnectionPool;
import com.feedbackgenerator.dbhandler.DBHandler;

import java.sql.ResultSet;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */

public class User {
    private int userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String country;
    private String language;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public User getUserData(int userId) throws Exception {
        String query = "SELECT * FROM mdl_user WHERE id = " + userId;
        ResultSet resultSet = DBHandler.getData(DBConnectionPool.getConnectionToDB(), query);

        User user = new User();
        if (resultSet.next()) {
            user.setUserId(Integer.parseInt(resultSet.getString(1)));
            user.setUserName(resultSet.getString(8));
            user.setPassword(resultSet.getString(9));
            user.setFirstName(resultSet.getString(11));
            user.setLastName(resultSet.getString(12));
            user.setEmailAddress(resultSet.getString(13));
            user.setCountry(resultSet.getString(26));
            user.setLanguage(resultSet.getString(27));
        }
        return user;
    }
}
