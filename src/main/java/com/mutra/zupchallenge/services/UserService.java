package com.mutra.zupchallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mutra.zupchallenge.domain.User;
import com.mutra.zupchallenge.dto.UserDTO;
import com.mutra.zupchallenge.repositories.UserRepository;
import com.mutra.zupchallenge.services.exceptions.ResourceNotFoundException;
import com.mutra.zupchallenge.services.exceptions.UniquenessException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Transactional()
	public User insert(UserDTO dto) {
		User user = fromDTO(dto);
		try {
			return userRepository.save(user);
		}
		catch(DataIntegrityViolationException e) {
			throw new UniquenessException(dto);
		}
		
	}
	
	@Transactional(readOnly = true)
	public User findByEmail(String email) {
		Optional<User> obj = userRepository.findByEmail(email);
		return obj.orElseThrow(    () -> new ResourceNotFoundException(email));
	}
	public User fromDTO(UserDTO dto) {
		User user = new User(dto.getId(), dto.getName(), dto.getEmail(), dto.getCpf(), dto.getDateOfBirth());
		return user;
	}
}
