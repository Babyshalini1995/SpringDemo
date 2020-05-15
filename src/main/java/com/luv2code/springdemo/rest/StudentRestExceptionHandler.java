package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//Add exception handleer
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
	
		//create student error response
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		
		//return error repsone
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//exception handler to catch other signatures
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		//create student error response
				StudentErrorResponse error = new StudentErrorResponse();
				
				error.setMessage(e.getMessage());
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				error.setTimestamp(System.currentTimeMillis());
				
				//return error repsone
				
				return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}


}
