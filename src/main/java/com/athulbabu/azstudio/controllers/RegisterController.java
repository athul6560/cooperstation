package com.athulbabu.azstudio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athulbabu.azstudio.dao.pin_dao;
import com.athulbabu.azstudio.dao.user_Dao;
import com.athulbabu.azstudio.model.MailModel;
import com.athulbabu.azstudio.model.pinSubmitModel;
import com.athulbabu.azstudio.model.responseModel;
import com.athulbabu.azstudio.model.user;
import com.athulbabu.azstudio.service.AwsSNSClient;

@RestController
public class RegisterController {
	@Autowired
	private user_Dao repo;

	@Autowired
	private pin_dao pindao;

	@Autowired
	public JavaMailSender javaMailSender;

	int pin;

	user user;

	@PostMapping("/sentmail")
	public responseModel sentmail(String email) {
		responseModel responseModel = new responseModel();
		if (repo.findByEmail(email) == null) {
			responseModel.setMessage("Enter the pin from email");
			responseModel.setStatus(true);
			try {
				sendEmail(email);
			} catch (Exception e) {
				responseModel.setMessage("Pin Already send");
				responseModel.setStatus(false);
				return responseModel;
			}
			return responseModel;
		} else {
			responseModel.setMessage("User Already Exist");
			responseModel.setStatus(false);
			return responseModel;
		}

	}

	@PostMapping("/sentsms")
	public String sent(MailModel product) {

		AwsSNSClient myclient = new AwsSNSClient();
		myclient.sendsms("Thank you for purchasing "+product.getProduct(), product.getNumber());
		return "success";
	}

	@PostMapping("/user")
	public responseModel adduser(user user) {
		responseModel responseModel = new responseModel();

		if (repo.findByEmail(user.getUser_email()) == null) {

			repo.save(user);

			responseModel.setStatus(true);
			responseModel.setMessage("Registered");
			pindao.deleteByEmail(user.getUser_email());
			return responseModel;
		} else {
			responseModel.setStatus(false);
			pindao.deleteByEmail(user.getUser_email());
			responseModel.setMessage("User Already Exist");
			return responseModel;
		}

	}

	@PostMapping("/pinverify")
	public responseModel verifyPin(pinSubmitModel pinsubmit) {
		responseModel responseModel = new responseModel();
		pinSubmitModel dbvalue = pindao.findByEmail(pinsubmit.getEmail());
		if (dbvalue == null) {
			responseModel.setStatus(false);
			responseModel.setMessage("Mail Not Sent");
			return responseModel;
		} else {
			if (pinsubmit.getEmail().equals(dbvalue.getEmail()) && pinsubmit.getPinnumber() == dbvalue.getPinnumber()) {
				responseModel.setStatus(true);
				responseModel.setMessage("Valid Pin");
				return responseModel;
			} else {
				responseModel.setStatus(false);
				responseModel.setMessage("Wrong Pin");
				return responseModel;

			}

		}

	}

	public void sendEmail(String email) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Pin Number");
		pin = (int) getRandomNumber();
		pinSubmitModel pinemail = new pinSubmitModel();
		pinemail.setEmail(email);
		pinemail.setPinnumber(pin);
		pindao.save(pinemail);
		message.setText("Use this pin " + pin);
		javaMailSender.send(message);
	}

	public static double getRandomNumber() {
		double x = Math.floor(100000 + Math.random() * 900000);
		return x;
	}

}
