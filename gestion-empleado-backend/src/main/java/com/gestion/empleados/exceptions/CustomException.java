package com.gestion.empleados.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

	
	public HttpStatus getStatus() {
		return status;
	}



	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	
	public CustomException(HttpStatus status,String message) {
		super(message);
		this.status = status;
	}
	
	
}
