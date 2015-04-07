package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.City;

public class CityRowMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet rs, int i) throws SQLException {
        City city = new City();
        city.setCityId(rs.getInt("cityId"));
        city.setStateId(rs.getInt("stateId"));
        city.setName(rs.getString("name"));
        return city;
    }
}
