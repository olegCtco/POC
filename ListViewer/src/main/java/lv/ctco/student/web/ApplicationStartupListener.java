package lv.ctco.student.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationStartupListener implements ServletContextListener {
    private ApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = new ApplicationContext();
        context.init();
        System.out.println("STUDENTS Web Application started....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context.close();
        System.out.println("STUDENTS Web Application stopped ....");
    }
}