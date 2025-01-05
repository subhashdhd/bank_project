package com.Bank.Servlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess= req.getSession(false);
		if(sess!=null) {
			sess.invalidate();
		}
		req.setAttribute("succ", "logout succesful......");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}

