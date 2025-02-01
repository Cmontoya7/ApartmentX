package com.gcu.apartmentx.data.mappers;

import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentMapper implements RowMapper<ApartmentEntity> {

    @Override
    public ApartmentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ApartmentEntity(rs.getInt("ID"),
                rs.getString("NAME"),
                rs.getInt("NUMBER_BEDS"),
                rs.getInt("NUMBER_BATHS"),
                rs.getInt("FLOOR_SPACE"),
                rs.getFloat("PRICE"),
                rs.getInt("QUANTITY"));
    }
}
