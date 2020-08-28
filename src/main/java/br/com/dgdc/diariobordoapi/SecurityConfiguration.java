package br.com.dgdc.diariobordoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.dgdc.diariobordoapi.domain.service.DiarioUserDetailsService;

//TODO TIRAR COMENTARIOS PARA HABILITAR O LOGIN DE USUARIO.
//@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired 
	private DiarioUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	auth.userDetailsService(myUserDetailsService);

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/register", "/webjars/**", "/css/**",
                "/images/**").permitAll()
		.antMatchers("/diarios").hasRole("USER")
		
		.antMatchers("/usuarios/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		//TODO remover o csrf disable para uso na web
		.csrf().disable()
		.formLogin()
		.and()
		.logout();
	}
	
	@Bean
	public PasswordEncoder passwordEnconder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
