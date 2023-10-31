<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to the Portal</title>
    <style>
        /* Add colorful CSS */
        body {
            font-family: 'Times New Roman', serif;
            background-color: #ffe4e1; /* Light Pink */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background: #fff; /* White */
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        h2 {
            font-size: 28px;
            color: #8e44ad; /* Purple */
        }
        .message {
            font-size: 18px;
            color: #3498db; /* Blue */
        }
        .button {
            background-color: #f39c12; /* Yellow */
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 12px 24px;
            font-size: 18px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #e67e22; /* Orange */
        }
        .error {
            color: #e74c3c; /* Red */
            font-size: 20px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <%
    String user = request.getParameter("username");
    String password = request.getParameter("password");

    if (user.equals("Akula") && password.equals("Akula@143")) {
        session.setAttribute("user", user);
    %>
        <h2>Welcome, <%=user%></h2>
        <p class="message">You are now logged in.</p>
        <h3 style="color:#f39c12">Welcome to the Add Product Page</h3>
        <a class="button" href='AddProduct.jsp'>Add a New Product</a>
    <%
    } else if (user.equals("User") && password.equals("User@143")) {
        session.setAttribute("user", user);
    %>
        <h2>Welcome, <%=user%></h2>
        <p class="message">You are now logged in.</p>
        <h3 style="color:#f39c12">Welcome to the Product List Page</h3>
        <a class="button" href="ProductList.jsp">View Products</a>
    <%
    } else {
    %>
        <h3 class="error">Invalid credentials</h3>
        <a class="button" href="Login.html">Retry</a>
    <%
    }
    %>
</div>
</body>
</html>
