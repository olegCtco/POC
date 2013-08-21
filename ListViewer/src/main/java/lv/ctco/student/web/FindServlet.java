package lv.ctco.student.web;

import lv.ctco.student.ListViewer;
import lv.ctco.student.Student;
import lv.ctco.student.operations.Find;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.ListView;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "find",urlPatterns = "/find")
public class FindServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String university = req.getParameter("university");
            List<String> studentValues = Arrays.asList(new String[]{name, surname, university});
            ArrayList<String> findByValues = new ArrayList<String>(studentValues);
            List<Student> foundedStudents = new ListViewer().find(findByValues);
            int size = foundedStudents.size();
            if (size == 0) {
                resp.sendRedirect("notFound.jsp");
            } else {
                resp.sendRedirect("findSuccess.jsp");
            }
        }catch(NullPointerException ex) {
            resp.sendRedirect("ListViewer/error.jsp");
        }
    }
}
