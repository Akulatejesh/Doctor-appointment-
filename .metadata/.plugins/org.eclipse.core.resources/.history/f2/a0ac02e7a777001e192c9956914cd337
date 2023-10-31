<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Login</title>
</head>
<body>
    <h2>Patient Login</h2>
    <form action="/patientlogin" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
     <c:if test="${not empty error}">
        <div style="color: red; font-weight: bold;">
            ${error}
        </div>
    </c:if>
</body>
</html>