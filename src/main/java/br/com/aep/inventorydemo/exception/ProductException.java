package br.com.aep.inventorydemo.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends RuntimeException{

	private static final long serialVersionUID = -7743596026025818874L;
	
	private String mensagem;

	public ProductException(final String message, final String mensagem) {
		super(message);
		this.mensagem = mensagem;
	}
}
