package com.gcu.apartmentx.data;

public interface UsersDataAccessInterface <T>
{
	public T findByUsername(String username);
}
