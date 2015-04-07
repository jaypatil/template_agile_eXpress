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
import org.template.dao.CityDAO;
import org.template.domain.City;
import org.template.rm.CityRowMapper;

@Repository
public class CityDAOImpl extends BaseDAO implements CityDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO City ( cityId, stateId, name) VALUES( :cityId, :stateId, :name)";
    private static final String SQL_UPDATE_QUERY = "UPDATE City SET cityId = :cityId, stateId = :stateId, name = :name WHERE cityId= :cityId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM City WHERE cityId= :cityId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM City";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM City WHERE cityId= :cityId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM City WHERE cityId?";

    @Override
    public void save(City city) {
        Map p = new HashMap();
        p.put("cityId", city.getCityId());
        p.put("stateId", city.getStateId());
        p.put("name", city.getName());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        city.setCityId(pk);
    }

    @Override
    public void update(City city) {
        Map p = new HashMap();
        p.put("cityId", city.getCityId());
        p.put("stateId", city.getStateId());
        p.put("name", city.getName());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(City city) {
        delete(city.getCityId());
    }

    @Override
    public void delete(Integer cityId) {
        SqlParameterSource ps = new MapSqlParameterSource("cityid", cityId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public City findById(Integer cityId) {
        City city = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new CityRowMapper(), cityId);
        return city;
    }

    @Override
    public List<City> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new CityRowMapper());
    }

    @Override
    public List<City> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new CityRowMapper(), value);
    }
}
