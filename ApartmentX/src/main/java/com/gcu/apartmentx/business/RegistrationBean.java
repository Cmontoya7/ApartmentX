package com.gcu.apartmentx.business;

import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

public class RegistrationBean implements RegistrationInterface {

	//Pseudo-Database for users
    public List<ApartmentXUser> userList = new LinkedList<>();
    
    public RegistrationBean()
    {
    	populateUserList();
    }
    
    public void populateUserList()
    {
    	userList.add(new ApartmentXUser("username", "email@email.com", "testword", "Chris", "name"));
        userList.add(new ApartmentXUser("username2", "email2@email.com", "testword2", "user2", "name2"));
        userList.add(new ApartmentXUser("username3", "email3@email.com", "testword3", "user3", "name3"));
        userList.add(new ApartmentXUser("username4", "email4@email.com", "testword4", "user4", "name4"));
        userList.add(new ApartmentXUser("username5", "email5@email.com", "testword5", "user5", "name5"));
    }
    
    public void addUser(String userName, String email, String password, String firstName, String lastName) {
        //add new user to the Pseudo-Database
        userList.add(new ApartmentXUser(userName, email, password, firstName, lastName));

        //Print the Pseudo-Database for testing purposes
        System.out.println("User Database");
        for (ApartmentXUser user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("User Database End");

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
