<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Snowflake Home</title>
</head>
<body>

<h2>Snowflake Connected Successfully!</h2>

<h3>Version: ${version}</h3>

<h3>Employee List:</h3>
<ul>
    <c:forEach var="emp" items="${empList}">
        <li>${emp}</li>
    </c:forEach>
</ul>

<h3>Update Status: ${status}</h3>

</body>
</html>
