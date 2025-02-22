package com.gcu.apartmentx.data;

import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService implements DataAccessInterface<UserEntity>,UsersDataAccessInterface<UserEntity> {
    @Autowired
    private UserRepository userRepository;
    @SuppressWarnings("unused")
    private DataSource source;
    private JdbcTemplate jdbcTemplate;

    public UserDataService(UserRepository userRepository, DataSource dataSource) {
        this.userRepository = userRepository;
        this.source = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


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


	@Override
	public UserEntity findByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
}
