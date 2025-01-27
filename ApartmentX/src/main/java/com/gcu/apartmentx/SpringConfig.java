package com.gcu.apartmentx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.apartmentx.business.ApartmentBean;
import com.gcu.apartmentx.business.AuthenticationBean;
import com.gcu.apartmentx.business.RegistrationBean;

@Configuration
public class SpringConfig
{
	@Bean(name="apartmentBean", initMethod="init", destroyMethod="destroy")
	@SessionScope // This will be changed to RequestScope when the database is implemented
	public ApartmentBean addApartment()
	{
		return new ApartmentBean();
	}
	
	@Bean(name="authenticationBean", initMethod="init", destroyMethod="destroy")
	@RequestScope
	public AuthenticationBean authenticate()
	{
		return new AuthenticationBean();
	}
	
	@Bean(name="registrationBean", initMethod="init", destroyMethod="destroy")
	@SessionScope // This will be changed to RequestScope when the database is implemented
	public RegistrationBean addUser()
	{
		return new RegistrationBean();
	}
}
