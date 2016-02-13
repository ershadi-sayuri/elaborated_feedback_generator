package feedbackgeneratortest.dbconnectiontest;

import com.mysql.jdbc.Connection;
import feedbackgenerator.dbconnection.DataSource;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 2/10/2016.
 */
public class DataSourceTest {

    @Test
    public void testGetConnection() throws Exception {
        Connection connection = DataSource.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void testSetConnection() throws Exception {
        DataSource.returnConnection(DataSource.getConnection());
    }
}