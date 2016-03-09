package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */

/**
 * Uses Felder Silverman Learning Style Model and more other user data which is used to classify users based on
 * knowledge, environment, personal data and interaction parameters
 */
public class User {
    private String userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String country;
    private String language;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public void getUserData(){

    }
}
