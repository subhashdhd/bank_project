<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.Bank.DTO.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('image.png'); /* Updated background */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
            color: #ffffff;
        }
        .navbar {
            background-color: rgba(0, 33, 71, 0.9); /* Semi-transparent navy blue */
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
        .dropdown-menu {
            background-color: rgba(0, 33, 71, 0.9); /* Match navbar color */
        }
        .dropdown-item {
            color: #ffffff !important;
        }
        .dropdown-item:hover {
            background-color: #005f8d; /* Highlight color */
        }
        .hero-section {
            text-align: center;
            padding: 80px 20px;
            background-color: rgba(0, 0, 0, 0.6); /* Semi-transparent overlay */
            margin-top: 10px;
        }
        .hero-section h1 {
            font-size: 3em;
            color: #d4af37; /* Metallic gold */
            margin-bottom: 20px;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5);
        }
        .hero-section p {
            font-size: 1.2em;
            color: #f8f9fa;
        }
        .image-slider {
            overflow: hidden;
            white-space: nowrap;
            margin: 10px 10px;
            padding: 10px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
        }
        .image-slider img {
            height: 300px;
            margin: 0 20px;
            display: inline-block;
            animation: slide 10s linear infinite;
        }
        @keyframes slide {
            0% {
                transform: translateX(100%);
            }
            100% {
                transform: translateX(-100%);
            }
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
    }
	%>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="bankDashboard.jsp"> Welcome <%= cust.getName() %>!</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="updateAccount.jsp">Update Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="profile.jsp">Profile</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Services
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="Deposite.jsp">Deposit Money</a></li>
                            <li><a class="dropdown-item" href="withdrawal.jsp">Withdraw Money</a></li>
                            <li><a class="dropdown-item" href="TransferAmount.jsp">Transfer Money</a></li>
                            <li><a class="dropdown-item" href="viewPassbook.jsp">View Passbook</a></li>
                        </ul>
                    </li>
                <% if (cust.getAcc_no()==1100110013) { %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Access Data
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="getAccountDetails.jsp">Get Account Details</a></li>
                        <li><a class="dropdown-item" href="getTransaction.jsp">Get Transaction List</a></li>
                        <li><a class="dropdown-item" href="delete.jsp">Delete Account</a></li>
                    </ul>
                </li>
                <% } %>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero-section">
        <h1>Welcome to Your Bank Dashboard</h1>
        <p>Access all your banking needs at one place.</p>
    </section>

    <!-- Image Slider -->
    <div class="image-slider">
        <img src="images/image3.jpg" alt="Bank Image 1">
        <img src="images/image5.jpg" alt="Bank Image 2">
        <img src="images/image4.jpg" alt="Bank Image 3">
        <img src="images/image6.jpg" alt="Bank Image 4">
    </div>

    <footer>
        &copy; 2024 Bank Management System. All Rights Reserved.
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
