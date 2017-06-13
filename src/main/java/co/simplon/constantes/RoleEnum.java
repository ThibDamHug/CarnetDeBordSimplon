package co.simplon.constantes;

import lombok.Getter;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Getter
public enum RoleEnum {
	
	/**
	 * apprenant
	 */
	STUDENT("apprenant"),
	/**
	 * tuteur
	 */
	TUTOR("tuteur"),
	/**
	 * formateur
	 */
	TEACHER("formateur"),
	/**
	 * administrateur
	 */
	ADMIN("administrateur");
	
	private String name;
	
	private RoleEnum(String name) {
		this.name= name;
	}
}
