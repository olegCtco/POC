<%@ page import="lv.ctco.student.Student" %>
<%@ page import="lv.ctco.student.StudentsList" %>
<html>
<link rel="stylesheet" href="css/foundation.css" type="text/css">
<link rel="stylesheet" href="css/foundation.min.css" type="text/css">
<body>
<table width=100%>
    <tr align="center">
        <td>
            <input class="button" type="button" value="View"
                   onclick="location.href='http://localhost:8080/ListViewer/view.jsp'">
            <input class="button" type="button" value="Add"
                   onclick="location.href='http://localhost:8080/ListViewer/add.jsp'">
            <input class="button" type="button" value="Find"
                   onclick="location.href='http://localhost:8080/ListViewer/find.jsp'">
            <input class="button" type="button" value="Sort"
                   onclick="location.href='http://localhost:8080/ListViewer/sort.jsp'">
            <input class="button" type="button" value="Remove"
                   onclick="location.href='http://localhost:8080/ListViewer/remove.jsp'">
            <input class="button" type="button" value="Home"
                   onclick="location.href='http://localhost:8080/ListViewer/index.jsp'">
        </td>
    </tr>
    <tr>
        <td align="center">
            <form action="/ListViewer/sort" method="POST">
                <table>
                    <tr>
                        <td colspan="2">Sort the student/s</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name=sortChoice value="name" checked="true"> Name
                            <input type="radio" name="sortChoice" value="surname"> Surname
                            <input type="radio" name="sortChoice" value="university"> University
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" class="button success" value="Sort"/>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <%--<th>Index</th>--%>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>University</th>
                    </tr>
                    <% for (Student student : StudentsList.getTmpList()) {
                    %>
                    <tr>
                        <%--<td><%= student.getId()%>--%>
                        <%--</td>--%>
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
        </td>
    </tr>
</table>
</body>

</html>