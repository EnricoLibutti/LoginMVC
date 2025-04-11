<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            margin: 40px auto;
        }
        h1 {
            color: #333;
        }
        .user-info {
            margin: 20px 0;
            padding: 15px;
            background-color: #f9f9f9;
            border-radius: 4px;
        }
        .actions {
            margin-top: 20px;
        }
        .btn {
            display: inline-block;
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-right: 10px;
        }
        .btn-details {
            background-color: #2196F3;
        }
        .btn-logout {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Home Page</h1>
        
        <div class="user-info">
            <h2>User Information</h2>
            <p><strong>First Name:</strong> ${user.firstName}</p>
            <p><strong>Last Name:</strong> ${user.lastName}</p>
        </div>
        
        <div class="actions">
            <a href="<c:url value='/details'/>" class="btn btn-details">View Details</a>
            <a href="<c:url value='/logout'/>" class="btn btn-logout">Logout</a>
        </div>
    </div>
</body>
</html>