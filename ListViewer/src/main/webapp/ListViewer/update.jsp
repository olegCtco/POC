<%@ page import="lv.ctco.student.web.FindByIdServlet" %>
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
            <input class="button" type="button" value="Update"
                   onclick="location.href='http://localhost:8080/ListViewer/update.jsp'">
            <input class="button" type="button" value="Home"
                   onclick="location.href='http://localhost:8080/ListViewer/index.jsp'">
        </td>
    </tr>
    <tr>
        <td align="center">
            <div class="large-centered">
                <form action="/ListViewer/update" method="POST">
                    <table class="pricing-table">
                        <tr>
                            <td colspan="2">Update student</td>
                        </tr>
                        <tr>
                            <td>Input student id:</td>
                            <td><input type="text" name="id" value="${id}"/></td>
                            <td>
                                <div style="color: red">${invalidId}</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input class="button success" type="button"
                                                   onclick="<%new FindByIdServlet().getStudentByID(request,response);%>"
                                                   value="Find"></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div style="color: green">${validId}</div>
                            </td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="name" value="${name}"/></td>
                            <td>
                                <div style="color: #4ac3ff">${invalidName}</div>
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
                    </table>
                </form>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
