package com.mutra.zupchallenge.services.exceptions;

import com.mutra.zupchallenge.dto.UserDTO;

public class UniquenessException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private UserDTO obj;
	public UniquenessException(UserDTO obj) {
		super("Uniqueness Exception");
		this.obj=obj;
	}
	public UserDTO getObj() {
		return obj;
	}
	public void setObj(UserDTO obj) {
		this.obj = obj;
	}
	
}
