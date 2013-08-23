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
            <div class="large-centered">
                <form action="/ListViewer/add" method="POST">
                    <table class="pricing-table">
                        <tr>
                            <td colspan="2">Add the student</td>
                        </tr>
                        <tr>
                            <td>Input name:</td>
                            <td><input type="text" name="name" value="${name}"/></td>
                            <td>
                                <div style="color: red">${emptyName}</div>
                            </td>
                        </tr>
                        <tr>
                            <td>Input surname:</td>
                            <td><input type="text" name="surname" value="${surname}"/></td>
                            <td>
                                <div style="color: red">${emptySurname} </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Input university:</td>
                            <td><input type="text" name="university" value="${university}"/></td>
                            <td>
                                <div style="color: red">${emptyUniversity} </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input class="button success" type="submit" name="submit" value="Add"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </td>
    </tr>
</table>
</body>

</html>