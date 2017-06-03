package co.simplon.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.simplon.models.Role;
import co.simplon.models.User;
import co.simplon.services.UserService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	UserService service;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			// Besoin pour le ManytoMany en Lazy
			@Transactional
			@Override
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				User user = service.findByEmail(email);
				if (user != null) {
					return new User2(user.getEmail(), user.getPassword(), true, true, true, true,
							getAuthorities(user.getRole()));
				} else {
					throw new UsernameNotFoundException("Impossible de trouver le compte :" + email + ".");
				}
			}
		};
	}

	// Creation d'un collection d'autorisation a partir d'une liste de role
	private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
		String ROLE_PREFIX = "ROLE_";
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getName()));
		return authorities;
	}
}
