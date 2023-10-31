<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Product details</h1>
<%
Product prd = (Product) request.getAttribute("product");
%>
<%= prd.getPrdId() %>
<%= prd.getPrdName() %>
<%= prd.getPrdPrice() %>

<h3>${prd}</h3>
</body>
</html>
