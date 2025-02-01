package com.gcu.apartmentx.data.repositories;

import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ApartmentRepository extends CrudRepository<ApartmentEntity, Integer> {

    @Override
    @Query(value = "SELECT * FROM APARTMENTS")
    public List<ApartmentEntity> findAll();
}
