<%@ page import="lv.ctco.student.Student" %>
<%@ page import="lv.ctco.student.StudentsList" %>
<html>

<body>

<table border="1" width=100%>
    <tr>
        <th>Index</th>
        <th>Name</th>
        <th>Surname</th>
        <th>University</th>
    </tr>
    <% try {
        for (int i = 0, x = 1; i < StudentsList.getStudentList().size(); i++) {
            Student student = StudentsList.getStudentList().get(i);
    %>
    <tr>
        <td><%= x++%>
        </td>
        <td><%= student.getName()%>
        </td>
        <td><%= student.getSurname()%>
        </td>
        <td><%= student.getUniversity()%>
        </td>
    </tr>
    <%
            }
        }catch (NullPointerException ex){
            response.sendRedirect("error.jsp");
        }
    %>
</table>
<input type="button" value="Go To Menu" onclick="location.href='http://localhost:8080/ListViewer'">
</body>

</html>