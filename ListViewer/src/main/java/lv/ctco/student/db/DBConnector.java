package lv.ctco.student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: butross
 * Date: 8/23/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBConnector implements IDBConnector {

    private Statement statement;
    private Connection connection;

    public boolean initDBSuccess() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            return true;
        } catch (SQLException sqlException) {
            return false;
        }
    }
}
