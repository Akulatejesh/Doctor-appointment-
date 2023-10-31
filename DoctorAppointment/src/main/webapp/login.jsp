<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Railway login interface</title>
 
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        text-align: center;
    }
 
    h2 {
        color: #333;
    }
 
    form {
        background-color: #fff;
        border-radius: 5px;
        padding: 20px;
        width: 300px;
        margin: 0 auto;
        text-align: left;
    }
 
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
 
    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }
 
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
 
</head>
<body>
<h2>Doctor Login Page</h2>
<form action="/login" method="post">
    User Name<br>
    <input type="text" name="user"><br>
    Password<br>
    <input type="password" name="pass"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
 