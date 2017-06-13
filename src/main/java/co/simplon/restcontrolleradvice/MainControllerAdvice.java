package co.simplon.restcontrolleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.simplon.constantes.ErrorMessageEnum;
import co.simplon.exceptions.CustomException;
import co.simplon.models.ExceptionMessage;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@RestControllerAdvice
public class MainControllerAdvice {
	
	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionMessage handleCustomException(CustomException exception) {
		return new ExceptionMessage(ErrorMessageEnum.getByCode(exception.getErrorCode()));	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionMessage handleValidation (MethodArgumentNotValidException exception) {
		return new ExceptionMessage(ErrorMessageEnum.VALIDATION);
	}
}
