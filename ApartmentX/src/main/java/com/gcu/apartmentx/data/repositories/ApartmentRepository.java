package com.gcu.apartmentx.data.repositories;

import com.gcu.apartmentx.data.entities.ApartmentEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Repository interface for managing ApartmentEntity objects in the database
 * Extends CrudRepository to provide basic CRUD operations for the "APARTMENTS" table
 */
public interface ApartmentRepository extends CrudRepository<ApartmentEntity, Integer> {

	/**
	 * Retrieves all ApartmentEntity objects from the "APARTMENTS" table
	 * @return a list of all ApartmentEntity objects
	 */
    @Override
    @Query(value = "SELECT * FROM APARTMENTS")
    public List<ApartmentEntity> findAll();
}
