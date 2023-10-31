<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Account Balance</title>
</head>
<body>
    <h1>Account Balance</h1>
    <p>Your account balance is: <%= request.getAttribute("balance") %></p>
   
</body>
</html>
