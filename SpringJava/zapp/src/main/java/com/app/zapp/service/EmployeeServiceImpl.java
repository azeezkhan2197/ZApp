package com.app.zapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.zapp.dao.EmployeeRepository;
import com.app.zapp.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(String id) {
		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}

		return theEmployee;

	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();

	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployeeById(String id) {
		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
			employeeRepository.delete(theEmployee);
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}

	}

	@Override
	public void editEmployee(Employee employee) {
		Optional<Employee> result = employeeRepository.findById(employee.getId());
		Employee theEmployee = result.get();
		theEmployee.setDob(employee.getDob());
		theEmployee.setEmail(employee.getEmail());
		theEmployee.setFirstName(employee.getFirstName());
		theEmployee.setGender(employee.getGender());
		theEmployee.setLastName(employee.getLastName());
		theEmployee.setPassword(employee.getPassword());
		theEmployee.setPhone(employee.getPhone());
		theEmployee.setRole(employee.getRole());
		theEmployee.setSalary(employee.getSalary());
		employeeRepository.save(theEmployee);
		
	}

}
