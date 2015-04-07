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
import org.template.dao.StateDAO;
import org.template.domain.State;
import org.template.rm.StateRowMapper;

@Repository
public class StateDAOImpl extends BaseDAO implements StateDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO State ( stateId, name, countryId) VALUES( :stateId, :name, :countryId)";
    private static final String SQL_UPDATE_QUERY = "UPDATE State SET stateId = :stateId, name = :name, countryId = :countryId WHERE stateId= :stateId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM State WHERE stateId= :stateId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM State";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM State WHERE stateId= :stateId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM State WHERE stateId?";

    @Override
    public void save(State state) {
        Map p = new HashMap();
        p.put("stateId", state.getStateId());
        p.put("name", state.getName());
        p.put("countryId", state.getCountryId());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        state.setStateId(pk);
    }

    @Override
    public void update(State state) {
        Map p = new HashMap();
        p.put("stateId", state.getStateId());
        p.put("name", state.getName());
        p.put("countryId", state.getCountryId());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(State state) {
        delete(state.getStateId());
    }

    @Override
    public void delete(Integer stateId) {
        SqlParameterSource ps = new MapSqlParameterSource("stateid", stateId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public State findById(Integer stateId) {
        State state = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new StateRowMapper(), stateId);
        return state;
    }

    @Override
    public List<State> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new StateRowMapper());
    }

    @Override
    public List<State> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new StateRowMapper(), value);
    }
}
