

package com.Bank.DAO;
import com.Bank.Connection.ConnectionFactory;
import com.Bank.DTO.Customer;
import com.Bank.DTO.Customer;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CustomerdaoImp implements CustomerDAO {
	
	private Connection cn;
	public CustomerdaoImp()
	{
		this.cn=ConnectionFactory.requestConnection();
	}

	@Override
	public Customer getCustomer(long acc_no, int pin) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="SELECT * FROM CUSTOMER WHERE ACC_NO=? AND PIN=?";
		try {
			
			ps=cn.prepareStatement(query);
			ps.setLong(1, acc_no); 
			
			ps.setInt(2, pin);
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAcc_no(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMailid(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public boolean insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		
			 PreparedStatement ps=null;
			 String query="INSERT INTO CUSTOMER(Name,Phone,Mail,Pin)VALUES(?,?,?,?)";
			 int res=0;
			 try {
			 cn.setAutoCommit(false);
			 ps=cn.prepareStatement(query);
			 ps.setString(1,c.getName());
			 ps.setLong(2, c.getPhone());
			 ps.setString(3, c.getMailid());
			 ps.setInt(4, c.getPin());
			 res=ps.executeUpdate();
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 if(res>0)
			 {
			 try {
			  cn.commit();
			 } 
			 catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			  return true;
			 }
			 else
			 {
			 try {
			   cn.rollback();
			 } 
			 catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
				 }
			return false;
		
	
	}
	}

	@Override
	public Customer getCustomer(long phone, String mailid) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		 ResultSet rs=null;
		 Customer c=null;
		 String query="SELECT * FROM CUSTOMER WHERE PHONE=? AND MAIL=?";
		 try {
		 ps=cn.prepareStatement(query);
		 ps.setLong(1,phone);
		 ps.setString(2, mailid);
		 rs=ps.executeQuery();

		 if(rs.next())
		 {
		 c=new Customer();
		 c.setAcc_no(rs.getInt(1));
		 c.setName(rs.getString(2));
		 c.setPhone(rs.getLong(3));
		 c.setMailid(rs.getString(4));
		 c.setBalance(rs.getDouble(5));
		 c.setPin(rs.getInt(6));
		 }
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 return c;
	}

	@Override
	public Customer getCustomer(long acc_no) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="SELECT * FROM CUSTOMER WHERE ACC_NO=?";
		try {
			
			ps=cn.prepareStatement(query);
			ps.setLong(1, acc_no); 
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAcc_no(rs.getInt("ACC_NO"));
				c.setName(rs.getString("NAME"));
				c.setPhone(rs.getLong("PHONE"));
				c.setMailid(rs.getString("MAIL"));
				c.setBalance(rs.getDouble("BALANCE"));
				c.setPin(rs.getInt("PIN"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public List getCustomer() {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		
		 ArrayList<Customer> customers=new ArrayList<Customer>();
		 ResultSet rs=null;
		 Customer c=null;
		 String query="SELECT * FROM CUSTOMER";
		 try {
		 ps=cn.prepareStatement(query);
		 rs=ps.executeQuery();
		 while(rs.next())
		 {
			 c=new Customer();
			 c.setAcc_no(rs.getInt(1));
			 c.setName(rs.getString(2));
			 c.setPhone(rs.getLong(3));
			 c.setMailid(rs.getString(4));
			 c.setBalance(rs.getDouble(5));
			 c.setPin(rs.getInt(6));
			 customers.add(c);
			 }
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
		 return customers;
	}

		
	

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int res=0;
		String query="UPDATE CUSTOMER SET NAME=?,PHONE=?,MAIL=?,BALANCE=?,PIN=? WHERE ACC_NO=?";
		
		
		try {
			cn.setAutoCommit(false);
			ps=cn.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMailid());
			ps.setDouble(4, c.getBalance());
			ps.setInt(5, c.getPin());
			ps.setLong(6, c.getAcc_no());
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res>0) {
			try {
				cn.commit();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				cn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int res=0;  
		String query="DELETE FROM CUSTOMER WHERE ACC_NO=?";
		
		try {
			 cn.setAutoCommit(false);
			 ps=cn.prepareStatement(query);
			 ps.setLong(1, c.getAcc_no());
			 res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0)
			
			 {
			 try {
			 cn.commit();
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 return true;
			 }
		else
		 {
		 try {
		 cn.rollback();
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 return false;
		 }


	}

}
