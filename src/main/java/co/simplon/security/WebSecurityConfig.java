package co.simplon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import co.simplon.security.rest.configuration.RESTAuthenticationEntryPoint;
import co.simplon.security.rest.configuration.RESTAuthenticationFailureHandler;
import co.simplon.security.rest.configuration.RESTAuthenticationSuccessHandler;
import co.simplon.security.rest.configuration.RESTLogoutSuccessHandler;
/**
 * 
 * @author Franck Pesson
 *
 */
//Previent SpringBoot Security
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired	
	RESTAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	RESTAuthenticationSuccessHandler authenticationsuccessHandler;
	
	@Autowired
	RESTAuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired	
	RESTLogoutSuccessHandler logoutSuccessHandler;
	
	//Override la methode configure
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
	  	.and()	
        	.exceptionHandling()
  				.authenticationEntryPoint(authenticationEntryPoint)
  		.and()
  			.formLogin()
  				.usernameParameter("email")
  				.successHandler(authenticationsuccessHandler)
  				.failureHandler(authenticationFailureHandler)
  		.and()
  			.authorizeRequests()
  			.antMatchers("/api/**").authenticated()
  		.and()
	  		.logout()
	  			.logoutSuccessHandler(logoutSuccessHandler)
  		.and()
  			.csrf()
  			.disable();
	}
}
