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
	
	
	@Query("UPDATE  Customer c  SET c.amount = c.amount - :withdrawAmount where c.id = :customerId")
	@Modifying
	@Transactional
	public void  withdrawAmount(@Param("customerId")String customerId,@Param("withdrawAmount")float withdrawAmount);
	
	/*
	 * @Query("UPDATE  Customer c1 JOIN Customer c2  SET c1.amount = c1.amount - :transferAmount   ,   c2.amount = :transferAmount +c2.amount where "
	 * + "c1.id = :customerId1 ,c2.id = :customerId2 ")
	 * 
	 * @Modifying
	 * 
	 * @Transactional public void transferAmount(@Param("customerId1")String
	 * customerId1,@Param("customerId2") String
	 * customerId2,@Param("transferAmount")float transferAmount);
	 */
	
	
}
