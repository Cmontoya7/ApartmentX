package com.gcu.apartmentx.data;

/**
 * Interface for data access operations related to users
 * Provides methods to interact with user data, specifically for retrieving user details by username
 * @param <T> the type of the entity being retrieved
 */
public interface UsersDataAccessInterface <T>
{
	/**
	 * Retrieves a user by their username from the data source
	 * @param username the username of the user to retrieve
	 * @return the user object associated with the provided username
	 */
	public T findByUsername(String username);
}
