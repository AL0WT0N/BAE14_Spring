package com.qa.baespring.service;

import org.springframework.stereotype.Service;

import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {

	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	
	
}
