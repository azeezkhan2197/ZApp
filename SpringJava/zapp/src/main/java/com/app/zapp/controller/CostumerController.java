package com.app.zapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.zapp.entity.Customer;
import com.app.zapp.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CostumerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value="/customers",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomer()
	{
		 return customerService.findAll();
	}
	
	@GetMapping(value="/customers/{customerId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerById(@PathVariable String customerId)
	{
		 return customerService.findById(customerId);
	}
	
	@PostMapping(value="/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
	}
	
	@PutMapping(value="/customers")
	public void editCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}
	
	@DeleteMapping(value="/customers/{id}")
	public void deleteCustomer(@PathVariable String id) {
		customerService.deleteById(id);
	}
	
	@GetMapping(value="/customers/password/{id}")
	public String getPassword(@PathVariable String id) {
		return customerService.getPassword(id);
	}
	
	@PutMapping(value="/customers/{id}/{amount}")
	public void depositAmount(@PathVariable String id, @PathVariable String amount)
	{
		System.out.println("amount in controller is "+amount);
		String floatAmount = amount.substring(0,amount.length());
		customerService.depositAmount(id, Float.parseFloat(floatAmount));
		
	}
	
	@PutMapping(value="/customers/{id1}/{id2}/{amount}")
	public void transferAmount(@PathVariable String id1,@PathVariable String id2,@PathVariable String amount ) {
		//String customerId2 = id2.substring(0,amount.length());
		String transferedAmount = amount.substring(0,amount.length());
		customerService.transferAmount(id1, id2,Float.parseFloat(transferedAmount));
	}

}
