package com.app.zapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.zapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
