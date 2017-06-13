package co.simplon.errorenum;

import lombok.Getter;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Getter
public enum ErrorMessageEnum {	
	/**
	 * VALIDATION : 0101
	 */
	VALIDATION("0101", "Problème de valdiation des champs en entrée"),
	/**
	 * CREATION : 0201
	 */
	CREATION("0201", "Problème lors de la création de l'entité"),
	/**
	 * UPDATE : 0202
	 */
	UPDATE("0202", "Problème lors de la mise à jour de l'entité"),
	/**
	 * FETCH : 0203
	 */
	FETCH("0203", "Problème lors de la récupération des entités");
	
	private String code;
	private String message;
	
	private ErrorMessageEnum(String code, String message) {		
		this.code = code;
		this.message = message;		
	}
	
	public static ErrorMessageEnum getByCode (String code) {
		
		ErrorMessageEnum result = null;
		
		for (ErrorMessageEnum errorMessage : ErrorMessageEnum.values()) {
			if (errorMessage.getCode().equals(code)) {
				result = errorMessage;
				break;
			}
		}		
		return result;
	}
}
