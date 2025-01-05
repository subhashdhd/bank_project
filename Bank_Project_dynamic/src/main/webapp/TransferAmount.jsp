<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transfer Amount</title>
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
        .transfer-section {
            max-width: 500px;
            margin: 50px auto;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            padding: 20px;
            color: #000;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .transfer-section h2 {
            text-align: center;
            color: #002147; /* Deep navy blue */
            margin-bottom: 20px;
            font-family: 'Verdana', sans-serif;
            font-size: 1.8rem;
            font-weight: bold;
        }
        .btn-transfer {
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
        .alert {
            margin-bottom: 20px;
            text-align: center;
            font-size: 1.1em;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <!-- Left-Aligned Text -->
            <a class="navbar-brand" href="#">Banking Dashboard</a>
            
            <!-- Right-Aligned Links -->
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="bankDashboard.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

   >
            <% 
                // Fetch success or error messages set in the servlet
                String successMessage = (String) request.getAttribute("success");
                String errorMessage = (String) request.getAttribute("error");

                if (successMessage != null) { 
            %>
                <!-- Display Success Message -->
                <div class="alert alert-success" role="alert">
                    <strong>Success!</strong> <%= successMessage %>
                </div>
            <% } else if (errorMessage != null) { %>
                <!-- Display Error Message -->
                <div class="alert alert-danger" role="alert">
                    <strong>Error!</strong> <%= errorMessage %>
                </div>
            <% } %>

    <!-- Transfer Section -->
    <div class="transfer-section">
        <h2>Transfer Amount</h2>
        <form action="TransferServlet" method="post">
            <div class="mb-3">
                <label for="beneficiaryAccount" class="form-label">Beneficiary Account Number</label>
                <input type="text" name="beneficiaryAccount" id="beneficiaryAccount" class="form-control" placeholder="Enter beneficiary account number" required>
            </div>
            <div class="mb-3">
                <label for="beneficiaryName" class="form-label">Beneficiary Name</label>
                <input type="text" name="beneficiaryName" id="beneficiaryName" class="form-control" placeholder="Enter beneficiary name" required>
            </div>
            <div class="mb-3">
                <label for="amount" class="form-label">Amount</label>
                <input type="number" name="amount" id="amount" class="form-control" placeholder="Enter transfer amount" required>
            </div>
            <div class="mb-3">
                <label for="pin" class="form-label">Enter PIN</label>
                <input type="password" name="pin" id="pin" class="form-control" placeholder="Enter your PIN" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-transfer btn-lg">Transfer</button>
            </div>
        </form>
    </div>

   

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
