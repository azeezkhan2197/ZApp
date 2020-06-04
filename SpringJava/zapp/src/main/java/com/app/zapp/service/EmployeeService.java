package com.app.zapp.service;

import java.util.List;

import com.app.zapp.entity.Employee;

public interface EmployeeService {
	
	public Employee getEmployeeById(String id);
	
	public List<Employee> getAllEmployee();
	
	public void addEmployee(Employee employee);
	
	//public void editEmployee(Employee employee);
	
	public void deleteEmployeeById(String id);
	
	public void updateEmployee(Employee employee);
	
	public String getPassword(String id);

}
