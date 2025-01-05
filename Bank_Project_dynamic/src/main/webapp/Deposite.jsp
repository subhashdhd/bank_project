<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.Bank.DTO.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit Money</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('image.png'); /* Background consistent with dashboard */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
            color: #ffffff;
        }
        .navbar {
            background-color: rgba(0, 33, 71, 0.9);
        }
        .navbar-brand {
            font-size: 1.5em;
            font-weight: bold;
            color: #ffffff;
        }
        .nav-link {
            color: #ffffff !important;
            font-size: 1em;
        }
        .nav-link:hover {
            color: #d4af37 !important; /* Metallic gold */
        }
        .deposit-section {
            max-width: 500px;
            margin: 50px auto;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            padding: 20px;
            color: #000;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .deposit-section h2 {
            text-align: center;
            color: #002147; /* Deep navy blue */
            margin-bottom: 20px;
            font-family: 'Verdana', sans-serif;
            font-size: 1.8rem;
            font-weight: bold;
        }
        .btn-deposit {
            background-color: #002147;
            color: #ffffff;
            width: 100%;
        }
        footer {
            text-align: center;
            padding: 10px 0;
            background-color: rgba(0, 33, 71, 0.9);
            color: #f8f9fa;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <% 
    Customer cust = (Customer) session.getAttribute("customer");
    if (cust == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    %>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Welcome <%= cust.getName() %>!</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                     <li class="nav-item">
                        <a class="nav-link" href="bankDashboard.jsp">Home</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
        <% String error = (String) request.getAttribute("error"); %>
        <% String success = (String) request.getAttribute("success"); %>
        <% String error1 = (String) request.getAttribute("error1"); %>
        <% String failure = (String) request.getAttribute("failure"); %>

        <% if (error != null) { %>
            <div class="alert alert-danger text-center" role="alert" style="font-size: 1.1em; font-weight: bold;">
                <%= error %>
            </div>
        <% } %>
        <% if (success != null) { %>
            <div class="alert alert-success text-center" role="alert" style="font-size: 1.1em; font-weight: bold;">
                <%= success %>
            </div>
        <% } %>
        <% if (error1 != null) { %>
            <div class="alert alert-warning text-center" role="alert" style="font-size: 1.1em; font-weight: bold;">
                <%= error1 %>
            </div>
        <% } %>
        <% if (failure != null) { %>
            <div class="alert alert-info text-center" role="alert" style="font-size: 1.1em; font-weight: bold;">
                <%= failure %>
            </div>
        <% } %>

    <!-- Deposit Section -->
    <div class="deposit-section">
        <h2>Deposit Money</h2>
        <form action="DepositServlet" method="post">
            <div class="mb-3">
                <label for="amount" class="form-label">Enter Amount to Deposit</label>
                <input type="number" class="form-control" id="amount" name="amount" placeholder="Enter the amount" min="1" required>
            </div>
            <div class="mb-3">
                <label for="pin" class="form-label">Enter PIN</label>
                <input type="password" class="form-control" id="pin" name="pin" placeholder="Enter your PIN" required>
            </div>
            <button type="submit" class="btn btn-deposit">Deposit</button>
        </form>
    </div>

   

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
