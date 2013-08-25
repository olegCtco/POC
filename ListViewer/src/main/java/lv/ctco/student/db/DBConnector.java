package lv.ctco.student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector implements IDBConnector {

    private static Statement statement;
    private Connection connection;

    public static Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean initDBSuccess() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            return true;
        } catch (SQLException sqlException) {
            return false;
        }
    }

    @Override
    public boolean closeDBConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            connection.close();
            return true;
        } catch (SQLException sqlException) {
            return false;
        }
    }
}
