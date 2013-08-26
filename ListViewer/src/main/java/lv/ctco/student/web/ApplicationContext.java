package lv.ctco.student.web;

import lv.ctco.student.db.DBService;

public class ApplicationContext {
    private static ApplicationContext context;
    private DBService db;


    public static ApplicationContext getContext() {
        return context;
    }

    public void init() {
        context = this;
        db = new DBService();
        db.init();
    }

    public void close() {
        context = null;
        db = null;
    }

    public DBService getDBService() {
        return db;
    }
}