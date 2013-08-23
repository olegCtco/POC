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
        <td colspan="4">
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
        <td width=20%></td>
        <td rowspan="2">
            <table>
                <tr>
                    <th>Index</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>University</th>
                </tr>
                <% for (Student student : StudentsList.getStudentList()) {
                %>
                <tr>
                    <td><%= student.getId()%>
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
        <td align="center">
            <div class="large-centered">
                <form action="/ListViewer/findById" method="POST">
                    <table class="pricing-table">
                        <tr>
                            <td colspan="2">Update student</td>
                        </tr>
                        <tr>
                            <td>Input student id:</td>
                            <td><input type="text" name="id" value="${id}"/></td>
                            <td>
                                <div style="color: red" name="invalidId">${invalidId}</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input class="button success" type="submit" name="submit" value="Find">
                            </td>
                        </tr>
                    </table>
                </form>
                <form action="/ListViewer/update" method="POST">
                    <table>
                        <tr>
                            <td colspan="2">
                                <%--<input name="idHidden" type="hidden" values=${id}/>--%>
                                <input type="hidden" name="idHidden" value="${idHidden}"/></td>
                            <div style="color: green">${validId}</div>
                            </td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="name" value="${name}"/></td>
                            <td>
                                <div style="color: red">${invalidName}</div>
                            </td>
                        </tr>
                        <tr>
                            <td>Surname:</td>
                            <td><input type="text" name="surname" value="${surname}"/></td>
                            <td>
                                <div style="color: red">${invalidSurname}</div>
                            </td>
                        </tr>
                        <tr>
                            <td>University:</td>
                            <td><input type="text" name="university" value="${university}"/></td>
                            <td>
                                <div style="color: red">${invalidUniversity}</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input class="button success" type="submit" name="submit" value="Update">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div name="message" style="color: green">${message}</div>
                                <div name="errorMessage" style="color: red">${errorMessage}</div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </td>
        <td width="20%"></td>
    </tr>
</table>
</body>
</html>
