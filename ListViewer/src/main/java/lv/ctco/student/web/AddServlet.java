package lv.ctco.student.web;

import lv.ctco.student.ListViewer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "add", urlPatterns = "/ListViewer/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String university = req.getParameter("university");
        boolean success = false;
        try {
            success = (boolean) new ListViewer().add(new ArrayList<String>(Arrays.asList(new String[]{name, surname, university})));
            if (success) {
                req.setAttribute("message", "Student was successfully added to the list");
            } else {
                if (name.isEmpty())
                    req.setAttribute("emptyName", "Name is empty");
                if (surname.isEmpty())
                    req.setAttribute("emptySurname", "Surname is empty");
                if (university.isEmpty())
                    req.setAttribute("emptyUniversity", "University is empty");
                req.setAttribute("name", name);
                req.setAttribute("surname", surname);
                req.setAttribute("university", university);
                req.setAttribute("message", "Student wasn't added to the list");
            }
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        } catch (NullPointerException ex) {
            resp.sendRedirect("error.jsp");
        }

    }
}
