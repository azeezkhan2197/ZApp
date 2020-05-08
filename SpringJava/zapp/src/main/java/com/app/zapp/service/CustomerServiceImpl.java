package com.app.zapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.zapp.dao.CustomerRepository;
import com.app.zapp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(String id) {
		Optional<Customer> result = customerRepository.findById(id);

		Customer theCustomer = null;

		if (result.isPresent()) {
			theCustomer = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Customer id - " + id);
		}

		return theCustomer;

	}

	@Override
	public void save(Customer customer) {
		customer.setId("0");
		customerRepository.save(customer);
	}

	@Override
	public void deleteById(String id) {
		Optional<Customer> result = customerRepository.findById(id);

		Customer theCustomer = null;

		if (result.isPresent()) {
			theCustomer = result.get();
			customerRepository.delete(theCustomer);
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Customer id - " + id);
		}


	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	/*
	 * @Override public void editCustomer(Customer customer) { Optional<Customer>
	 * result = customerRepository.findById(customer.getId()); Customer theCustomer
	 * = result.get(); theCustomer.setAmount(customer.getAmount());
	 * theCustomer.setDob(customer.getDob());
	 * theCustomer.setEmail(customer.getEmail());
	 * theCustomer.setFirstName(customer.getFirstName());
	 * theCustomer.setGender(customer.getGender());
	 * theCustomer.setLastName(customer.getLastName());
	 * theCustomer.setPassword(customer.getPassword());
	 * theCustomer.setPhoneNumber(customer.getPhoneNumber());
	 * customerRepository.save(theCustomer);
	 * 
	 * }
	 */

}
