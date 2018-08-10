<%--
  Created by IntelliJ IDEA.
  User: faLek
  Date: 22.07.2018
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add New User</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-user-style.css" />
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>User CRUD Application</h2>
        </div>
    </div>

    <div id="container">
        <h2>Add User</h2>

        <form:form action="add" modelAttribute="user" method="post">

            <form:hidden path="id" />

            <table>
                <tr>
                    <td><label>First name: </label></td>
                    <td><form:input path="firstName"></form:input></td>
                </tr>
                <tr>
                    <td><label>Last name: </label></td>
                    <td><form:input path="lastName"></form:input></td>
                </tr>
                <tr>
                    <td><label>Email: </label></td>
                    <td><form:input path="email"></form:input></td>
                </tr>
                <tr>
                    <td><label>Date (dd/MM/yyyy): </label></td>
                    <td><form:input type="date" path="date"></form:input></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save" /></td>
                </tr>
            </table>
        </form:form>



        <p>
            <a href="${pageContext.request.contextPath}/user/list"> Back to list </a>
        </p>

    </div>
</body>
</html>
