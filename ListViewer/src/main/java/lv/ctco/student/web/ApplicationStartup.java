package lv.ctco.student.web;


import lv.ctco.student.db.DBConnector;
import lv.ctco.student.db.DBOperations;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class ApplicationStartup implements ServletContextListener {
    DBOperations dbOperations;
    DBConnector dbConnector;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        dbConnector = new DBConnector();
        dbConnector.initDBSuccess();
        dbOperations = new DBOperations();
        try {
            dbOperations.createTables();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dbOperations.addFromTableToList();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        dbConnector.closeDBConnection();
    }
}