package com.Bank.Servlet;

import java.io.IOException;

import com.Bank.DTO.TransactionID;
import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerdaoImp;
import com.Bank.DAO.TransactionDAO;
import com.Bank.DAO.TransactiondaoImp;
import com.Bank.DTO.Customer;
import com.Bank.DTO.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DepositServlet")
public class Deposite extends HttpServlet {
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				HttpSession sess = req.getSession(false);
		        Customer cust = (Customer) sess.getAttribute("customer");
		        		
		        if(cust==null) {
		        	resp.sendRedirect("login.jsp");
		        	return;
		        }
		        
		        double depositAmount = Integer.parseInt(req.getParameter("amount"));
		        int pin1 = Integer.parseInt(req.getParameter("pin"));
		        
		        if (pin1!=cust.getPin()) {
	                req.setAttribute("error", "Incorrect PIN. Please try again.");
	                req.getRequestDispatcher("Deposite.jsp").forward(req, resp);
	                return;
	            }
		        
		        if (depositAmount <= 0) {
	                req.setAttribute("error1", "Deposit amount must be greater than 0.");
	                req.getRequestDispatcher("Deposite.jsp").forward(req, resp);
	                return;
	            }
		        
		        CustomerDAO cdao=new CustomerdaoImp();
				TransactionDAO tdao=new TransactiondaoImp();
				cust.setBalance(cust.getBalance()+ depositAmount);
				
				boolean res=cdao.updateCustomer(cust);
				if(res) {
					Transaction t=new Transaction();
					t.setTran_id(TransactionID.generateTransactionId());
					t.setUser_acc(cust.getAcc_no());
					t.setRec_acc(cust.getAcc_no());
					t.setTrans_type("Credited...");
					t.setAmount(depositAmount);
					t.setBalance(cust.getBalance());
					boolean res1=tdao.insertTransaction(t);
					if(res) {
						sess.setAttribute("customer", cust);
						req.setAttribute("success", "Deposit successful! New Balance: ₹" + cust.getBalance());
						req.getRequestDispatcher("Deposite.jsp").forward(req, resp);
					}
					else {
						req.setAttribute("failure", "Deposit failed. Please try again...");
						req.getRequestDispatcher("Deposite.jsp").forward(req, resp);
					}
			}
}
}