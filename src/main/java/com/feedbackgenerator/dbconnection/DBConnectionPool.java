package com.feedbackgenerator.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ershadi Sayuri on 2/10/2016.
 */
public class DBConnectionPool {
    private static final String url = "jdbc:mysql://localhost/moodle_database";
    private static final String user = "root";
    private static final String password = "";

    private static Connection conn = null;
    private static DBConnectionPool dbconn = null;

    private DBConnectionPool() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
    }

    private static DBConnectionPool getDBConnection() throws ClassNotFoundException, SQLException {
        if (dbconn == null) {
            dbconn = new DBConnectionPool();
        }
        return dbconn;
    }

    public static Connection getConnectionToDB() throws ClassNotFoundException, SQLException {
        return getDBConnection().conn;
    }
}
