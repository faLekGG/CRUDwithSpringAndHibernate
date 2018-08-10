<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User CRUD Application</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>User CRUD Application</h2>
            </div>
        </div>

        <div id="container">
            <div id="content">

                <input type="button" value="Add Customer"
                        onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button"
                />

                <!--  add a search box -->
                <form:form action="search" method="POST">
                    Search user: <input type="text" name="theSearchName" />

                    <input type="submit" value="Search" class="add-button" />
                </form:form>

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Date</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach var="tempUser" items="${listOfUsers}">

                        <c:url var="updateLink" value="showFormForUpdate">
                            <c:param name="userId" value="${tempUser.id}"/>
                        </c:url>

                        <c:url var="deleteLink" value="delete">
                            <c:param name="userId" value="${tempUser.id}"/>
                        </c:url>

                        <tr>
                            <td>${tempUser.firstName}</td>
                            <td>${tempUser.lastName}</td>
                            <td>${tempUser.email}</td>
                            <td>${tempUser.date}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}" onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
