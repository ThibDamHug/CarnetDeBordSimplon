package co.simplon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import co.simplon.security.rest.configuration.RESTAuthenticationEntryPoint;
import co.simplon.security.rest.configuration.RESTAuthenticationFailureHandler;
import co.simplon.security.rest.configuration.RESTAuthenticationSuccessHandler;
import co.simplon.security.rest.configuration.RESTLogoutSuccessHandler;

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
        	.exceptionHandling()
  				.authenticationEntryPoint(authenticationEntryPoint)
  		.and()
  			.formLogin()
  				.successHandler(authenticationsuccessHandler)
  				.failureHandler(authenticationFailureHandler)
  				.permitAll()
  		.and()
  			.authorizeRequests()
		//.antMatchers("/users/**").hasAnyAuthority("ROLE_administrateur","ROLE_apprenant","Role_caca")
		//.antMatchers("/roles/**").authenticated()
  			.anyRequest().authenticated()
  		.and()
  			.httpBasic()
  		.and()
  		.logout()
  			.logoutSuccessHandler(logoutSuccessHandler)
  			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
  			.deleteCookies("JSESSIONID")
  			.permitAll()
  		.and()
  			.csrf()
  			.disable();
	}
}
