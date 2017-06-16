package co.simplon.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomLogger.class);
	
	public void authLog(String serviceName, String methode) {
		logger.error("*** erreur sur le service" + serviceName + "et sur la methode" + methode);
	}
	
	
}
