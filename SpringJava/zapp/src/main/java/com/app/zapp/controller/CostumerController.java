package com.app.zapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.zapp.entity.Customer;
import com.app.zapp.service.CustomerService;

@RestController
public class CostumerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value="/customers",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomer()
	{
		 return customerService.findAll();
	}
	
	@GetMapping(value="/customer/{customerId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerById(@PathVariable String customerId)
	{
		 return customerService.findById(customerId);
	}
	
	@PostMapping(value="/customer")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
	}
	
	@PutMapping(value="/customer")
	public void editCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable String id) {
		customerService.deleteById(id);
	}
	

}
