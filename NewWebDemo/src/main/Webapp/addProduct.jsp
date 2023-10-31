<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form action="/addProduct" method="post" modelAttribute="product">
Product Id <spring:input path="prdId"/><br/>
Product Name<spring:input path="prdName"/><br/>
Product Price<spring:input path="prdPrice"/><br/>
<input type="submit" value="Add Product"/>
</spring:form>
</body>
</html>