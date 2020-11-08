package com.cg.inventorystockmanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		ErrorResponse error = new ErrorResponse(404,"Error Message");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(error);
	}

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorResponse> handleInvalidCredential(InvalidDataException ex) {
		ErrorResponse errorResponse = new ErrorResponse(123, "message");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(errorResponse);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleInvalidStatus(EntityNotFoundException ex) {	
		ErrorResponse errorResponse = new ErrorResponse(123, "message");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(errorResponse);
	}
	

}
