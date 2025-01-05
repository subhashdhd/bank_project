package com.Bank.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerdaoImp;
import com.Bank.DTO.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createAccountServlet")
public class createAcoount extends  HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String pin = req.getParameter("password");
        String confirmPin = req.getParameter("confirmPassword");
        
        long phnumber= Long.parseLong(phone);
        int pin1 =Integer.parseInt(pin);
        int confirmPin1 =Integer.parseInt(confirmPin);
       

        // Validate the PINs match
        if (!pin.equals(confirmPin)) {
            resp.getWriter().write("<h3 style='color: red;'>Error: PIN and Confirm PIN do not match!</h3>");
            return;
        }
        Customer c=new Customer();
   	 	CustomerDAO cdao=new CustomerdaoImp();
       
   	 	
   	 if(pin1==confirmPin1)
     {
     	    c.setName(name);
			c.setPhone(phnumber);
			c.setMailid(email);
			c.setPin(pin1);
			boolean res= cdao.insertCustomer(c);
			if(res) {
				c=cdao.getCustomer(phnumber, email);
				req.setAttribute("ss", "Account created  successful... your account number is "+ c.getAcc_no());
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
			else {
//				out.println("<h1> Failed to add the data</h1");
				req.setAttribute("ff", "failed to create account....");
				RequestDispatcher rd = req.getRequestDispatcher("createAccount.jsp");
				rd.forward(req, resp);
			}
        }
	}
}
