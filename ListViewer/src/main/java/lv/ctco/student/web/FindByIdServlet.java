package lv.ctco.student.web;

import lv.ctco.student.ListViewer;
import lv.ctco.student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "findById", urlPatterns = "/ListViewer/findById")
public class FindByIdServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student student = new ListViewer().getStudentById(id);
        if (student != null) {
            String foundedName = student.getName();
            String foundedSurname = student.getSurname();
            String foundedUniversity = student.getUniversity();
            req.setAttribute("id", id);
            req.setAttribute("idHidden", id);
            req.setAttribute("name", foundedName);
            req.setAttribute("surname", foundedSurname);
            req.setAttribute("university", foundedUniversity);
        } else {
            req.setAttribute("invalidId", "Student by this index not found!");
        }
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}