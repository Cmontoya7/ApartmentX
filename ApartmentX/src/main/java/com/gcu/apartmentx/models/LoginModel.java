package com.gcu.apartmentx.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel
{
	// Attributes
	@NotNull(message="Username is a required field")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
    private String username;
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;

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
}
