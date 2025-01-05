package com.Bank.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bank.Connection.ConnectionFactory;
import com.Bank.DTO.Transaction;

public class TransactiondaoImp implements TransactionDAO{

	
	private Connection cn;
	public TransactiondaoImp()
	{
		this.cn=ConnectionFactory.requestConnection();
	}
	@Override
	public boolean insertTransaction(Transaction t) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="INSERT INTO PASSBOOK(TRAN_ID,USER_ACC,REC_ACC,TRANS_DATE,TRAN_TYPE,AMOUNT, BALANCE)" 
		+" VALUES(?,?,?,SYSDATE(),?,?,?)";
		int res=0;
		try {
			cn=ConnectionFactory.requestConnection();
			ps=cn.prepareStatement(query);
			ps.setLong(1, t.getTran_id());
			ps.setLong(2, t.getUser_acc());
			ps.setLong(3, t.getRec_acc());
			ps.setString(4, t.getTrans_type());
			ps.setDouble(5,t.getAmount());
			ps.setDouble(6, t.getBalance());
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List getTransaction(long user) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query= " SELECT * FROM PASSBOOK WHERE USER_ACC=? ORDER BY TRANS_DATE DESC";
		Transaction t=null;
		ArrayList<Transaction> passbook=new ArrayList<Transaction>();
		
		try {
			ps=cn.prepareStatement(query);
			ps.setLong(1, user);
			rs=ps.executeQuery();
			while(rs.next()) 
			{
				t=new Transaction();
				t.setTran_id(rs.getLong(1));
				t.setUser_acc(rs.getLong(2));
				t.setRec_acc(rs.getLong(3));
				t.setTrans_date(rs.getDate(4));
				t.setTrans_type(rs.getString(5));
				t.setAmount(rs.getDouble(6));
				t.setBalance(rs.getDouble(7));
				passbook.add(t);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passbook;
	}
	
	public List getTransaction() {
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 String query="SELECT * FROM PASSBOOK ORDER BY TRANS_DATE desc";
		 Transaction t=null;
		 ArrayList<Transaction> passbook=new ArrayList<Transaction>();
		try {
		 ps=cn.prepareStatement(query);
		 rs=ps.executeQuery();
		 while(rs.next())
		 {
		 t=new Transaction();
		 t.setTran_id(rs.getLong(1));
		 t.setUser_acc(rs.getLong(2));
		 t.setRec_acc(rs.getLong(3));
		 t.setTrans_date(rs.getDate(4));
		 t.setTrans_type(rs.getString(5));
		 t.setAmount(rs.getDouble(6));
		 t.setBalance(rs.getDouble(7));
		 passbook.add(t);
		 }
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 return passbook;
		}

}
		 
