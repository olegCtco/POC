package lv.ctco.student.web;

import lv.ctco.student.ListViewer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "remove", urlPatterns = "/remove")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String indexToDeleteElement = req.getParameter("deletedElementIndex");
            int index = Integer.parseInt(indexToDeleteElement);
            boolean success = (boolean) new ListViewer().remove(index);
            if (success) {
                resp.sendRedirect("removeSuccess.jsp");
            } else {
                resp.sendRedirect("removeFail.jsp");
            }
        } catch (NumberFormatException e) {

        } catch (NullPointerException ex) {
            resp.sendRedirect("ListViewer/error.jsp");
        }
    }
}
