package lv.ctco.student.db;

/**
 * Created with IntelliJ IDEA.
 * User: butross
 * Date: 8/23/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IDBConnector {
    String DRIVER_NAME = "org.h2.Driver";
    String URL = "jdbc:" + "h2:" + "./db/StudentDB";
    String USER = "sa";
    String PASSWORD = "";

    public boolean initDBSuccess();
}
