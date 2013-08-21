package lv.ctco.student.web;

import lv.ctco.student.operations.Sort;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name="sort",urlPatterns = "/sort")
public class SortServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String sortChoice = req.getParameter("sortChoice");
            new Sort().doOperation(new ArrayList<String>(Arrays.asList(new String[]{sortChoice})));
            resp.sendRedirect("sortSuccess.jsp");
        }catch(NullPointerException ex) {
            resp.sendRedirect("ListViewer/error.jsp");
        }
    }
}
