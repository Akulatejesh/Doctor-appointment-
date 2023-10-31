<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Schedule Appointment</title>
</head>
<body>
    <h1>Schedule an Appointment</h1>
    <form action="/appointments/schedule" method="post">
        <!-- Add form fields for appointment details -->
        <label for="patient">Select Patient:</label>
        <select name="patient.id">
            <c:forEach items="${patients}" var="patient">
                <option value="${patient.id}">${patient.name}</option>
            </c:forEach>
        </select>
        <br>

        <label for="doctor">Select Doctor:</label>
        <select name="doctor.id">
            <c:forEach items="${doctors}" var="doctor">
                <option value="${doctor.id}">${doctor.name}</option>
            </c:forEach>
        </select>
        <br>

        <label for="appointmentDate">Appointment Date:</label>
        <input type="date" name="appointmentDate" required>
        <br>

        <label for="description">Description:</label>
        <textarea name="description" rows="4" cols="50" required></textarea>
        <br>

        <input type="submit" value="Schedule Appointment">
    </form>
</body>
</html>
