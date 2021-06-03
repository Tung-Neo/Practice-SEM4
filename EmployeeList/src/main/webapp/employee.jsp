<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/3/2021
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<div id="container">
    <h3>Add Employee</h3>

    <form action="EmployeeControllerServlet" method="GET">

        <input type="hidden" name="command" value="ADD" />

        <table>
            <tbody>
            <tr>
                <td><label>Full Name:</label></td>
                <td><input type="text" name="FullName" /></td>
            </tr>

            <tr>
                <td><label>Birthday:</label></td>
                <td><input type="text" name="Birthday" /></td>
            </tr>

            <tr>
                <td><label>Address:</label></td>
                <td><input type="text" name="Address" /></td>
            </tr>

            <tr>
                <td><label>Position:</label></td>
                <td><input type="text" name="Position" /></td>
            </tr>

            <tr>
                <td><label>Department:</label></td>
                <td><input type="text" name="Department" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>
    </form>

    <p>
        <a href="employee.jsp">Reset</a>
    </p>
</div>
</body>
</html>
