package com.gcu.apartmentx.data.mappers;

import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper class for mapping rows of the "USERS" table to UserEntity objects
 * Implements RowMapper interface to map database rows to UserEntity objects
 */
public class UserRowMapper implements RowMapper<UserEntity> {

	/**
	 * Maps a single row of the ResultSet to a UserEntity object
	 * @param rs the ResultSet object representing a row from the "USERS" table
	 * @param rowNum the row number in the ResultSet
	 * @return the mapped UserEntity object with data from the current row
	 * @throws SQLException if an SQL error occurs while accessing the ResultSet
	 */
    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserEntity(rs.getString("ID"),
                rs.getString("USERNAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"));
    }
}
