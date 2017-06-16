package co.simplon.restcontrolleradvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.simplon.constantes.ErrorMessageEnum;
import co.simplon.constantes.LogConstants;
import co.simplon.exceptions.CustomException;
import co.simplon.exceptions.CustomLogger;
import co.simplon.models.ExceptionMessage;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@RestControllerAdvice
public class MainControllerAdvice {
	
	@Autowired
	CustomLogger log;
	
	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionMessage handleCustomException(CustomException exception) {
		log.authLog(LogConstants.ADVICE_SERVICE, new Object().getClass().getEnclosingMethod().getName());
		return new ExceptionMessage(ErrorMessageEnum.getByCode(exception.getErrorCode()));	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionMessage handleValidation (MethodArgumentNotValidException exception) {
		log.authLog(LogConstants.ADVICE_SERVICE, new Object().getClass().getEnclosingMethod().getName());
		return new ExceptionMessage(ErrorMessageEnum.VALIDATION);
	}
}
