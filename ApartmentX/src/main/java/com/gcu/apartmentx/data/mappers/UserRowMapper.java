package com.gcu.apartmentx.data.mappers;

import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserEntity(rs.getInt("ID"),
                rs.getString("USERNAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"));
    }
}
