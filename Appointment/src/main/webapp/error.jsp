<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
 
        .error-container {
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #e0e0e0;
            background-color: #f9f9f9;
            max-width: 400px;
        }
 
        h2 {
            color: #e53935;
        }
 
        .login-link {
            text-decoration: none; 
            color: #1976D2;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h2>Error</h2>
        <p>Invalid username or password. Please try again.</p>
        <p><a class="login-link" href="/login">Return to Login</a></p>
    </div>
</body>
</html>