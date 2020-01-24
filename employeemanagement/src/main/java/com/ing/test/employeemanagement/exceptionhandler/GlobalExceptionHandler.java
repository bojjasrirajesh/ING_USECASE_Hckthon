package com.ing.test.employeemanagement.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ing.test.employeemanagement.exception.ErrorResponse;
import com.ing.test.employeemanagement.exception.ResourceNotFoundException;
import com.ing.test.employeemanagement.exception.UnabletoUpdateEmployeeException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException ex) {
        
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessgage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setDateAndTime(LocalDateTime.now());
		
		/*
		 * ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(), "EM404ID",
		 * LocalDateTime.now());
		 */
		
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(UnabletoUpdateEmployeeException.class)
    public ResponseEntity<ErrorResponse> unabletoUpdateEmployeeException(UnabletoUpdateEmployeeException ex) {
        
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessgage(ex.getMessage());
		errorResponse.setStatusCode(400);
		errorResponse.setDateAndTime(LocalDateTime.now());
		
		/*
		 * ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(), "EM404ID",
		 * LocalDateTime.now());
		 */
		
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

}
