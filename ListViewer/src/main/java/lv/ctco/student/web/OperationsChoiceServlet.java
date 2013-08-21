package lv.ctco.student.web;

import lv.ctco.student.ListViewer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="operation choice",urlPatterns = "/ListViewer/indexChoiceOfOperation")
public class OperationsChoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ListViewer().start();
        String choice = req.getParameter("operationChoice");
        resp.sendRedirect(choice.toLowerCase()+".jsp");
    }
}
