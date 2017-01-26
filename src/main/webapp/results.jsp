<%@ page import="edu.matc.entity.User" %>
<%@include file="head.jsp"%>

<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Age</th>
        </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userid}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.birthDate}</td>
            <td>${user.calculateAge()}</td>
        </tr>
    </c:forEach>
    </table>
</div>

</body>
</html>
