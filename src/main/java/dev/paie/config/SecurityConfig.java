package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Classe de configuration de Spring Security
 * 
 * @author Sandra Le Thiec
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/mvc/connexion").permitAll()
		.antMatchers("/bootstrap-3.3.7-dist/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/mvc/connexion")
		/*.defaultSuccessUrl("/mvc/employes/lister")*/;
		
	}
	
	
	

}
