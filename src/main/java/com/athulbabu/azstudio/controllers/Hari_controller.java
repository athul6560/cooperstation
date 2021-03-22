package com.athulbabu.azstudio.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.athulbabu.azstudio.dao.hari_dao;
import com.athulbabu.azstudio.model.hari;



@RestController
public class Hari_controller {
	
	@Autowired
	private hari_dao hari_daoo;
	
	@GetMapping("/hari/{user_id}")
	public String order(@PathVariable("user_id") int user_id) {
		hari response = hari_daoo.findById(user_id);
		return response.getValue();
	}
	@GetMapping("/hari/update/{user_id}")
	public String update(@PathVariable("user_id") int user_id) {
		hari response = hari_daoo.findById(user_id);
	
		if(response.getValue().equals("1")) {
			
			response.setValue("0");
		}else {
			
			response.setValue("1");
		}
		hari_daoo.save(response);
		return response.getValue();
	}

}
