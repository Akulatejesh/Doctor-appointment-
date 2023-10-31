<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Withdraw Money</title>
</head>
<body>
    <h1>Withdraw Money</h1>
    <form action="WithdrawServlet" method="post">
        Amount: <input type="text" name="withdrawalAmount" required><br>
        <input type="submit" value="Withdraw">
    </form>
</body>
</html>
