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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
				.antMatchers("/css/**", "/js/**").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/warehouse/skuCreationRequest","/warehouse/shippingRequest").permitAll()			
				.antMatchers("/login/addUser").permitAll()
				.anyRequest()
				.authenticated()
				.antMatchers("/sku/**").hasAuthority("STOCK_MANAGER")
				.antMatchers("/location/**").hasAuthority("WAREHOUSE_MANAGER")				
				.antMatchers("/shipment/peakRequestsList","/shipment/pick","/shipment/peakItemsList").hasAuthority("ORDER_PICKER")				
				.antMatchers("/shipment/shipRequestsLis","/shipment/ship").hasAuthority("SHIPPING_CLERK")
				.antMatchers("/sku/SKUs/*","/sku/details").authenticated()				
				.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/home").permitAll().and().logout()
				.permitAll().and().sessionManagement().invalidSessionUrl("/login")	.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");								;
				;
		   http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");
	}
}
