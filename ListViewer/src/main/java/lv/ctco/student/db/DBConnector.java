package lv.ctco.student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
