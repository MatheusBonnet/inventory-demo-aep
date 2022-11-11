package br.com.aep.inventorydemo.exception;

import org.springframework.http.HttpStatus;

public class EmployeeException extends RuntimeException {

    private static final long serialVersionUID = -7743596026025818874L;

    private String errorMessage;

    public EmployeeException(final String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
