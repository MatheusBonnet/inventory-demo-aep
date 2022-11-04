package br.com.aep.inventorydemo.exception;

import org.springframework.http.HttpStatus;

public class EmployeeException extends RuntimeException{

	private static final long serialVersionUID = -7743596026025818874L;

	public EmployeeException(final String message) {
		super(message);

	}
}
