package com.qa.baespring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.baespring.domain.User;
import com.qa.baespring.exceptions.UserNotFoundException;
import com.qa.baespring.exceptions.UserNotFoundExceptionWithID;
import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {

	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	
	// Get ALL users
	public List<User> getAll() {
		return repo.findAll();
	}
	
	// Get By ID (get one User) 
	// This could also have: throws UserNotFoundException in the signature, to throw this exception up to Controller.
	public User getById(long id) {
//		return repo.findById(id).get(); //.get() will either get the User (if exists) OR throw NoSuchElementException
//		return repo.findById(id).orElseThrow(() -> new UserNotFoundExceptionWithID(id));
		return repo.findById(id).orElseThrow(UserNotFoundException::new);

// Exception handling example for handling the exeception here.
//		try {
//			return repo.findById(id).orElseThrow(UserNotFoundException::new);
//		} catch (UserNotFoundException e){
//			System.out.println(e.getMessage());
//			return null;
//		}
	}

	// Get By Username (get one User)
	public User getByUsername(String username) {
		return repo.findByUsername(username).get();
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
