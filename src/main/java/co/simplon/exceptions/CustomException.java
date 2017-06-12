package co.simplon.exceptions;

import co.simplon.errorenum.ErrorMessageEnum;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = -5525123157067737147L;	
	
	private final String errorCode;
	
	public CustomException(ErrorMessageEnum error) {
		super(error.getMessage());
		this.errorCode = error.getCode();
	}

}
