package com.Bank.Servlet;

import java.io.IOException;

import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerdaoImp;
import com.Bank.DTO.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//create session
				HttpSession sess= req.getSession();
				
		        String accountNumber = req.getParameter("accountNumber");
		        String pin = req.getParameter("pin");
		        
		        int pin1 =Integer.parseInt(pin);
		        long accNo= Long.parseLong(accountNumber);
		        
		        Customer c=new Customer();
		   	 	CustomerDAO cdao=new CustomerdaoImp();
		   	 	
		   	 	c=cdao.getCustomer(accNo, pin1);
		   	 	
		   	 	if(c!=null && pin1==(c.getPin())) {
		   	 		sess.setAttribute("customer", c);
//		   	 	    req.setAttribute("ss", "Logged in succesfull....");
		   	 		
		   	 		req.getRequestDispatcher("bankDashboard.jsp").forward(req, resp);
		   	 	}
		   	 	else {
		   	 	 req.setAttribute("ff", "Invalid account number or pin.");
		   	 	req.getRequestDispatcher("login.jsp").forward(req, resp);
		   	 	 
		   	 	}

	}
}
