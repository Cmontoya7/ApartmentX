package com.gcu.apartmentx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gcu.apartmentx.business.UserBusinessService;

/**
 * Security configuration class for the application
 * Configures authentication and authorization settings
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserBusinessService service;

	/**
     * Configures HTTP security settings for the application
     * @param http the HttpSecurity object to configure
     * @throws Exception if an error occurs while configuring security
     */
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(requests -> requests
                		// Add files that all users should have access to here
                        .antMatchers("/Styles.css", "/images/**").permitAll()
                        // Add URLs that all users should have access to here
                        .antMatchers("/", "/display0AuthCode", "/register", "/register/submitRegistration", "/register/submitAdminRegistration").permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                        .defaultSuccessUrl("/login-success", true))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                        .logoutSuccessUrl("/"));
	}
	
	/**
    * Configures authentication settings for the application
    * @param auth the AuthenticationManagerBuilder object to configure
    * @throws Exception if an error occurs while configuring authentication
    */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		// Set the userDetailsService and password encoder
		auth.userDetailsService(service)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
