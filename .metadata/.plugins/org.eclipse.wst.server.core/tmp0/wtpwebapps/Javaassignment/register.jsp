<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="RegisterServlet" method="post">
        User ID: <input type="text" name="userId" required><br>
        Password: <input type="password" name="password" required><br>
        Initial Balance: <input type="text" name="initialBalance" required><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
