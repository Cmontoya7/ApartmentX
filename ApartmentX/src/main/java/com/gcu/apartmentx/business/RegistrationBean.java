package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

public class RegistrationBean implements RegistrationInterface {
    @Autowired
    private UserDataService userDataService;

    public void addUser(String userName, String email, String password, String firstName, String lastName) {
        UserEntity userEntity = new UserEntity(userName, email, password, firstName, lastName);
        userDataService.create(userEntity);
    }

	@Override
	public void init()
	{
		System.out.println("RegistrationBean init method call");
	}

	@Override
	public void destroy()
	{
		System.out.println("RegistrationBean destroy method call");
	}
}
