package co.simplon.constantes;
/**
 * 
 * @author Abdel Ahmar
 *
 */
public class SecurityRoleConstants {
	
	public static final String TEACHER = "hasRole('ROLE_formateur')";
	public static final String TUTOR = "hasRole('ROLE_tuteur')";
	public static final String STUDENT = "hasRole('ROLE_apprenant')";
	public static final String ADMIN = "hasRole('ROLE_administrateur')";
	
	private SecurityRoleConstants() {
	}
}
