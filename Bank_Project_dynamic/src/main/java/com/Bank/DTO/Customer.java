package com.Bank.DTO;

public class Customer {
	
	private long Acc_no;
	private String Name;
	private long Phone ;
	private String Mailid;
	private double Balance;
	private int Pin;
	
	public long getAcc_no() {
		return Acc_no;
	}
	public void setAcc_no(long acc_no) {
		Acc_no = acc_no;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public String getMailid() {
		return Mailid;
	}
	public void setMailid(String mailid) {
		Mailid = mailid;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public int getPin() {
		return Pin;
	}
	public void setPin(int pin) {
		Pin = pin;
	}
	@Override
	public String toString() {
		return "Customer [Acc_no=" + Acc_no + ", Name=" + Name + ", Phone=" + Phone + ", Mailid=" + Mailid
				+ ", Balance=" + Balance + "]";
	}
	
	

}
