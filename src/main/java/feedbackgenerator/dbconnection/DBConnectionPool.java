package feedbackgenerator.dbconnection;

import com.mysql.jdbc.Connection;
import feedbackgenerator.properties.AccessProperties;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ershadi Sayuri on 2/10/2016.
 */
public class DBConnectionPool {
    List<Connection> availableConnections = new ArrayList<Connection>();

    /**
     * initialize the connection pool in the constructor
     */
    public DBConnectionPool() {
        try {
            initializeConnectionPool();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * initialize the connection pool and check the connection pool is full and if connection pool is empty then add
     * new connection
     *
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void initializeConnectionPool() throws IOException, SQLException, ClassNotFoundException {
        if (!checkIfConnectionPoolIsFull()) {
            availableConnections.add(createNewConnectionForPool());
        }
    }

    /**
     * @return boolean whether  the connection pool is filled or not
     * @throws IOException
     */
    private synchronized boolean checkIfConnectionPoolIsFull() throws IOException {
        final int MAX_POOL_SIZE = Integer.parseInt(AccessProperties.readPropertyValue("DATABASE_MAX_CONNECTIONS"));

        if (availableConnections.size() < MAX_POOL_SIZE) {
            return false;
        }

        return true;
    }

    /**
     * creating a new connection
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private Connection createNewConnectionForPool() throws IOException, SQLException, ClassNotFoundException {
        Class.forName(AccessProperties.readPropertyValue("DATABASE_DRIVER"));
        Connection connection = (Connection) DriverManager.getConnection(
                AccessProperties.readPropertyValue("DATABASE_URL"),
                AccessProperties.readPropertyValue("DATABASE_USER_NAME"),
                AccessProperties.readPropertyValue("DATABASE_PASSWORD"));
        return connection;
    }

    /**
     * get the connection from connection pool
     *
     * @return connection
     */
    public synchronized Connection getConnectionFromPool() {
        Connection connection = null;
        if (availableConnections.size() > 0) {
            connection = (Connection) availableConnections.get(0);
            availableConnections.remove(0);
        }
        return connection;
    }

    /**
     * return the connection to connection pool
     *
     * @param connection
     */
    public synchronized void returnConnectionToPool(Connection connection) {
        availableConnections.add(connection);
    }
}
