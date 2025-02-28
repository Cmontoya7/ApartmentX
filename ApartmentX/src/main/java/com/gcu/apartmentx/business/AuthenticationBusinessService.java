package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service class for handling authentication logic
 * Provides methods for authenticating users based on username and password
 */
public class AuthenticationBusinessService implements AuthenticationInterface {
    private boolean authenticationResult;
    @Autowired
    UserDataService service;

    /**
     * Authenticates a user based on username and password
     * @param username the username to authenticate
     * @param password the password to authenticate
     * @return a message indicating the result of the authentication process
     */
    public String authenticate(String username, String password) {
    	authenticationResult = false;
        // Pseudo-Database for users
        List<UserEntity> userList = service.findAll();

        // Authentication of Username and Password
        String msg = "message null";
        boolean userExists = false;
        boolean passwordMatch = false;
        for (UserEntity user : userList) {
            if (user.getUsername().equals(username)) {
                userExists = true;
                if (user.getPassword().equals(password)) {
                    passwordMatch = true;
                    msg = user.getFirstName() + ":" + user.getType() + ":" + user.getId();
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

    /**
     * Retrieves the result of the last authentication attempt
     * @return true if authentication was successful, false otherwise
     */
    public boolean getAuthenticationResult() {
        return authenticationResult; // Getter to access the result
    }

    /**
     * Initializes the authentication bean
     */
    @Override
    public void init() {
        System.out.println("AuthenticationBean init method call");
    }

    /**
     * Destroys the authentication bean
     */
    @Override
    public void destroy() {
        System.out.println("AuthenticationBean destroy method call");
    }
}
