package comtest.feedbackgeneratortest.dbhandlertest;

import com.feedbackgenerator.dbconnection.DBConnectionPool;
import com.feedbackgenerator.dbconnection.DataSource;
import com.feedbackgenerator.dbhandler.DBHandler;
import org.junit.Test;

import java.sql.ResultSet;

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