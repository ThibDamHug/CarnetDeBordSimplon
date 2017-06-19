package co.simplon.restcontrolleradvice;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.simplon.constantes.ErrorMessageEnum;
import co.simplon.constantes.LogConstants;
import co.simplon.exceptions.CustomException;
import co.simplon.models.ExceptionMessage;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@RestControllerAdvice
public class MainRestControllerAdvice {

	private static Logger logger = Logger.getLogger(LogConstants.ADVICE_CONTROLLER);
	
	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionMessage handleCustomException(CustomException exception) {
		logger.log(Level.SEVERE, exception.getMessage());
		return new ExceptionMessage(ErrorMessageEnum.getByCode(exception.getErrorCode()));	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionMessage handleValidation (MethodArgumentNotValidException exception) {
		logger.log(Level.SEVERE, exception.getMessage());
		return new ExceptionMessage(ErrorMessageEnum.VALIDATION);
	}
}
