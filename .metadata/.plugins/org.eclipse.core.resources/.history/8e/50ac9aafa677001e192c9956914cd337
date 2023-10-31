<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Details</title>
</head>
<body>
    <h1>Patient Details</h1>

    <c:if test="${not empty patientDetails}">
        <table border="1">
            <tr>
                <th>Patient Name</th>
                <th>Patient Info</th>
                <th>Age</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Appointment Date</th>
                <th>Appointment Time</th>
            </tr>
            <tr>
                <td>${patientDetails.patientName}</td>
                <td>${patientDetails.patientInfo}</td>
                <td>${patientDetails.age}</td>
                <td>${patientDetails.address}</td>
                <td>${patientDetails.phoneNumber}</td>
                <td>${patientDetails.appointmentDate}</td>
                <td>${patientDetails.appointmentTime}</td>
            </tr>
        </table>
    </c:if>

    <c:if test="${empty patientDetails}">
        <p>No patient details found.</p>
    </c:if>
</body>
</html>
