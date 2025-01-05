package com.Bank.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
public static Connection requestConnection() {
		
		Connection cn=null;
		String url="jdbc:mysql://localhost:3306/bank";
		String user="root";
		String password="Subhas@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
}
