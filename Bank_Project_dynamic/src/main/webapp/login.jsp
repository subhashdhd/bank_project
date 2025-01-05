<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Bank Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('images/image7.jpg'); /* Match the welcome page background */
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
        .login-section {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: rgba(0, 0, 0, 0.6); /* Semi-transparent overlay for readability */
        }
        .login-card {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            width: 100%;
            margin-bottom: 20px;
        }
        .login-card h2 {
            text-align: center;
            color: #002147; /* Deep navy blue */
            margin-bottom: 20px;
            font-family: 'Verdana', sans-serif;
            font-size: 1.8rem;
            font-weight: bold;
        }
        .form-label {
            color: #002147;
            font-weight: bold;
        }
        .btn-primary {
            background-color: #d4af37;
            border-color: #d4af37;
        }
        .btn-primary:hover {
            background-color: #b58d2b;
            border-color: #b58d2b;
        }
        .additional-links {
            text-align: center;
            margin-top: 10px;
        }
        .additional-links a {
            color: #000000; /* Black font color */
            text-decoration: none;
        }
        .additional-links a:hover {
            color: #b58d2b; /* Hover color */
            text-decoration: underline;
        }
        .additional-links span {
            color: #000000; /* Black color for the separator */
            font-weight: bold;
        }
        footer {
            text-align: center;
            padding: 10px 0;
            background-color: rgba(0, 33, 71, 0.9); /* Match navbar color */
            color: #f8f9fa; /* Light gray */
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
        .failure {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Bank Management System</a>
        </div>
    </nav>
    <%
   		 String failure = (String) request.getAttribute("ff");
         String success = (String) request.getAttribute("ss");
         String success1 = (String) request.getAttribute("ss1");
    %>
    
     <% if (success != null) { %>
            <div class="message success">
                <%= success %>
            </div>
        <% } else if (failure != null) { %>
            <div class="message failure">
                <%= failure %>
            </div>
        <% } else if (success1 != null) { %>
        <div class="message success">
        <%= success1 %>
    </div>
<% } %>
      

    <section class="login-section">
        <div class="login-card">
            <h2>Login</h2>
            <form action="loginServlet" method="post"> <!-- Change the action to your backend servlet or controller -->
                <div class="mb-3">
                    <label for="accountNumber" class="form-label">Account Number</label>
                    <input type="text" class="form-control" id="accountNumber" name="accountNumber" placeholder="Enter your account number" required>
                </div>
                <div class="mb-3">
                    <label for="pin" class="form-label">PIN</label>
                    <input type="password" class="form-control" id="pin" name="pin" placeholder="Enter your PIN" required>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
                <div class="additional-links">
                    <a href="forgotPassword.jsp">Forgot PIN?</a> <span>|</span> <a href="createAccount.jsp">Don't have an account? Create Account</a>
                </div>
            </form>
        </div>
       
    </section>

    <footer>
        &copy; 2024 Bank Management System. All Rights Reserved.
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
