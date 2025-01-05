<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="com.Bank.DTO.*" %>  
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Management Home</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('image.png'); /* Updated to use the uploaded image */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
            color: #ffffff; /* Set default text color for contrast */
        }
        .navbar {
            background-color: rgba(0, 33, 71, 0.9); /* Semi-transparent deep navy blue */
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
        .hero-section {
            text-align: center;
            padding: 80px 20px;
            background-color: rgba(0, 0, 0, 0.6); /* Semi-transparent overlay for text readability */
            margin-top: 20px;
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
            margin: 30px 0;
            padding: 20px;
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
            background-color: rgba(0, 33, 71, 0.9); /* Match navbar color */
            color: #f8f9fa; /* Light gray */
            margin-top: 30px;
        }
         .message {
            margin-bottom: 15px;
            padding: 10px;
            border-radius: 4px;
            text-align: center;
            font-weight: bold;
            font-size: 14px;
        }
       .success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

    <nav class="navbar navbar-expand-lg">
    
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Bank Management System</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="createAccount.jsp">Create Account</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
  

    <section class="hero-section">
        <h1>Welcome to Your Bank</h1>
        <p>Manage your accounts securely and efficiently.</p>
        <div class="image-slider">
           
            <img src="images/image3.jpg" alt=>
            <img src="images/image5.jpg" alt=>
            <img src="images/image4.jpg" alt=>
            <img src="images/image6.jpg" alt=>
           
        </div>
        
    </section>

    <footer>
        &copy; 2024 Bank Management System. All Rights Reserved.
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 