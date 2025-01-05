package com.Bank.DTO;

import java.sql.Date;

public class Transaction {

	private long Tran_id;
	private long User_acc;
	private long Rec_acc ;
	private Date Trans_date;
	private String Trans_type;
	private double Amount;
	private double Balance;
	
	public long getTran_id() {
		return Tran_id;
	}
	public void setTran_id(long tran_id) {
		Tran_id = tran_id;
	}
	public long getUser_acc() {
		return User_acc;
	}
	public void setUser_acc(long user_acc) {
		User_acc = user_acc;
	}
	public long getRec_acc() {
		return Rec_acc;
	}
	public void setRec_acc(long rec_acc) {
		Rec_acc = rec_acc;
	}
	public Date getTrans_date() {
		return Trans_date;
	}
	public void setTrans_date(Date trans_date) {
		Trans_date = trans_date;
	}
	public String getTrans_type() {
		return Trans_type;
	}
	public void setTrans_type(String trans_type) {
		Trans_type = trans_type;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount2) {
		Amount = amount2;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double d) {
		Balance = d;
	}
	@Override
	public String toString() {
		return "Transaction [Tran_id=" + Tran_id + ", User_acc=" + User_acc + ", Rec_acc=" + Rec_acc + ", Trans_date="
				+ Trans_date + ", Trans_type=" + Trans_type + ", Amount=" + Amount + ", Balance=" + Balance + "]";
	}
	
	
	
}
