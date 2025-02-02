package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class RegistrationBean implements RegistrationInterface {
    @Autowired
    private UserDataService service;

	@Override
    public boolean addUser(String type, String userName, String email, String password, String firstName, String lastName) {
        UserEntity newUserEntity = new UserEntity(type, userName, email, password, firstName, lastName);
        
        List<UserEntity> currentUsers = service.findAll();
        for(UserEntity userEntity : currentUsers)
        {
        	if (userEntity.getUsername().equals(newUserEntity.getUsername()) || userEntity.getEmail().equals(newUserEntity.getEmail()))
        	{
        		return false;
        	}
        }
        service.create(newUserEntity);
        return true;
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
