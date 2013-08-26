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
            <form action="${pageContext.request.contextPath}/ListViewer/find" method="POST">
                <table>
                    <tr>
                        <td colspan="2">Find the student/s</td>
                    </tr>
                    <tr>
                        <td>Input name:</td>
                        <td><label>
                            <input type="text" name="name"/>
                        </label></td>
                    </tr>
                    <tr>
                        <td>Input surname:</td>
                        <td><label>
                            <input type="text" name="surname"/>
                        </label></td>
                    </tr>
                    <tr>
                        <td>Input university:</td>
                        <td><label>
                            <input type="text" name="university"/>
                        </label></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input class="button success" type="submit" name="find" value="Find"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div>${messageNotFound}</div>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>

</html>