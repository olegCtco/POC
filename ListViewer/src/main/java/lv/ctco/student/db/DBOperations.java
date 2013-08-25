package lv.ctco.student.db;

import lv.ctco.student.Student;
import lv.ctco.student.StudentsList;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBOperations {
    public void createTables() throws IOException {
//        /home/joen/GitHub/POC/ListViewer/sql/sqlCreateTable.sql
//        List<String> sqlQueries = Utils.parseToSql("sql\\sqlCreateTable.sql");
        List<String> sqlQueries = Utils.parseToSql("sql/sqlCreateTable.sql");
        try {
            for (String query : sqlQueries) {
                DBConnector.getStatement().executeUpdate(query);
            }
            sqlQueries.clear();
//            sqlQueries = Utils.parseToSql("sql\\sqlInsert.sql");
            sqlQueries = Utils.parseToSql("sql/sqlInsert.sql");
            for (String query : sqlQueries) {
                DBConnector.getStatement().executeUpdate(query);
            }
        } catch (SQLException ignored) {
            System.out.println("ignore creation");
        }
    }

    public void addFromTableToList() {
        List<Student> studentList = StudentsList.getStudentList();
        ResultSet resultSet;
//        try {
//            resultSet = DBConnector.getStatement().executeQuery("SELECT COUNT(*) FROM STUDENTS;");
//        } catch (SQLException e) {
//        }
//        while(resultSet.next()){
//
//        }
        System.out.println("StudentsList is empty " + studentList.isEmpty());
        if (studentList.isEmpty()) {
            try {
                resultSet = DBConnector.getStatement().executeQuery("SELECT * FROM STUDENTS;");
                Student student;
                int id = 0;
                String name;
                String surname;
                String university;
                while (resultSet.next()) {
                    id = resultSet.getInt("ID");
                    name = resultSet.getString("FNAME");
                    surname = resultSet.getString("SNAME");
                    university = resultSet.getString("UNIVERSITY");
                    System.out.println(id + " " + name + " " + surname + " " + university);
                    student = new Student(name, surname, university, id);
                    studentList.add(student);
                }
                StudentsList.setId(id);

            } catch (SQLException e) {
            }
        }

    }

    public void delete(int index) throws SQLException {
        DBConnector.getStatement().executeUpdate("DELETE FROM STUDENTS WHERE ID = " + index);
    }

    public void insert(String name, String surname, String university) throws SQLException {
        DBConnector.getStatement().executeUpdate("INSERT INTO STUDENTS (FNAME, SNAME, UNIVERSITY) VALUES ('" + name + "', '" + surname + "', '" + university + "');");
    }

    public void update(int index, String name, String surname, String university) throws SQLException {
        DBConnector.getStatement().executeUpdate(
                "UPDATE STUDENTS SET FNAME='" + name + "', SNAME='" + surname + "', UNIVERSITY='" + university +
                        "'WHERE ID=" + index);
    }
}
