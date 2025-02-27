package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RegistrationBusinessService implements RegistrationInterface {
	
	//Spring bean which interacts with the repository. Handles database interaction
	@Autowired
    private UserDataService service;

    // --------------------- create --------------------- //
	
	//receives properties which are used to create a UserEntity
	@Override
    public boolean addUser(String type, String userName, String email, String password, String firstName, String lastName) {
        UserEntity newUserEntity = new UserEntity(type, userName, email, password, firstName, lastName);
        
        List<UserEntity> currentUsers = service.findAll(); //Gathers all UserEntities that live in the database
        
        // iterate through each UserEntity in the currentUsers 
        for(UserEntity userEntity : currentUsers)
        {
        	//checks if the username or email already exist, if so return false
        	if (userEntity.getUsername().equals(newUserEntity.getUsername()) || userEntity.getEmail().equals(newUserEntity.getEmail()))
        	{
        		return false;
        	}
        }
        
        //adds the user to the database assuming the if statement above is passed
        service.create(newUserEntity);
        return true;
    }
	
    // --------------------- LIFECYCLE METHODS --------------------- //

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
