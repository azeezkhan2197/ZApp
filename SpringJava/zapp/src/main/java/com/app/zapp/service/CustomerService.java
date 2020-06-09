package com.app.zapp.service;

import java.util.List;

import com.app.zapp.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer findById(String id);
	
	public void save(Customer	customer);
	
	public void updateCustomer(Customer customer);
	 
	public void deleteById(String id);
	
	public String  getPassword(String id);
	
	public void depositAmount(String id,int amount);
	
	//public void editCustomer(Customer customer);
}
