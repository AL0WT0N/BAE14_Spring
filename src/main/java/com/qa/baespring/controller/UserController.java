package com.qa.baespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.User;
import com.qa.baespring.service.UserService;

@RestController
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	// Get by ID (get one User)
	@GetMapping("/getById/{id}") // localhost:8080/getById/id
	public User getById(@PathVariable long id) {
		return service.getById(id);
	}
	
//	@GetMapping("/getAll") // localhost:8080/getAll
	
	// Post
	
	// Put/Patch
	
	// Delete
	
}
