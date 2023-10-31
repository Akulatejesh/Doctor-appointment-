<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Deposit Money</title>
</head>
<body>
    <h1>Deposit Money</h1>
    <form action="DepositServlet" method="post">
        Amount: <input type="text" name="depositAmount" required><br>
        <input type="submit" value="Deposit">
    </form>
</body>
</html>
