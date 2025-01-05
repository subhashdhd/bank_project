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
@WebServlet("/DeleteAccountServlet")
public class delete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = req.getSession(false);
        Customer cust = (Customer) sess.getAttribute("customer");
        		
        if(cust==null) {
        	resp.sendRedirect("login.jsp");
        	return;
        }
        
        long accno = Long.parseLong(req.getParameter("accountNumber"));
        
        CustomerDAO cdao=new CustomerdaoImp();
        TransactionDAO tdao=new TransactiondaoImp();
        Transaction t1=null; //sender transaction details 
       
        
        Customer receiver=cdao.getCustomer(accno);
        if(receiver==null) {
        	req.setAttribute("error", "user account not found..");
        	RequestDispatcher rd = req.getRequestDispatcher("delete.jsp");
    		rd.forward(req, resp);
        }
        if(receiver.getAcc_no()!=1100110016) {
        	
        	 cust.setBalance(cust.getBalance() + receiver.getBalance());
             boolean res = cdao.updateCustomer(cust);
             
            if(res) {
            	t1 = new Transaction();
                t1.setTran_id(TransactionID.generateTransactionId());
                t1.setUser_acc(cust.getAcc_no());
                t1.setRec_acc(receiver.getAcc_no());
                t1.setTrans_type("credited...");
                t1.setAmount(receiver.getBalance());
                t1.setBalance(cust.getBalance());
                boolean res1 = tdao.insertTransaction(t1);
                
                if(res1) {
                	boolean accountDelete = cdao.deleteCustomer(receiver);
                	if (accountDelete) {
                        req.setAttribute("success", "Account deleted successfully.");
                    } else {
                        req.setAttribute("error", "Failed to delete the account.");
                    }
                }else {
                    req.setAttribute("error", "Failed to log the transaction.");
                }
            } else {
                req.setAttribute("error", "Failed to update admin's balance.");
            }
        } else {
            req.setAttribute("error", "Invalid account number or cannot delete admin account.");
        }
            
        req.getRequestDispatcher("delete.jsp").forward(req, resp);
       
       
        }
        
	}
