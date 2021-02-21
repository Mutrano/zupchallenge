package com.mutra.zupchallenge.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mutra.zupchallenge.domain.User;
import com.mutra.zupchallenge.dto.UserDTO;
import com.mutra.zupchallenge.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UserDTO dto){
		User user = userService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
