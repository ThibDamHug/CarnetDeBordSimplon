package co.simplon.constantes;
/**
 * 
 * @author Abdel Ahmar
 *
 */
public final class UriConstants {
	
	public static final String BASE = "/api";
	public static final String VERSION = "/v1";
	public static final String DIARIES = BASE + VERSION + "/diaries";
	public static final String USERS = BASE + VERSION + "/users";
	public static final String ROLES = BASE + VERSION + "/roles";
	public static final String PROMOS = BASE + VERSION + "/promos";
	public static final String CONCLUSIONS = BASE + VERSION + "/conclusions";
	public static final String QUESTIONS = BASE + VERSION + "/questions";
	public static final String ANSWERS = BASE + VERSION + "/answers";
	
	private UriConstants() {
	}
}
