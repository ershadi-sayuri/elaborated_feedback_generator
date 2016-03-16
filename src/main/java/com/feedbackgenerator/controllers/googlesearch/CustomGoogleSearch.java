package com.feedbackgenerator.controllers.googlesearch;

import com.feedbackgenerator.models.GoogleResults;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Ershadi Sayuri on 3/10/2016.
 */
public class CustomGoogleSearch {
    public void googleSearch(String query) throws IOException {

        String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&start=4&q=";
        String charset = "UTF-8";

        URL url = new URL(address + URLEncoder.encode(query, charset));
        Reader reader = new InputStreamReader(url.openStream(), charset);
        GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

        int total = results.getResponseData().getResults().size();
        System.out.println("total: " + total);

        // Show title and URL of each results
        for (int i = 0; i <= total - 1; i++) {
            System.out.println(results.getResponseData().getResults().get(i).getUrl() );
            System.out.println(results.getResponseData().getResults().get(i).getTitle().replace("<b>","").replace("</b>","")+ "\n");
        }
    }
}
