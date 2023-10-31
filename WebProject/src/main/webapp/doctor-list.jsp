<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Doctors</title>
</head>
<body>
    <h1>List of Doctors</h1>
    <table>
        <tr>
            <th>Doctor ID</th>
            <th>Name</th>
            <!-- Add more doctor details here -->
        </tr>
        <c:forEach items="${doctors}" var="doctor">
            <tr>
                <td>${doctor.id}</td>
                <td>${doctor.name}</td>
                <!-- Display more doctor details here -->
            </tr>
        </c:forEach>
    </table>
</body>
</html>
