package com.app.zapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.zapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
