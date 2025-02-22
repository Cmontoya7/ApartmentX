package com.gcu.apartmentx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.apartmentx.business.ApartmentBusinessService;
import com.gcu.apartmentx.business.AuthenticationBusinessService;
import com.gcu.apartmentx.business.RegistrationBusinessService;

@Configuration
public class SpringConfig
{
	@Bean(name="apartmentBeanConfig", initMethod="init", destroyMethod="destroy")
	@SessionScope // This will be changed to RequestScope when the database is implemented
	public ApartmentBusinessService addApartment()
	{
		return new ApartmentBusinessService();
	}
	
	@Bean(name="authenticationBean", initMethod="init", destroyMethod="destroy")
	@SessionScope
	public AuthenticationBusinessService authenticate()
	{
		return new AuthenticationBusinessService();
	}
	
	@Bean(name="registrationBean", initMethod="init", destroyMethod="destroy")
	@SessionScope // This will be changed to RequestScope when the database is implemented
	public RegistrationBusinessService addUser()
	{
		return new RegistrationBusinessService();
	}
}
