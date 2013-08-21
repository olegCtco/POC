<%@ page import="lv.ctco.student.Student" %>
<%@ page import="lv.ctco.student.StudentsList" %>
<html>

<body>

<form action="/sort" method="POST">
    <table>
        <tr>
            <td colspan="2">Sort the student/s</td>
        </tr>
        <tr>
            <td>
                <input type="radio" name=sortChoice value="name"> Name
                <input type="radio" name="sortChoice" value="surname" checked> Surname
                <input type="radio" name="sortChoice" value="university"> University
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Sort"/>
            </td>
        </tr>
    </table>
    <input type="button" value="Go To Menu" onclick="location.href='http://localhost:8080/ListViewer'">
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>University</th>
        </tr>
        <% for (Student student : StudentsList.getTmpList()) {%>
        <tr>
            <td><%= student.getName()%>
            </td>
            <td><%= student.getSurname()%>
            </td>
            <td><%= student.getUniversity()%>
            </td>
        </tr>
        <%}%>
    </table>
</form>

</body>

</html>