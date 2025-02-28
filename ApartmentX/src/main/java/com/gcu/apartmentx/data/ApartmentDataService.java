package com.gcu.apartmentx.data;

import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.data.repositories.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class that handles data access logic for apartments
 * Implements the DataAccessInterface for CRUD operations on apartments
 */
@Service
public class ApartmentDataService implements DataAccessInterface<ApartmentEntity> {
    @Autowired
    private ApartmentRepository apartmentRepository;
    @SuppressWarnings("unused")
    private DataSource source;
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructs an ApartmentDataService instance with the provided ApartmentRepository and DataSource
     * @param apartmentRepository the repository for apartment entities
     * @param dataSource the data source for database connection
     */
    public ApartmentDataService(ApartmentRepository apartmentRepository, DataSource dataSource) {
        this.apartmentRepository = apartmentRepository;
        this.source = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Retrieves all apartment entities from the database and returns them in a list
     * @return a list of all apartments in the database
     */
    @Override
    public List<ApartmentEntity> findAll() {
        List<ApartmentEntity> apartments = new ArrayList<>();
        try{
            apartments.addAll(apartmentRepository.findAll());
        } catch(Exception e){
            e.printStackTrace();
        }
        return apartments;
    }

    /**
     * Finds and returns an apartment entity by its ID
     * @param id the ID of the apartment to be retrieved
     * @return the ApartmentEntity associated with the ID, or null if not found
     */
    @Override
    public ApartmentEntity findById(int id) {
        List<ApartmentEntity> apartments = apartmentRepository.findAll();
        for(ApartmentEntity apartment : apartments){
            if(id == apartment.getId()){
                return apartment;
            }
        }
        return null;
    }

    /**
     * Finds and returns an apartment entity by its ID
     * @param id the ID of the apartment to be retrieved
     * @return the ApartmentEntity associated with the ID, or null if not found
     */
    @Override
    public boolean create(ApartmentEntity apartment) {
        String sql = "INSERT INTO APARTMENTS(NAME, NUMBER_BEDS, NUMBER_BATHS, FLOOR_SPACE, PRICE, QUANTITY) VALUES (?,?,?,?,?,?)";
        try{
        	//gather the entity's properties to place within the database 
            jdbcTemplate.update(sql, apartment.getName(), apartment.getNumBeds(), apartment.getNumBaths(), apartment.getFloorSpace(), apartment.getPrice(), apartment.getQuantity());
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Updates the properties of an existing apartment entity in the database
     * @param apartment the updated apartment entity
     * @return true if the apartment was successfully updated, false otherwise
     */
    @Override
    public boolean update(ApartmentEntity apartment) {
        String sql = "UPDATE APARTMENTS SET NAME = ?, NUMBER_BEDS = ?, NUMBER_BATHS = ?, FLOOR_SPACE = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?";
        try {
            jdbcTemplate.update(sql, apartment.getName(), apartment.getNumBeds(), apartment.getNumBaths(), 
                                apartment.getFloorSpace(), apartment.getPrice(), apartment.getQuantity(), apartment.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Deletes the specified apartment entity from the database using its ID
     * @param apartment the apartment entity to be deleted
     * @return true if the apartment was successfully deleted, false otherwise
     */
    @Override
    public boolean delete(ApartmentEntity apartment) {
    	int id = apartment.getId();
        try {
            jdbcTemplate.update("DELETE FROM APARTMENTS WHERE ID = ?", id);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
