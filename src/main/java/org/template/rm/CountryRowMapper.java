package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.Country;

public class CountryRowMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet rs, int i) throws SQLException {
        Country country = new Country();
        country.setCountryId(rs.getInt("countryId"));
        country.setName(rs.getString("name"));
        return country;
    }
}
