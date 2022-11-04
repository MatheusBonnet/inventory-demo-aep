package br.com.aep.inventorydemo.exception;

import org.springframework.http.HttpStatus;

public class CategoryException extends RuntimeException{

	private static final long serialVersionUID = -7743596026025818874L;
	
	private String messages;

	public CategoryException(final String message, final String messages) {
		super(message);
		this.messages = messages;
	}

	public String getMessages() {
		return messages;
	}
}
