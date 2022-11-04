package br.com.aep.inventorydemo.exception;

import org.springframework.http.HttpStatus;

public class ProviderException extends RuntimeException{

	private static final long serialVersionUID = -7743596026025818874L;
	
	private String errorMessage;

	public ProviderException(final String message, final String errorMessage) {
		super(message);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
