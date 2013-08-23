package lv.ctco.student.db;

public interface IDBConnector {
    String DRIVER_NAME = "org.h2.Driver";
    String URL = "jdbc:" + "h2:" + "./db/StudentDB";
    String USER = "sa";
    String PASSWORD = "";

    public boolean initDBSuccess();
}
