<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Medical App</title>
</head>
<body>
    <h1>Welcome to the Medical App</h1>
    <ul>
        <li><a href="<c:url value='/patients/list'/>">Patients List</a></li>
        <li><a href="<c:url value='/doctors/list'/>">Doctors List</a></li>
        <li><a href="<c:url value='/appointments/list'/>">Appointments List</a></li>
        <li><a href="<c:url value='/users/admin'/>">User Administration</a></li>
    </ul>
</body>
</html>
