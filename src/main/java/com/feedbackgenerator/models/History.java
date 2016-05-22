package com.feedbackgenerator.models;

import java.sql.*;

/**
 * Created by Ershadi Sayuri on 4/17/2016.
 */
public class History {
    public long getTopicViewingDuration(String topic) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:./History");
        Statement stat = conn.createStatement();

        String[] topicArea = topic.split(",");

        ResultSet topicTimeRS = stat.executeQuery("select SUM(visit_duration) from  visits WHERE url IN (SELECT id " +
                "FROM urls WHERE title LIKE '%" + topicArea[0] + "%' OR url LIKE '%" + topicArea[0] + "%')");

        long topicTime = 0;
        if (topicTimeRS.getString("SUM(visit_duration)") != null) {
            topicTime = Long.parseLong(topicTimeRS.getString("SUM(visit_duration)"));
        }

        return topicTime;
    }

    public long getTotalBrowsingDuration() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:./History");
        Statement stat = conn.createStatement();

        ResultSet totalTimeRS = stat.executeQuery("select SUM(visit_duration) from  visits");

        long totalTime = Long.parseLong(totalTimeRS.getString("SUM(visit_duration)"));

        return totalTime;
    }
}
