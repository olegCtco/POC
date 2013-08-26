package lv.ctco.student.db;

import lv.ctco.student.Student;
import lv.ctco.student.StudentsList;
import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class DBService {
    private static final String DRIVER_NAME = "org.h2.Driver";
    private static final String URL = "jdbc:" + "h2:" + "./db/StudentDB";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private GenericObjectPool<Connection> pool;
    private final PoolableObjectFactory<Connection> connectionFactory = new BasePoolableObjectFactory<Connection>() {
        @Override
        public Connection makeObject() throws Exception {
            System.out.println("Create new connection.....");
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void destroyObject(Connection connection) throws Exception {
            connection.close();
        }

    };

    public void init() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        GenericObjectPool.Config config = new GenericObjectPool.Config();
        config.maxActive = 5;
        config.maxWait = 5;
        config.whenExhaustedAction = GenericObjectPool.WHEN_EXHAUSTED_FAIL;
        pool = new GenericObjectPool<>(connectionFactory, config);
        try {
            createTables();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addFromTableToList();
    }

    private Connection getConnection() throws Exception {
        return pool.borrowObject();
    }

    void returnConnectionToPool(Connection conn) {
        try {
            if (conn != null) pool.returnObject(conn);
        } catch (Exception ignored) {
        }
    }

    void closeStatement(Statement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException ignore) {
        }
    }

    void createTables() throws IOException {
        Statement stmt = null;
        Connection conn = null;
        List<String> sqlQueries = Utils.parseToSql("sql\\sqlCreateTable.sql");
//        List<String> sqlQueries = Utils.parseToSql("sql/sqlCreateTable.sql");
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            for (String query : sqlQueries) {
                stmt.executeUpdate(query);
            }
            sqlQueries.clear();
            sqlQueries = Utils.parseToSql("sql\\sqlInsert.sql");
//            sqlQueries = Utils.parseToSql("sql/sqlInsert.sql");
            for (String query : sqlQueries) {
                stmt.executeUpdate(query);
            }
        } catch (SQLException ignored) {
            System.out.println("ignore creation");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            returnConnectionToPool(conn);
            closeStatement(stmt);
        }
    }

    void addFromTableToList() {
        Statement stmt = null;
        Connection conn = null;
        List<Student> studentList = StudentsList.getStudentList();
        ResultSet resultSet;
        if (studentList.isEmpty()) {
            try {
                conn = getConnection();
                stmt = conn.createStatement();
                resultSet = stmt.executeQuery("SELECT * FROM STUDENTS;");
                Student student;
                int id;
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
                resultSet = stmt.executeQuery("SELECT AUTOINC.CURRVAL FROM DUAL;");
                resultSet.next();
                int idFromSequence = resultSet.getInt(1);
                StudentsList.setId(idFromSequence);

            } catch (SQLException ignored) {
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                returnConnectionToPool(conn);
                closeStatement(stmt);
            }
        }
    }

    public boolean insert(String name, String surname, String university) {
        Statement stmt = null;
        Connection conn = null;
        boolean isNotException = true;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO STUDENTS (FNAME, SNAME, UNIVERSITY) VALUES ('" + name + "', '" + surname + "', '" + university + "');");
        } catch (Exception e) {
            isNotException = false;
            throw new RuntimeException(e);
        } finally {
            returnConnectionToPool(conn);
            closeStatement(stmt);
        }
        return isNotException;
    }

    public void update(int index, String name, String surname, String university) {
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "UPDATE STUDENTS SET FNAME='" + name + "', SNAME='" + surname + "', UNIVERSITY='" + university +
                            "'WHERE ID=" + index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            returnConnectionToPool(conn);
            closeStatement(stmt);
        }
    }

    public boolean delete(int index) {
        Statement stmt = null;
        Connection conn = null;
        boolean isNotException = true;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM STUDENTS WHERE ID = " + index);
        } catch (Exception e) {
            isNotException = false;
            throw new RuntimeException(e);
        } finally {
            returnConnectionToPool(conn);
            closeStatement(stmt);
        }
        return isNotException;
    }
}