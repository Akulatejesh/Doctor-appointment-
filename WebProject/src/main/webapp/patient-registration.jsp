<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Registration</title>
</head>
<body>
    <h1>Patient Registration</h1>
    <form action="/patients/register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        <!-- Add more patient registration fields here -->
        <input type="submit" value="Register">
    </form>
</body>
</html>
