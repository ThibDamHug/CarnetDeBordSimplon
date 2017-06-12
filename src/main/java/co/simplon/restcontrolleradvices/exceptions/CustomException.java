package co.simplon.restcontrolleradvices.exceptions;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = -5525123157067737147L;
	
	private String errorCode;
	
	public CustomException(String errorMessage, String errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

}
