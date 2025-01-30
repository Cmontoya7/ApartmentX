package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.data.repositories.UserRepository;
import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationBean implements AuthenticationInterface {
    private boolean authenticationResult;
    @Autowired
    UserDataService service;

    public String authenticate(String username, String password) {
    	authenticationResult = false;
        // Pseudo-Database for users
        List<UserEntity> userEntities = service.findAll();
        List<ApartmentXUser> userList = new ArrayList<>();

        for (UserEntity u : userEntities) {
            userList.add(new ApartmentXUser(u.getType(), u.getUsername(), u.getEmail(), u.getPassword(), u.getFirstName(), u.getLastName()));
        }
        // Authentication of Username and Password
        String msg = "message null";
        boolean userExists = false;
        boolean passwordMatch = false;
        for (ApartmentXUser user : userList) {
            if (user.getUsername().equals(username)) {
                userExists = true;
                if (user.getPassword().equals(password)) {
                    passwordMatch = true;
                    msg = user.getNameFirst() + ":" + user.getType();
                    authenticationResult = true;
                    break;
                }
            }
        }
        // Error message for failed login.
        if (!userExists) {
            msg = "Username does not exist: " + username;
        } else if (!passwordMatch) {
            msg = "Password did not match";
        }
        // Print any message for testing purposes
        System.out.println(msg);
        return msg;
    }

    public boolean getAuthenticationResult() {
        return authenticationResult; // Getter to access the result
    }

    @Override
    public void init() {
        System.out.println("AuthenticationBean init method call");
    }

    @Override
    public void destroy() {
        System.out.println("AuthenticationBean destroy method call");
    }
}
