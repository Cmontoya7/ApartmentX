package com.gcu.apartmentx.data;

import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class that handles data access logic for user entities
 * Implements DataAccessInterface and UsersDataAccessInterface for CRUD operations on users
 */
@Service
public class UserDataService implements DataAccessInterface<UserEntity>,UsersDataAccessInterface<UserEntity> {
    @Autowired
    private UserRepository userRepository;
    @SuppressWarnings("unused")
    private DataSource source;
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructs a new UserDataService with the provided userRepository and dataSource
     * Initializes the JdbcTemplate to interact with the database
     * @param userRepository the repository used to interact with the User data
     * @param dataSource the data source used to initialize the JdbcTemplate
     */
    public UserDataService(UserRepository userRepository, DataSource dataSource) {
        this.userRepository = userRepository;
        this.source = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Retrieves all user entities from the database and returns them in a list
     * @return a list of all users in the database
     */
    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        try{
            users.addAll(userRepository.findAll());
        } catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Finds and returns a user entity by its ID
     * @param id the ID of the user to be retrieved
     * @return the UserEntity associated with the ID, or null if not found
     */
    @Override
    public UserEntity findById(int id) {
        List<UserEntity> users = userRepository.findAll();
        for(UserEntity user : users){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }

    /**
     * Adds a new user entity to the database
     * @param user the user entity to be added
     * @return true if the user was successfully added, false otherwise
     */
    @Override
    public boolean create(UserEntity user) {
    	// Create the SQL query template
        String sql = "INSERT INTO USERS(TYPE, USERNAME, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME) VALUES (?,?,?,?,?,?)";
        try{
        	// Fill out the template with the updated information
            jdbcTemplate.update(sql, user.getType(), user.getUsername(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
        } catch(Exception e){
        	// Print an error if one occurs
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Updates the properties of an existing user entity in the database
     * @param user the updated user entity
     * @return true if the user was successfully updated, false otherwise
     */
    @Override
    public boolean update(UserEntity user) {
    	String sql = "UPDATE USERS SET USERNAME=?, EMAIL=?, PASSWORD=?, FIRST_NAME=?, LAST_NAME=? WHERE ID=?";
        try {
            jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getId());
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Deletes the specified user entity from the database using its ID
     * @param user the user entity to be deleted
     * @return true if the user was successfully deleted, false otherwise
     */
    @Override
    public boolean delete(UserEntity user) {
    	int id = user.getId();
        try {
            jdbcTemplate.update("DELETE FROM USERS WHERE ID = ?", id);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Finds and returns a user entity by its username
     * @param username the username of the user to be retrieved
     * @return the UserEntity associated with the username, or null if not found
     */
	@Override
	public UserEntity findByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
}
