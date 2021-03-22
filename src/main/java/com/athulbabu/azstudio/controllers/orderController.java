package com.athulbabu.azstudio.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.athulbabu.azstudio.dao.order_dao;
import com.athulbabu.azstudio.dao.product_dao;
import com.athulbabu.azstudio.model.changeStatusModel;
import com.athulbabu.azstudio.model.orderDetails;
import com.athulbabu.azstudio.model.orderDetailsProduct;
import com.athulbabu.azstudio.model.product;
import com.athulbabu.azstudio.model.responseModel;

@RestController
public class orderController {

	@Autowired
	private order_dao orderdao;

	@Autowired
	private product_dao productdao;

	private product productdatas;

	@PostMapping("/order")
	public List<orderDetails> order(@RequestBody List<orderDetails> order) {
		List<orderDetails> response = orderdao.saveAll(order);
		return response;
	}

	@GetMapping("/order/{email}")
	public List<orderDetailsProduct> getorder(@PathVariable("email") String email) {
		List<orderDetailsProduct> fulldata = new ArrayList<orderDetailsProduct>();
		List<orderDetails> data = orderdao.findAllByEmail(email);
		for (int i = 0; i < data.size(); i++) {
			orderDetailsProduct product = new orderDetailsProduct();
			product.setAddress(data.get(i).getAddress());
			product.setEmail(data.get(i).getEmail());
			product.setOrderid(data.get(i).getOrderid());
			product.setOrder_status(data.get(i).getOrder_status());
			product.setUser_id(data.get(i).getUser_id());
			product.setAddress(data.get(i).getAddress());
			product.setPin_number(data.get(i).getPin_number());
			product.setProduct_id(data.get(i).getProduct_id());
			product.setPhone_number(data.get(i).getPhone_number());

			productdatas = productdao.findByTitle(data.get(i).getProduct_id());
			product.setImagea(productdatas.getImagea());
			product.setRate(String.valueOf(productdatas.getRate()));
			product.setName(productdatas.getProduct_name());
			fulldata.add(product);
		}
		return fulldata;

	}

	@GetMapping("/order/getallorder")
	public List<orderDetailsProduct> getallorder() {
		List<orderDetailsProduct> fullorder = new ArrayList<orderDetailsProduct>();
		List<orderDetails> data = orderdao.findAll();
		for (int i = 0; i < data.size(); i++) {
			orderDetailsProduct product = new orderDetailsProduct();
			product.setAddress(data.get(i).getAddress());
			product.setEmail(data.get(i).getEmail());
			product.setOrderid(data.get(i).getOrderid());
			product.setOrder_status(data.get(i).getOrder_status());
			product.setUser_id(data.get(i).getUser_id());
			product.setAddress(data.get(i).getAddress());
			product.setPin_number(data.get(i).getPin_number());
			product.setProduct_id(data.get(i).getProduct_id());
			product.setPhone_number(data.get(i).getPhone_number());

			productdatas = productdao.findByTitle(data.get(i).getProduct_id());
			product.setImagea(productdatas.getImagea());
			product.setRate(String.valueOf(productdatas.getRate()));
			product.setName(productdatas.getProduct_name());
			fullorder.add(product);
		}

		return fullorder;

	}

	@PostMapping("/order/changestatus")
	public responseModel changestatus(changeStatusModel changestatus) {

		responseModel response = new responseModel();
		orderDetails order = orderdao.findById(changestatus.getOrderid());
		try {
			
			order.setOrder_status(changestatus.getOrder_status());
			orderdao.save(order);
			response.setMessage("success");
			response.setStatus(true);
		} catch (Exception e) {
			response.setMessage("error" + e);
			response.setStatus(false);
		}
		return response;
	}
}
