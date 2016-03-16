package com.feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 3/10/2016.
 */
public class Result {
    private String url;
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Result[url:" + url + ",title:" + title + "]";
    }
}
