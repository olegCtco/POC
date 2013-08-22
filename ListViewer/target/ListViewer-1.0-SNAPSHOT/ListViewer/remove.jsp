<%@ page import="lv.ctco.student.Student" %>
<%@ page import="lv.ctco.student.StudentsList" %>
<html>
<head>
    <link rel="stylesheet" href="css/foundation.css" type="text/css">
    <link rel="stylesheet" href="css/foundation.min.css" type="text/css">
</head>
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
            <form action="/remove" method="POST">
                <table>
                    <tr>
                        <td>
                            <table width=100%>
                                <tr>
                                    <td>
                                        Remove the student
                                    </td>
                                </tr>
                                <tr>
                                    <td>Input index to delete element</td>
                                    <td><input type="text" name="deletedElementIndex"></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input class="button success" type="submit" value="Delete"></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width=100%>
                                <tr>
                                    <th>Index</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>University</th>
                                </tr>
                                <% for (int i = 0, x = 1; i < StudentsList.getStudentList().size(); i++) {
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
                                <%}%>
                            </table>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>

</html>