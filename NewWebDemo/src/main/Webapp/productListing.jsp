<%@page import="com.example.demo.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Product List</h2>
<%-- <%List<Product> list=(List<Product>)request.getAttribute("prdlist");
%> --%>
<table>
<tr>
 <td>Product Id</td><td>Product Name</td><td>Product Price</td>

</tr>
<c:forEach items="${prdlist}" var="item">
<tr>
 <td><c:out value="${item.prdId}"/></td>
<td><c:out value="${item.prdName}"/></td>
<td><c:out value="${item.prdPrice}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>