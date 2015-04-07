package org.template.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.template.dao.BaseDAO;
import org.template.dao.CountryDAO;
import org.template.domain.Country;
import org.template.rm.CountryRowMapper;

@Repository
public class CountryDAOImpl extends BaseDAO implements CountryDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO Country ( countryId, name) VALUES( :countryId, :name)";
    private static final String SQL_UPDATE_QUERY = "UPDATE Country SET countryId = :countryId, name = :name WHERE countryId= :countryId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM Country WHERE countryId= :countryId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM Country";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM Country WHERE countryId= :countryId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM Country WHERE countryId?";

    @Override
    public void save(Country country) {
        Map p = new HashMap();
        p.put("countryId", country.getCountryId());
        p.put("name", country.getName());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        country.setCountryId(pk);
    }

    @Override
    public void update(Country country) {
        Map p = new HashMap();
        p.put("countryId", country.getCountryId());
        p.put("name", country.getName());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(Country country) {
        delete(country.getCountryId());
    }

    @Override
    public void delete(Integer countryId) {
        SqlParameterSource ps = new MapSqlParameterSource("countryid", countryId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public Country findById(Integer countryId) {
        Country country = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new CountryRowMapper(), countryId);
        return country;
    }

    @Override
    public List<Country> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new CountryRowMapper());
    }

    @Override
    public List<Country> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new CountryRowMapper(), value);
    }
}
