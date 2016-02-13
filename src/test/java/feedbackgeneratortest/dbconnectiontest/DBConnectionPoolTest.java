package feedbackgeneratortest.dbconnectiontest;

import feedbackgenerator.dbconnection.DBConnectionPool;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Ershadi Sayuri on 2/10/2016.
 */
public class DBConnectionPoolTest {

    @Test
    public void testGetConnectionFromPool() {
        DBConnectionPool dbConnectionPool = null;
        dbConnectionPool = new DBConnectionPool();
        assertNotNull(dbConnectionPool.getConnectionFromPool());
    }

    @Test
    public void testReturnConnectionToPool() {
        DBConnectionPool dbConnectionPool = null;
        dbConnectionPool = new DBConnectionPool();
        dbConnectionPool.returnConnectionToPool(dbConnectionPool.getConnectionFromPool());
    }
}