<html>

<body>

<form action="/add" method="POST">
    <table>
        <tr>
            <td colspan="2">Add the student</td>
        </tr>
        <tr>
            <td>Input name:</td>
            <td><input type="text" value="${name}" name="name"  /></td>  <td><div name="emptyName">${emptyName}</div></td>
        </tr>
        <tr>
            <td>Input surname:</td>
            <td><input type="text" name="surname" value=${surname} ></td>  <td><div name="emptySurname">${emptySurname}</div></td>
        </tr>
        <tr>
            <td>Input university:</td>
            <td><input type="text" name="university" value="${university}" /></td>  <td><div name="emptyUniversity">${emptyUniversity}</div></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="submit" value="Add" onclick="isEmpty()"></td>
        </tr>
    </table>
    <input type="button" value="Go To Menu" onclick="location.href='http://localhost:8080/ListViewer'">
    <div name="message">${message}</div>
</form>

</body>

</html>