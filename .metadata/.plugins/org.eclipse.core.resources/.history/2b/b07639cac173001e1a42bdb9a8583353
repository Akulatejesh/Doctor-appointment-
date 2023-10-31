<%@page import="com.example.demo.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Prodcut List</h2>
<%List<Product> list=(List<Product>)request.getAttribute("prdlist");
%>
<table>
<tr><td>Product Id</td><td>Product Name</td><td>Product Price</td></tr>
<%for(Product p:list){ %>
<tr>
<td><%=p.getPrdId() %></td>
<td><%=p.getPrdName() %></td>
<td><%=p.getPrdPrice() %></td>
</tr>
<%} %>
</table>
</body>
</html>