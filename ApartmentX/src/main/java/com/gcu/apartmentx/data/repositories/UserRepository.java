package com.gcu.apartmentx.data.repositories;

import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Override
    @Query(value = "SELECT * FROM USERS")
    public List<UserEntity> findAll();
    public UserEntity findByUsername(String username);
}
