package com.qa.baespring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.baespring.domain.User;
import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {

	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	// Get By ID (get one User)
	public User getById(long id) {
		return repo.findById(id).get(); //.get() will either get the User (if exists) OR throw NoSuchElementException
	}
	
	// Get ALL users
	public List<User> getAll() {
		return repo.findAll();
	}
	
	// Create a new user
	public User create(User user) {
		return repo.saveAndFlush(user);
	}
	
	// Update a user
	public User update(long id, User user) {
		User existing = repo.findById(id).get(); // Get the EXISTING user
		existing.setFirstName(user.getFirstName()); // Change EXISTING user's first name to new user's first name.
		existing.setLastName(user.getLastName()); // Change EXISTING user's last name to new user's last name.
		existing.setUsername(user.getUsername()); // Change EXISTING user's username to new user's username.
		return repo.saveAndFlush(existing);
	}

	// Delete a user
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
}
