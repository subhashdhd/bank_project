package com.Bank.DAO;

import java.util.List;

import com.Bank.DTO.Customer;

public interface CustomerDAO {
	
	public boolean insertCustomer (Customer c); 
	public Customer getCustomer (long acc_no,int pin); 
	public Customer getCustomer (long phone, String mailid); 
	public Customer getCustomer (long acc_no); 
	public List getCustomer();
	public boolean updateCustomer (Customer c) ; 
	public boolean deleteCustomer (Customer c);
}
