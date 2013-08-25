package lv.ctco.student.web;

import lv.ctco.student.ListViewer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "remove", urlPatterns = "/ListViewer/remove")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        boolean success = false;
        try {
            success = (boolean) new ListViewer().remove(id);
            System.out.println("Success "+success);
            if (success) {
                req.setAttribute("validId", "Student was successfully removed from the list");
            } else {
                req.setAttribute("invalidId", "Invalid id: empty, not a number or out of bound");
                req.setAttribute("id", id);
            }
            req.getRequestDispatcher("remove.jsp").forward(req, resp);
        } catch (NullPointerException ex) {
            resp.sendRedirect("error.jsp");
        }
    }
}
