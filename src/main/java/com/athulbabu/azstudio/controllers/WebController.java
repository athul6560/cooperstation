package com.athulbabu.azstudio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/gallery")
	public String gallary() {
		return "gallery";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
