package com.gcu.apartmentx.data;

import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.data.repositories.ApartmentRepository;
import com.gcu.apartmentx.data.repositories.UserRepository;
import org.apache.catalina.User;
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

    @Override
    public boolean create(ApartmentEntity apartment) {
        String sql = "INSERT INTO APARTMENTS(NAME, NUMBER_BEDS, NUMBER_BATHS, FLOOR_SPACE, PRICE, QUANTITY) VALUES (?,?,?,?,?,?)";
        try{
            jdbcTemplate.update(sql, apartment.getName(), apartment.getNumBeds(), apartment.getNumBaths(), apartment.getFloorSpace(), apartment.getPrice(), apartment.getQuantity());
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

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


    @Override
    public boolean delete(int id) {
        try {
            jdbcTemplate.update("DELETE FROM APARTMENTS WHERE ID = ?", id);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
