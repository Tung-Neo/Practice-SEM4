<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/3/2021
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Employee List</h2>
    </div>
</div>


<div >


    <input type="button" value="Add Employee"
           onclick="window.location.href='employee.jsp'; return false;"
           class="add-employee-button"
    />

    <table>

        <tr style="border: solid 1px">
            <th>ID</th>
            <th>Full Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Position</th>
            <th>Department</th>
        </tr>

        <c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}">

            <tr>
                <td> ${tempEmployee.id} </td>
                <td> ${tempEmployee.fullname} </td>
                <td> ${tempEmployee.birthday} </td>
                <td> ${tempEmployee.address} </td>
                <td> ${tempEmployee.position} </td>
                <td> ${tempEmployee.department} </td>
            </tr>

        </c:forEach>

    </table>

</div>

</body>
</html>
