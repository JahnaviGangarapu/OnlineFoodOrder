package com.onlinefoodorder.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {
	
	@GetMapping("/test")
	public String login() {
		
		return "Test String";
	}

}
