package com.gcu.apartmentx.business;

public interface RegistrationInterface
{
	public void addUser(String userName, String email, String password, String firstName, String lastName);
	public void init();
	public void destroy();
}
