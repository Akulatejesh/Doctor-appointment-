<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

    
<meta
 
charset="UTF-8">

    
<title>Patient Details</title>
    <style>
        body {
            font-family: sans-serif;
            background-color: #fff;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column; /* Display elements vertically */
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        h1 {
            background-color: #007BFF;
            color: #fff;
            text-align: center;
            padding: 20px 0;
            border-radius: 10px;
            margin: 0;
        }

        .details-container {
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            margin: 10px 0;
            max-width: 400px;
            text-align: left;
        }

        strong {
            font-weight: bold;
        }

        .details-container p {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <h1>Patient Details</h1>
    
    <c:if test="${not empty patientDetails}">
        <c:forEach items="${patientDetails}" var="detail">
            <div class="details-container">
                <p><strong>Patient Name:</strong> ${detail.patientName}</p>
                <p><strong>Patient Info:</strong> ${detail.patientInfo}</p>
                <p><strong>Age:</strong> ${detail.age}</p>
                <p><strong>Address:</strong> ${detail.address}</p>
                <p><strong>Phone Number:</strong> ${detail.phoneNumber}</p>
                <p><strong>Appointment Date:</strong> ${detail.appointmentDate}</p>
                <p><strong>Appointment Time:</strong> ${detail.appointmentTime}</p>
                </div>
        </c:forEach>
    </c:if>
</body>
</html>