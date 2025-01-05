package com.Bank.Servlet;

import java.io.IOException;

import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerdaoImp;
import com.Bank.DAO.TransactionDAO;
import com.Bank.DAO.TransactiondaoImp;
import com.Bank.DTO.Customer;
import com.Bank.DTO.Transaction;
import com.Bank.DTO.TransactionID;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/TransferServlet")
public class TransferAmount extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			HttpSession sess = req.getSession(false);
	        Customer cust = (Customer) sess.getAttribute("customer");
	        
	        if(cust==null) {
	        	resp.sendRedirect("login.jsp");
	        	return;
	        }
	        
	        long bAccount = Long.parseLong(req.getParameter("beneficiaryAccount"));
	        String bName = req.getParameter("beneficiaryName");
	        double amount = Double.parseDouble(req.getParameter("amount"));
	        int pin = Integer.parseInt(req.getParameter("pin"));
	        
	        CustomerDAO cdao=new CustomerdaoImp();
	        Transaction t1=null; //sender transaction details 
	        Transaction t2=null; //receiver transaction details
	        TransactionDAO tdao=new TransactiondaoImp();
	        
	        Customer receiver=cdao.getCustomer(bAccount);
	        
	        if(receiver == null) {
	        	req.setAttribute("error", "Accountt number is not found.....");
	        	RequestDispatcher rd = req.getRequestDispatcher("TransferAmount.jsp");
        		rd.forward(req, resp);
	        	
	        }
	        if(cust.getAcc_no()!=receiver.getAcc_no()&& cust.getBalance()>0&& cust.getBalance()>=amount && amount>0) {
	        		if(pin==cust.getPin()) {
	        			 cust.setBalance(cust.getBalance() - amount);
	        		        boolean isSenderUpdated = cdao.updateCustomer(cust);

	        		        if (isSenderUpdated) {
	        		            // Log debit transaction for sender
	        		            t1 = new Transaction();
	        		            t1.setTran_id(TransactionID.generateTransactionId());
	        		            t1.setUser_acc(cust.getAcc_no());
	        		            t1.setRec_acc(receiver.getAcc_no());
	        		            t1.setTrans_type("DEBITED");
	        		            t1.setAmount(amount);
	        		            t1.setBalance(cust.getBalance());
	        		            boolean isDebitLogged = tdao.insertTransaction(t1);

	        		            // Add amount to receiver
	        		            receiver.setBalance(receiver.getBalance() + amount);
	        		            boolean isReceiverUpdated = cdao.updateCustomer(receiver);

	        		            if (isReceiverUpdated) {
	        		                // Log credit transaction for receiver
	        		                t2 = new Transaction();
	        		                t2.setTran_id(t1.getTran_id());
	        		                t2.setUser_acc(receiver.getAcc_no());
	        		                t2.setRec_acc(cust.getAcc_no());
	        		                t2.setTrans_type("CREDITED");
	        		                t2.setAmount(amount);
	        		                t2.setBalance(receiver.getBalance());
	        		                boolean isCreditLogged = tdao.insertTransaction(t2);

	        		                if (isDebitLogged && isCreditLogged) {
	        		                    req.setAttribute("success", "Transaction successful!");
	        		                } else {
	        		                    req.setAttribute("error", "Transaction logging failed!");
	        		                }
	        		            } else {
	        		                req.setAttribute("error", "Failed to update receiver account balance!");
	        		            }
	        		        } else {
	        		            req.setAttribute("error", "Failed to update sender account balance!");
	        		        }
	        		    } else {
	        		        req.setAttribute("error", "Incorrect PIN. Transaction failed!");
	        		    }
	        		} else {
	        		    req.setAttribute("error", "Invalid transaction details. Check account numbers and balances.");
	        		}

	        		
	        		RequestDispatcher rd = req.getRequestDispatcher("TransferAmount.jsp");
	        		rd.forward(req, resp);
		}
}
