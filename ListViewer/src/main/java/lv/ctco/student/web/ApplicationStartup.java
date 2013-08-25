package lv.ctco.student.web;

import lv.ctco.student.db.DBOperations;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

//@WebListener
public class ApplicationStartup implements ServletContextListener {
    DBOperations dbOperations = new DBOperations();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        dbOperations = new DBOperations();
        try {
            dbOperations.createTables();
        } catch (IOException e) {
            System.out.println("Exception on creation");
        }
        dbOperations.addFromTableToList();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}