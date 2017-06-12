package co.simplon.restcontrolleradvices.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.simplon.restcontrolleradvices.exceptions.CustomException;
import co.simplon.restcontrolleradvices.models.ExceptionMessage;

@RestControllerAdvice
public class MainControllerAdvice {
	
	@ExceptionHandler(CustomException.class)
	public ExceptionMessage handleCustomException(CustomException exception) {
		ExceptionMessage exceptionMessage = new ExceptionMessage();
		exceptionMessage.setErrorCode(exception.getErrorCode());
		exceptionMessage.setErrorMessage(exception.getMessage());
		
		return exceptionMessage;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionMessage handleValidation (MethodArgumentNotValidException exception) {
		ExceptionMessage exceptionMessage = new ExceptionMessage();
		exceptionMessage.setErrorCode("0132");
		exceptionMessage.setErrorMessage("test erreur de validation");
		
		return exceptionMessage;
	}
	
	
}
