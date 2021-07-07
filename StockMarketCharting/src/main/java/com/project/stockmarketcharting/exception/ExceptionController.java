package com.project.stockmarketcharting.exception;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = ObjectNotFoundException.class)
	public ResponseEntity<Object> exception(ObjectNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EntityAlreadyExistsException.class)
	public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = UsernameNotFoundException.class)
	public ResponseEntity<Object> usernameNotFoundExceptionexception(UsernameNotFoundException exception) {
		return new ResponseEntity<>("Username not found", HttpStatus.NOT_FOUND);
	}

}
