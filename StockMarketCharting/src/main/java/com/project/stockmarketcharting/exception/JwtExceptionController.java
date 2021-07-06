package com.project.stockmarketcharting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JwtExceptionController {

	@ExceptionHandler(value = UsernameNotFoundException.class)
	public ResponseEntity<Object> usernameNotFound(UsernameNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ BadCredentialsException.class, DisabledException.class })
	public ResponseEntity<Object> badCredentialsException(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
	}

}
