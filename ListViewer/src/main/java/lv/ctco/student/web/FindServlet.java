package lv.ctco.student.web;

import lv.ctco.student.ListViewer;
import lv.ctco.student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "find", urlPatterns = "/ListViewer/find")
public class FindServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String university = req.getParameter("university");
            List<String> studentValues = Arrays.asList(name, surname, university);
            ArrayList<String> findByValues = new ArrayList<>(studentValues);
            List<Student> foundedStudents = new ListViewer().find(findByValues);
            int size = foundedStudents.size();
            if (size == 0) {
                req.setAttribute("messageNotFound", "Student by this parameters not found");
            } else {
                resp.sendRedirect("findSuccess.jsp");
            }
            req.getRequestDispatcher("find.jsp").forward(req, resp);
        } catch (NullPointerException ex) {
            resp.sendRedirect("error.jsp");
        }
    }
}