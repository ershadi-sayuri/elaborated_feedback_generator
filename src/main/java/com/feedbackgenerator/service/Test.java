package com.feedbackgenerator.service;

import com.feedbackgenerator.models.InputData;

import javax.ws.rs.core.Response;

/**
 * Created by Ershadi Sayuri on 5/29/2016.
 */
public class Test {
    public static void main(String[] args) {
        Response response = new RESTController().generateFeedback(new InputData(27, 2));
        System.out.println(response.getEntity().toString());
    }
}
