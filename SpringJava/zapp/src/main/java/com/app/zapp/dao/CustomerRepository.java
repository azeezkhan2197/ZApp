package com.app.zapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.zapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	@Query("SELECT c.password from Customer c where c.id = :customerId")
	String getPassword(@Param("customerId")String id);
	
	@Modifying
	@Query("UPDATE  Customer c  SET c.amount = :depositAmount + c.amount where c.id = :customerId")
	void depositAmount(@Param("customerId")String customerId,@Param("depositAmount")float depositAmount);
	
	
}
