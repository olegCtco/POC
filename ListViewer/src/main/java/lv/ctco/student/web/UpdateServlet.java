package lv.ctco.student.web;

import lv.ctco.student.ListViewer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update", urlPatterns = "/ListViewer/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idHidden = req.getParameter("idHidden");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String university = req.getParameter("university");
        boolean success = false;
        boolean isEmptyField = false;
        try {
            if (!idHidden.equals("")) {
                if (name.isEmpty()) {
                    req.setAttribute("invalidName", "Name is empty");
                    isEmptyField = true;
                }
                if (surname.isEmpty()) {
                    req.setAttribute("invalidSurname", "Surname is empty");
                    isEmptyField = true;
                }
                if (university.isEmpty()) {
                    req.setAttribute("invalidUniversity", "University is empty");
                    isEmptyField = true;
                }
                req.setAttribute("name", name);
                req.setAttribute("surname", surname);
                req.setAttribute("university", university);
                req.setAttribute("idHidden", idHidden);
                if (!isEmptyField) {
                    success = new ListViewer().update(idHidden, name, surname, university);
                } else {
                    req.setAttribute("errorMessage", "Student wasn't changed in list");
                }
                if (success) {
                    req.setAttribute("message", "Student was successfully changed");
                }
            } else {
                req.setAttribute("message", "Input student id first!");
            }
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        } catch (NullPointerException ex) {
            resp.sendRedirect("error.jsp");
        }
    }
}