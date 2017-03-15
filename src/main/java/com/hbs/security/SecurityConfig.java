package com.hbs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String HBS_ADMIN = "/hbs/**";
	private static final String HBS_USER = "/hbs/*";
	private static final String ADMIN = "ADMIN";
	private static final String USER = "USER";

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
				.antMatchers(HBS_ADMIN).hasRole(ADMIN)
				.antMatchers(HBS_USER).hasRole(USER)
			.and()
				.formLogin();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
				.withUser("admin").password("password").roles(ADMIN)
				.and()
				.withUser("user").password("password").roles(USER);
	}
}
