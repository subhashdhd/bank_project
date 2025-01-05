package com.Bank.Servlet;

import java.io.IOException;

import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerdaoImp;
import com.Bank.DTO.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/forgotPasswordServlet")
public class forgotPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String newPin = req.getParameter("newPassword");
        String confirmPin = req.getParameter("confirmPassword");
        
        long phnumber= Long.parseLong(phone);
        int pin1 =Integer.parseInt(newPin);
        int confirmPin1 =Integer.parseInt(confirmPin);
		
        Customer c=new Customer();
   	 	CustomerDAO cdao=new CustomerdaoImp();
   	 	c=cdao.getCustomer(phnumber, email);
   	 	
   	 if (c != null) {
         System.out.println("Retrieved Phone: " + c.getPhone());
         System.out.println("Retrieved Email: " + c.getMailid());
         System.out.println("Retrieved PIN: " + c.getPin());
     } else {
         System.out.println("No customer found for phone: " + phnumber + " and email: " + email);
     }

   	 	
   	 	if(c!=null && phnumber==c.getPhone() && email.equals(c.getMailid())) {
   	 		if(pin1==confirmPin1) {
   	 			c.setPin(confirmPin1);
   	 			boolean res =cdao.updateCustomer(c);
   	 		     if (res) {
                 req.setAttribute("ss1", "Pin reset successfully....now login again");
                 RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
                 dispatcher.forward(req, resp);
                 } else {
                 req.setAttribute("failure", "Error updating pin. Please try again later.");
                 req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
                
             }
         } else {
             req.setAttribute("message", "Invalid phone number or email. Please verify your details.");
             req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
         }
   	 		}
   	 	
   	 	}
	}

