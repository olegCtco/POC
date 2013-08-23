package lv.ctco.student.db;

import java.sql.SQLException;

public class DBOperations {
    public void delete(int index) throws SQLException {
        DBConnector.getStatement().executeUpdate("DELETE FROM STUDENTS WHERE ID = " + index + ";");
    }
}
