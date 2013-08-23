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
            <input class="button" type="button" value="Update"
                   onclick="location.href='http://localhost:8080/ListViewer/update.jsp'">
            <input class="button" type="button" value="Home"
                   onclick="location.href='http://localhost:8080/ListViewer/index.jsp'">
        </td>
    </tr>
    <tr>
        <td align="center">
            <form action="/ListViewer/find" method="POST">
                <table>
                    <tr>
                        <td colspan="2">Find the student/s</td>
                    </tr>
                    <tr>
                        <td>Input name:</td>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Input surname:</td>
                        <td><input type="text" name="surname"/></td>
                    </tr>
                    <tr>
                        <td>Input university:</td>
                        <td><input type="text" name="university"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" class="button success" name="find" value="Find"></td>
                    </tr>
                </table>
                <table>
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
        </td>
    </tr>
</table>
</body>

</html>