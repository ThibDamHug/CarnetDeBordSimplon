package co.simplon.models;

import co.simplon.errorenum.ErrorMessageEnum;
import lombok.Getter;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Getter
public class ExceptionMessage {
	
	private String code;
	private String message;
	
	public ExceptionMessage(ErrorMessageEnum errorMessageEnum) {
		
		this.code = errorMessageEnum.getCode();
		this.message = errorMessageEnum.getMessage();		
	}
	
}
