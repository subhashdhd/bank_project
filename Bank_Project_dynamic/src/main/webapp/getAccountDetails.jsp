<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.Bank.DTO.*,java.util.*, com.Bank.DAO.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Passbook</title>
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
        .passbook-section {
            max-width: 900px;
            margin: 50px auto;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            padding: 20px;
            color: #000;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .passbook-section h2 {
            text-align: center;
            color: #002147; /* Deep navy blue */
            margin-bottom: 20px;
            font-family: 'Verdana', sans-serif;
            font-size: 1.8rem;
            font-weight: bold;
        }
        .table {
            margin-top: 20px;
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

    <% 
    
    CustomerDAO cdao=new CustomerdaoImp();
    
    // Assuming transactions are stored in a list for the logged-in customer
    List<Customer> customers =cdao.getCustomer();

    if (customers == null || customers.isEmpty()) {
    %>
        <div class="alert alert-warning text-center" role="alert">
            No transactions found for this account.
        </div>
    <% 
    } else {
    %>
        <!-- Passbook Section -->
        <div class="passbook-section">
            <h2>Account Details</h2>
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>ACC_NO</th>
                        <th>NAME</th>
                        <th>MAIL</th>
                        <th>PHONE</th>
                        <th>BALANCE</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    for (Customer c : customers) {
                    %>
                    <tr>
                        <td><%= c.getAcc_no() %></td>
                        <td><%= c.getName() %></td>
                        <td><%= c.getMailid() %></td>
                        <td><%= c.getPhone() %></td>
                        <td><%= c.getBalance() %></td>
                        
                    </tr>
                    <% 
                    }
                    %>
                </tbody>
            </table>
        </div>
    <% 
    }
    %>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
