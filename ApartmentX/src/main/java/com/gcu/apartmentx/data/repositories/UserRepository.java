package com.gcu.apartmentx.data.repositories;

import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Repository interface for managing UserEntity objects in the database
 * Extends CrudRepository to provide basic CRUD operations for the "USERS" table
 */
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	/**
	 * Retrieves all UserEntity objects from the "USERS" table
	 * @return a list of all UserEntity objects
	 */
    @Override
    @Query(value = "SELECT * FROM USERS")
    public List<UserEntity> findAll();
    /**
     * Retrieves a UserEntity object from the "USERS" table by matching the username
     * @param username the username of the user
     * @return the UserEntity object that matches the given username, or null if not found
     */
    public UserEntity findByUsername(String username);
}
