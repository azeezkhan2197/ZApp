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
import org.springframework.web.bind.annotation.RestController;

import com.app.zapp.entity.Employee;
import com.app.zapp.service.CustomerService;
import com.app.zapp.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping(value="/employees",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployee()
	{
		 return employeeService.getAllEmployee();
	}
	
	@GetMapping(value="/employees/{empId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable String empId)
	{
		 return employeeService.getEmployeeById(empId);
	}
	
	@PostMapping(value="/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@PutMapping(value="/employees")
	public void editEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping(value="/employees/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployeeById(id);
	}
	
	@GetMapping(value="/employees/password/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPassword(@PathVariable String id) {
		return employeeService.getPassword(id);
	}
	
}
