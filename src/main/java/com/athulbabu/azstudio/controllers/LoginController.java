package com.athulbabu.azstudio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athulbabu.azstudio.dao.user_Dao;
import com.athulbabu.azstudio.model.LoginModel;
import com.athulbabu.azstudio.model.responseModel;
import com.athulbabu.azstudio.model.user;

@RestController
public class LoginController {

	@Autowired
	private user_Dao repo;

	@PostMapping("/login")
	public responseModel login(LoginModel login) {
		responseModel responseModel = new responseModel();
		try {
			
			if (repo.findByEmail(login.getEmail() )== null) {
				responseModel.setMessage("Not Registered");
				responseModel.setStatus(false);
				return responseModel;
			} else {
				user user=repo.findByEmail(login.getEmail());
				if (user.getUser_password().equals(login.getPassword())) {
					responseModel.setMessage("Success");
					responseModel.setStatus(true);
					return responseModel;
				} else {
					responseModel.setMessage("Wrong Email/Password");
					responseModel.setStatus(false);
					return responseModel;
				}
			}
		} catch (Exception e) {
			responseModel.setMessage("Network Error");
			responseModel.setStatus(false);
			return responseModel;
		}

	}
}
