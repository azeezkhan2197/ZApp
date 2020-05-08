package com.app.zapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.zapp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
