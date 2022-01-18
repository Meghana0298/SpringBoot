package com.bookstore.java.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorStatus> handleException(BookNotFoundException ex) {
		ErrorStatus errorStatus = new ErrorStatus();
		errorStatus.setTime(LocalDateTime.now());
		errorStatus.setMessage(ex.getMessage());
		errorStatus.setResponseCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorStatus>(errorStatus, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorStatus> handleException(UserNotFoundException ex) {
		ErrorStatus errorStatus = new ErrorStatus();
		errorStatus.setTime(LocalDateTime.now());
		errorStatus.setMessage(ex.getMessage());
		errorStatus.setResponseCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorStatus>(errorStatus, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorStatus> handleException(InvalidPasswordException ex) {
		ErrorStatus errorStatus = new ErrorStatus();
		errorStatus.setTime(LocalDateTime.now());
		errorStatus.setMessage(ex.getMessage());
		errorStatus.setResponseCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorStatus>(errorStatus, HttpStatus.NOT_FOUND);
	}
}
