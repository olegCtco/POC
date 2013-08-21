<%@ page import="lv.ctco.student.Student" %>
<%@ page import="lv.ctco.student.StudentsList" %>
<html>

<body>
<form action="/remove" method="POST">
    <table>
        <tr>
            <td>
                <table width=100%>
                    <tr>
                        <td>Input index to delete element</td>
                        <td><input type="text" name="deletedElementIndex"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Delete"></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td><input type="button" value="Go To Menu" onclick="location.href='http://localhost:8080/ListViewer'"></td>
        </tr>
        <tr>
            <td>
                <table border="1" width=100%>
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
<p> Student delete failed
</body>

</html>