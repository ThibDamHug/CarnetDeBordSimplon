package co.simplon.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import co.simplon.security.rest.configuration.RESTAuthenticationEntryPoint;
import co.simplon.security.rest.configuration.RESTAuthenticationSuccessHandler;

//Previent SpringBoot Security
@EnableWebSecurity
@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	
	RESTAuthenticationSuccessHandler successHandler;
	
	@Autowired
	
	RESTAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	//Override la methode configure
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		
		http
        	.exceptionHandling()
  				.authenticationEntryPoint(restAuthenticationEntryPoint)
  		.and()
  			.formLogin()
  				.successHandler(successHandler)
  				.permitAll()
  		.and()
  			.cors()
  		.and()
  			.authorizeRequests()
		//.antMatchers("/users/**").hasAnyAuthority("ROLE_administrateur","ROLE_apprenant","Role_caca")
		//.antMatchers("/roles/**").authenticated()
  			.anyRequest().authenticated()
  		.and()
  			.httpBasic()
  		.and()
  		.logout()
  			.logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler (HttpStatus.OK)))
  			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
  			.deleteCookies("JSESSIONID")
  			.permitAll()
  		.and()
  			.csrf()
  			.disable();
	}
	
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
