package com.gcu.apartmentx.business;

/**
 * Interface for user registration logic
 * Defines methods for adding users and managing lifecycle methods
 */
public interface RegistrationInterface
{
	/**
	 * Adds a new user to the system after checking if the username or email already exists
	 * @param type the type of the user (e.g., admin, regular user)
	 * @param userName the username of the user
	 * @param email the email of the user
	 * @param password the password of the user
	 * @param firstName the first name of the user
	 * @param lastName the last name of the user
	 * @return true if the user was successfully added, false if the username or email already exists
	 */
	public boolean addUser(String type, String userName, String email, String password, String firstName, String lastName);
	/**
	 * Initializes the registration bean
	 */
	public void init();
	/**
	 * Destroys the registration bean
	 */
	public void destroy();
}
