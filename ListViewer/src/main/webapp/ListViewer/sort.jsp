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

            <form action="/ListViewer/sort" method="POST">
                <table>
                    <tr>
                        <td colspan="2">Sort the student/s</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="sortChoice" value="name" checked> Name
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
            </form>
        </td>
    </tr>
</table>

</body>

</html>