<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Appointments</title>
</head>
<body>
    <h1>List of Appointments</h1>
    <table>
        <tr>
            <th>Appointment ID</th>
            <th>Date</th>
            <!-- Add more appointment details here -->
        </tr>
        <c:forEach items="${appointments}" var="appointment">
            <tr>
                <td>${appointment.id}</td>
                <td>${appointment.date}</td>
                <!-- Display more appointment details here -->
            </tr>
        </c:forEach>
    </table>
</body>
</html>
