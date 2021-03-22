package com.athulbabu.azstudio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athulbabu.azstudio.model.hari;



public interface hari_dao extends JpaRepository<hari, Integer> {
	hari findById(int hari_id);
}
