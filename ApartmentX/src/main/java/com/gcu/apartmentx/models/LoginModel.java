package com.gcu.apartmentx.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel
{
	// Attributes
    private String username;
    private String password;
    private boolean loggedIn;

    // Getter method for username
    public String getUsername() 
    {
        return username;
    }

    // Setter method for username
    public void setUsername(String username) 
    {
        this.username = username;
    }

    // Getter method for password
    public String getPassword() 
    {
        return password;
    }

    // Setter method for password
    public void setPassword(String password) 
    {
        this.password = password;
    }

    //Getter for loggedIn
    public boolean isLoggedIn() {
        return loggedIn;
    }

    //Change loggedIn to true
    public void loginTrue() {
        this.loggedIn = true;
    }


    @Override
    public String toString() {
        return "ApartmentXUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
