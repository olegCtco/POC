<%@ page import="lv.ctco.student.Student" %>
<%@ page import="lv.ctco.student.StudentsList" %>
<html>

<body>


<form action="/find" method="POST">
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
            <td colspan="2"><input type="submit" name="find" value="Find"></td>
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