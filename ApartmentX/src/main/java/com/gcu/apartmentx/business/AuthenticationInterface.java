package com.gcu.apartmentx.business;

/**
 * Interface for authentication services
 * Defines methods for authenticating users
 */
public interface AuthenticationInterface {
	/**
     * Authenticates a user based on username and password
     * @param username the username to authenticate
     * @param password the password to authenticate
     * @return a message indicating the result of the authentication process
     */
    public String authenticate(String username, String password);
    /**
     * Initializes the authentication bean
     */
    public void init();
    /**
     * Destroys the authentication bean
     */
    public void destroy();
}
