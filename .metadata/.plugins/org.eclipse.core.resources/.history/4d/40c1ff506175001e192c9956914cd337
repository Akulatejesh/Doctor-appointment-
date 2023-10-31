<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <!-- Include CSS and JavaScript resources here -->
</head>
<body>
    <h2>Login</h2>
    <form action="<c:url value='/login' />" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for "password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Login">
    </form>
    <c:if test="${param.error != null}">
        <div class="error-message">Invalid username or password</div>
    </c:if>
</body>
</html>
