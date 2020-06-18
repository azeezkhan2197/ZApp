package com.app.zapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.zapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	@Query("SELECT c.password from Customer c where c.id = :customerId")
	public String getPassword(@Param("customerId")String id);
	
	
	@Query("UPDATE  Customer c  SET c.amount = :depositAmount + c.amount where c.id = :customerId")
	@Modifying
	@Transactional
	public void  depositAmount(@Param("customerId")String customerId,@Param("depositAmount")float depositAmount);
	
	
	
	
}
