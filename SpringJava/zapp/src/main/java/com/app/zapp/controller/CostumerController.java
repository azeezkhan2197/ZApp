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
	
	

}
