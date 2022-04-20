package com.qa.baespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	// Get
	@GetMapping("/hello") // localhost:8080/hello
	public String helloWorld() {
		return "Hello world";
	}
	
	// Post
	
	// Put/Patch
	
	// Delete
	
}
