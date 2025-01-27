package com.gcu.apartmentx.business;

public interface AuthenticationInterface
{
	boolean result = false;
	public String authenticate(String username, String password);
}
