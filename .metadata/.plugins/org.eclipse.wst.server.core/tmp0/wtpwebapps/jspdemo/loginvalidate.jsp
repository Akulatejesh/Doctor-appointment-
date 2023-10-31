<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jspdemo.UserValidate" %>
    <%@include file="header.html" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Validate Login</title>
</head>
<body>
    <%
    String user = request.getParameter("uname");
    String password = request.getParameter("pass");
    UserValidate validate = new UserValidate();
    if (validate.isValidUser(user, password)) {
        session.setAttribute("user", user);
    %>
        <h2>Welcome to <%= user %></h2>
        <jsp:include page="welcome.jsp">
            <jsp:param value="<%= user %>" name="user" />
        </jsp:include>
        <a href='home.jsp'>Click to home page</a>
    <%
    } else {
    %>
        <h3 style="color:red">Invalid credentials</h3>
        <a href="Login.html">Click to re-login</a>
    <%
    }
    %>
</body>
</html>
