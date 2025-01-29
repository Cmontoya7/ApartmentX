package com.gcu.apartmentx.data;

import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.data.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService implements DataAccessInterface<UserEntity> {
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
        String sql = "INSERT INTO USERS(USERNAME, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME) VALUES (?,?,?,?,?)";
        try{
            jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UserEntity user) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
