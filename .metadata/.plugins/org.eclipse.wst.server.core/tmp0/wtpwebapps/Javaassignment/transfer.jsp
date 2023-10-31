<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Fund Transfer</title>
</head>
<body>
    <h1>Fund Transfer</h1>
    <form action="TransferServlet" method="post">
        Destination User ID: <input type="text" name="destinationAccount" required><br>
        Amount: <input type="text" name="transferAmount" required><br>
        <input type="submit" value="Transfer">
    </form>
</body>
</html>
