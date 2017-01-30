package com.lealem;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from accounts where username=?")
				.authoritiesByUsernameQuery("select username, has_role authorities from accounts where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/warehouse/skuCreationRequest").permitAll()			
		.antMatchers("/css/**", "/js/**").permitAll()
		.antMatchers("/").permitAll()
				.antMatchers("/login/addUser").permitAll()
				.anyRequest()
				.authenticated()
				.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/home").permitAll().and().logout()
				.permitAll().and().sessionManagement().invalidSessionUrl("/login")				
				;
		   http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");
	}
}
