package lv.ctco.student.web;

import lv.ctco.student.ListViewer;
import lv.ctco.student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: butross
 * Date: 8/22/13
 * Time: 9:13 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "update", urlPatterns = "/ListViewer/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student student = new ListViewer().getStudentById(id);
        if (!student.equals(null)) {
            String foundedName = student.getName();
            String foundedSurname = student.getSurname();
            String foundedUniversity = student.getUniversity();
            req.setAttribute("id", id);
            req.setAttribute("name", foundedName);
            req.setAttribute("surname", foundedSurname);
            req.setAttribute("university", foundedUniversity);
        }
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
