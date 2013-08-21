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
</form>

</body>

</html>