package feedbackgeneratortest.dbhandlertest;

import feedbackgenerator.dbconnection.DBConnectionPool;
import feedbackgenerator.dbconnection.DataSource;
import feedbackgenerator.dbhandler.DBHandler;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 2/11/2016.
 */
public class DBHandlerTest {

    @Test
    public void testSetData() throws Exception {

    }

    @Test
    public void testGetData() throws Exception {
        DBHandler dbHandler = new DBHandler();
        DataSource dataSource = new DataSource();
        ResultSet resultSet = dbHandler.getData(DBConnectionPool.getConnectionToDB(), "SELECT * FROM mdl_question");
        while (resultSet.next()){
            System.out.println(resultSet.getString(4));
        }
    }
}