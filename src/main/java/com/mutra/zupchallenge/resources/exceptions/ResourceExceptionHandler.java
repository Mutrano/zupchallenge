package com.mutra.zupchallenge.resources.exceptions;

import java.time.Instant;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mutra.zupchallenge.domain.User;
import com.mutra.zupchallenge.repositories.UserRepository;
import com.mutra.zupchallenge.services.exceptions.ResourceNotFoundException;
import com.mutra.zupchallenge.services.exceptions.UniquenessException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@Autowired
	UserRepository userRepository;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validationException(MethodArgumentNotValidException e, HttpServletRequest request) {
		String error = "Erro de validação";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError err = new ValidationError(Instant.now(), status.value(),error, "Cheque novamente os dados de entrada", request.getRequestURI());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}		
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(UniquenessException.class)
	public ResponseEntity<ValidationError> constraint(UniquenessException e, HttpServletRequest request) {
		String error = "Erro no banco de dados";
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError err = new ValidationError(Instant.now(), status.value(),error, "Cheque novamente os dados de entrada", request.getRequestURI());
		
		Optional<User> aux1=userRepository.findByEmail(e.getObj().getEmail());
		Optional<User> aux2=userRepository.findByCpf(e.getObj().getCpf());
		aux1.ifPresent((x) -> err.addError("email", "E-mail já cadastrado no sistema"));
		aux2.ifPresent((x) -> err.addError("cpf", "CPF já cadastrado no sistema")); 
		
		return ResponseEntity.status(status).body(err);
	}	

}
