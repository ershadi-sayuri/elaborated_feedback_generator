package com.feedbackgenerator.models;

import java.util.List;

/**
 * Created by Ershadi Sayuri on 3/10/2016.
 */
public class ResponseData {
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Results[" + results + "]";
    }
}
