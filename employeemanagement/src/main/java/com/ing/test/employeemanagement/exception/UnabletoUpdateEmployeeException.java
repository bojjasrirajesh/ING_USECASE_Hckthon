package com.ing.test.employeemanagement.exception;

public class UnabletoUpdateEmployeeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	
	public UnabletoUpdateEmployeeException(String message) {
		super(message);
		this.message=message;
	}

}
