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

@WebServlet("/updateAccount")
public class updateAccount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
        long phnum = Long.parseLong(req.getParameter("phone"));
        String mailid = req.getParameter("email");
        int pin = Integer.parseInt(req.getParameter("pin"));

        // Get the logged-in student from the session
        HttpSession sess = req.getSession(false);
        Customer cust = (Customer) sess.getAttribute("customer");
        		
        if(cust==null) {
        	resp.sendRedirect("login.jsp");
        	return;
        }
        
        cust.setName(name);
        cust.setPhone(phnum);
        cust.setMailid(mailid);
        if(pin==cust.getPin()) {
        	
        	CustomerDAO cdao=new CustomerdaoImp();
            boolean res=cdao.updateCustomer(cust);
            
            if(res) {
            	req.setAttribute("ss", "Data Updated succesfull....");
            	req.getRequestDispatcher("updateAccount.jsp").forward(req, resp);
            } 
//            else {
//            	req.setAttribute("ff", "failed to update the data....");
//            	req.getRequestDispatcher("UpdateAccount.jsp").forward(req, resp);
//            }
        }else {
        	req.setAttribute("ff", "pin mismatched...failed to update the data....");
        	req.getRequestDispatcher("UpdateAccount.jsp").forward(req, resp);
        	
        }
        
        
	}
}
