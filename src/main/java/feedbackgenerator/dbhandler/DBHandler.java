package feedbackgenerator.dbhandler;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ershadi Sayuri on 2/11/2016.
 */
public class DBHandler {

    /**
     * @param connection
     * @param query
     * @return result
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static int setData(Connection connection, String query) throws SQLException, ClassNotFoundException {
        Statement stm = connection.createStatement();
        int result = stm.executeUpdate(query);
        return result;
    }

    /**
     *
     * @param connection
     * @param query
     * @return resultSet
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ResultSet getData(Connection connection, String query) throws SQLException, ClassNotFoundException {
        Statement stm = connection.createStatement();
        ResultSet resultSet = stm.executeQuery(query);
        return resultSet;
    }
}
