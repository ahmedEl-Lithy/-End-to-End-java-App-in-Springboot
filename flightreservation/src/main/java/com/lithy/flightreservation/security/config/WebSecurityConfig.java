package com.lithy.flightreservation.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
//because it's the configuration for all the system
@EnableWebSecurity
// activate the security layer from spring for all the application
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	Override method authenticationManagerBean in WebSecurityConfigurerAdapter to
//	expose the AuthenticationManager built using configure(AuthenticationManagerBuilder) as a Spring bean
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// pass the uri, urls that needs to be authenticated
		http.authorizeRequests()
				.antMatchers("/showReg", "/", "/index.html", "/registerUser", "/login", "/showLogin", "/login/*")
				.permitAll().antMatchers("/admin/showAddFlight").hasAnyAuthority("ADMIN").anyRequest().authenticated()
				.and().csrf().disable();
	}
}
