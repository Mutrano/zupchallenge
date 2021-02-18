package com.mutra.zupchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutra.zupchallenge.domain.User;
import com.mutra.zupchallenge.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void insert(User obj) {
		userRepository.save(obj);
	}
}
