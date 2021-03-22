package com.athulbabu.azstudio.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.athulbabu.azstudio.dao.product_dao;
import com.athulbabu.azstudio.model.product;

@RestController
public class productController {
	
	@Autowired
	private product_dao productdao;

	
	
	
	@GetMapping("/getproduct/{title}")
	public product getorder(@PathVariable("title") String title ) {
		product data= productdao.findByTitle(title);
	return data;

	}
}
