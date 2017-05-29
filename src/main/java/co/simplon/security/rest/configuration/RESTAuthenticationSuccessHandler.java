package co.simplon.security.rest.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * An authentication success handler implementation adapted to a REST approach.
 */

@Component
public class RESTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		// response.setStatus(HttpServletResponse.SC_OK);
		// clearAuthenticationAttributes(request);
		// ca marche pour l'instant
		response.sendRedirect(request.getHeader("referer"));
	}
}
