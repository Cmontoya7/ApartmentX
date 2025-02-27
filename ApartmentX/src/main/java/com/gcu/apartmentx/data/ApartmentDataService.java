package com.gcu.apartmentx.data;

import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.data.repositories.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentDataService implements DataAccessInterface<ApartmentEntity> {
    @Autowired
    private ApartmentRepository apartmentRepository;
    @SuppressWarnings("unused")
    private DataSource source;
    private JdbcTemplate jdbcTemplate;

    public ApartmentDataService(ApartmentRepository apartmentRepository, DataSource dataSource) {
        this.apartmentRepository = apartmentRepository;
        this.source = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //finds all Entities living in the database and returns a list
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

    //finds the Entity associated with the id passed to the method and returns that entity
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

    //uses the entity to add it to the database
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

    //uses the updated entity to update the current outdated properties associated with the new one
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


    //grab the id associated with the entity passed to this method to delete the item from the database using the below query
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
