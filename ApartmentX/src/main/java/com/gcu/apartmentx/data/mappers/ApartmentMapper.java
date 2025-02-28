package com.gcu.apartmentx.data.mappers;

import com.gcu.apartmentx.data.entities.ApartmentEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper class for mapping rows of the "APARTMENTS" table to ApartmentEntity objects
 * Implements RowMapper interface to map database rows to entities
 */
public class ApartmentMapper implements RowMapper<ApartmentEntity> {

	/**
	 * Maps a single row of the ResultSet to an ApartmentEntity object
	 * @param rs the ResultSet object representing a row from the "APARTMENTS" table
	 * @param rowNum the row number in the ResultSet
	 * @return the mapped ApartmentEntity object with data from the current row
	 * @throws SQLException if an SQL error occurs while accessing the ResultSet
	 */
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
