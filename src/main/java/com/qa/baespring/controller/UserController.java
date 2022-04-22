package com.qa.baespring.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.baespring.domain.User;
import com.qa.baespring.exceptions.UserNotFoundException;
import com.qa.baespring.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	private UserService service;
	
	public UserController(UserService service) { 
		this.service = service;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
	}
	
	// Get by ID (get one User)
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getById(@PathVariable long id) {
		return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
		
// Exception handling example (if getById() throws the exception here)
//		try {
//			return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
//		} catch (UserNotFoundException e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
	}
	
	// Get by Username (get one User)
	@GetMapping("/getByUsername/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable String username) {
		return new ResponseEntity<User>(service.getByUsername(username), HttpStatus.OK);
	}
	
	// Post
	@PostMapping("/create") // localhost:8080/create
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}
	
	// Put
	@PutMapping("/update/{id}") // localhost:8080/update/id
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
		return new ResponseEntity<User>(service.update(id, user), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}") //localhost:8080/delete/id
	public ResponseEntity<?> delete(@PathVariable long id) {
		return (service.delete(id))? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Delete without Ternary If
//	@DeleteMapping("/delete/{id}") //localhost:8080/delete/id
//	public ResponseEntity<?> delete(@PathVariable long id) {
//		if (service.delete(id) == true) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} else {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}	
//	}
}