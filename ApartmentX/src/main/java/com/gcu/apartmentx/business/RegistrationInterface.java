package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.entities.UserEntity;
import java.util.List;

public interface RegistrationInterface
{
	public void addUser(String type, String userName, String email, String password, String firstName, String lastName);

	public void init();
	public void destroy();
}
