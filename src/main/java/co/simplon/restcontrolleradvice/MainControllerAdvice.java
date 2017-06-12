package co.simplon.restcontrolleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.simplon.errorenum.ErrorMessageEnum;
import co.simplon.exceptions.CustomException;
import co.simplon.models.ExceptionMessage;

@RestControllerAdvice
public class MainControllerAdvice {
	
	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionMessage handleCustomException(CustomException exception) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(
											ErrorMessageEnum.getByCode(exception.getErrorCode())
											);	
		return exceptionMessage;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionMessage handleValidation (MethodArgumentNotValidException exception) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(ErrorMessageEnum.VALIDATION);		
		
		return exceptionMessage;
	}
	
	
}
