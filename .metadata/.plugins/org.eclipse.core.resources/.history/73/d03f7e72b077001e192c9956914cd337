<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administrator Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #2196F3;
            color: #fff;
            text-align: center;
            padding: 15px 0;
            margin: 0;
        }

        h2 {
            margin: 20px 0;
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        th, td {
            text-align: left;
            padding: 12px;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        td {
            color: #333;
        }

        .not-available {
            background-color: #E91E63;
            color: #fff;
            padding: 5px 10px;
            border-radius: 5px;
        }

        .available {
            background-color: #4CAF50;
            color: #fff;
            padding: 5px 10px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h1>Administrator Dashboard</h1>

    <h2>Doctors Details</h2>

    <table border="1">
        <tr>
            <th>Doctor Name</th>
            <th>Specialization</th>
            <th>Availability</th>
        </tr>
        <c:forEach items="${allDoctors}" var="doctor">
            <tr>
                <td>${doctor.fullName}</td>
                <td>${doctor.specialization}</td>
                <td>
                    <c:choose>
                        <c:when test="${doctor.leaveRequested}">
                            <span class="not-available">Not Available (Leave: ${doctor.leaveStartDate} - ${doctor.leaveEndDate})</span>
                        </c:when>
                        <c:otherwise>
                            <span class="available">Available</span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Logout</a>
</body>
</html>
