package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 3/10/2016.
 */
public class GoogleResults {
    private ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "ResponseData[" + responseData + "]";
    }
}
