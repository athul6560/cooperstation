package com.athulbabu.azstudio.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.athulbabu.azstudio.model.orderDetails;


public interface order_dao extends JpaRepository<orderDetails, Integer> {
	
	List<orderDetails> findAllByEmail(String user_email);
	
	orderDetails findById(int order_id);
	
	
}
