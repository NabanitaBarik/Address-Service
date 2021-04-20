package com.capgemini.greatoutdoors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(AddressIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleExceptionById(AddressIdNotFoundException e) {
		ErrorMessage error = new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMsg(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	

	@ExceptionHandler(AreaNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleExceptionById(AreaNotFoundException e) {
		ErrorMessage error = new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMsg(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}
