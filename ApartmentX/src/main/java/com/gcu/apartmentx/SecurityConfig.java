package com.gcu.apartmentx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gcu.apartmentx.business.UserBusinessService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserBusinessService service;

	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .authorizeRequests()
		        .antMatchers("/Styles.css","/images/**").permitAll()
	            .antMatchers("/", "/display0AuthCode", "/register").permitAll()
	            .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginPage("/login")
	            .usernameParameter("username")
	            .passwordParameter("password")
	            .permitAll()
	            .defaultSuccessUrl("/login-success", true)
	        .and()
	        .logout()
	            .logoutUrl("/logout")
	            .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .permitAll()
	            .logoutSuccessUrl("/");
	}

	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		// Set the userDetailsService and password encoder
		auth.userDetailsService(service)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
