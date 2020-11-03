package de.tekup.gca.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}admin").roles("ADMIN","USER","DIRECTEUR").and()
		.withUser("user").password("{noop}user").roles("USER").and()
		.withUser("directeur").password("{noop}directeur").roles("USER","DIRECTEUR");
		
	}
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin();
		http.authorizeRequests().antMatchers("/api/user/addUser", "/api/conge/*", "/api/absence/*").hasRole("USER");
		http.authorizeRequests().antMatchers("/api/reclamation/addReclamation").hasRole("USER");
		http.authorizeRequests().antMatchers("/api/message/addMessage").hasRole("USER");
		
		http.authorizeRequests().antMatchers("/api/user/addUser", "/api/conge/*", "/api/absence/*").hasRole("DIRECTEUR");
		http.authorizeRequests().antMatchers("/api/reclamation/list", "/findReclamation","/findReclamationsById","/reclamationResponse")
		.hasRole("DIRECTEUR");
		
		http.authorizeRequests().antMatchers("/**").permitAll();
		
	}
}
