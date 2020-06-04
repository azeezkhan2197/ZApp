package com.app.zapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.zapp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	@Query("SELECT e.password from Employee e where e.id =:employeeId")
	public String getPassword(@Param("employeeId") String id );
}
