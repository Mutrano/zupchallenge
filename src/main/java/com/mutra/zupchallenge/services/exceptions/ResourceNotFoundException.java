package com.mutra.zupchallenge.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(Object email) {
		super("Email:" +email+" não encontrado no sistema");
	}
}
