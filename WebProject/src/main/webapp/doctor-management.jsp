<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Management</title>
</head>
<body>
    <h1>Doctor Management</h1>
    <table>
        <tr>
            <th>Doctor ID</th>
            <th>Name</th>
            <th>Specialization</th>
            <!-- Add more doctor details here -->
            <th>Actions</th>
        </tr>
        <c:forEach items="${doctors}" var="doctor">
            <tr>
                <td>${doctor.id}</td>
                <td>${doctor.name}</td>
                <td>${doctor.specialization}</td>
                <!-- Display more doctor details here -->
                <td>
                    <!-- Add buttons or links for editing and deleting doctors -->
                    <a href="/doctors/edit/${doctor.id}">Edit</a>
                    <a href="/doctors/delete/${doctor.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
