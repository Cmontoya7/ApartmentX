package com.gcu.apartmentx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.apartmentx.business.ApartmentBusinessService;
import com.gcu.apartmentx.business.AuthenticationBusinessService;
import com.gcu.apartmentx.business.RegistrationBusinessService;

/**
 * Configuration class that defines beans for various business services
 */
@Configuration
public class SpringConfig
{
	/**
	 * Creates and returns an ApartmentBusinessService bean
	 * @return an instance of ApartmentBusinessService
	 */
	@Bean(name="apartmentBeanConfig", initMethod="init", destroyMethod="destroy")
	@SessionScope // This will be changed to RequestScope when the database is implemented
	public ApartmentBusinessService addApartment()
	{
		return new ApartmentBusinessService();
	}
	
	/**
	 * Creates and returns an AuthenticationBusinessService bean
	 * @return an instance of AuthenticationBusinessService
	 */
	@Bean(name="authenticationBean", initMethod="init", destroyMethod="destroy")
	@SessionScope
	public AuthenticationBusinessService authenticate()
	{
		return new AuthenticationBusinessService();
	}
	
	/**
	 * Creates and returns a RegistrationBusinessService bean
	 * @return an instance of RegistrationBusinessService
	 */
	@Bean(name="registrationBean", initMethod="init", destroyMethod="destroy")
	@SessionScope // This will be changed to RequestScope when the database is implemented
	public RegistrationBusinessService addUser()
	{
		return new RegistrationBusinessService();
	}
}
