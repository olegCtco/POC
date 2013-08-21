<html>

<body>

<form action="/sort" method="POST">
    <table>
        <tr>
            <td colspan="2">Sort the student/s</td>
        </tr>
        <tr>
            <td>
                <input type="radio" name="sortChoice" value="name"> Name
                <input type="radio" name="sortChoice" value="surname" checked> Surname
                <input type="radio" name="sortChoice" value="university"> University
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Sort"/>
            </td>
        </tr>
    </table>
    <input type="button" value="Go To Menu" onclick="location.href='http://localhost:8080/ListViewer'">
</form>

</body>

</html>