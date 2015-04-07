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
import org.template.dao.SprintDAO;
import org.template.domain.Sprint;
import org.template.rm.SprintRowMapper;

@Repository
public class SprintDAOImpl extends BaseDAO implements SprintDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO Sprint ( sprintId, sprintName, doe, durationFrom, durationTo, description, scrumMasterUserId, byUserId, status, productId) VALUES( :sprintId, :sprintName, :doe, :durationFrom, :durationTo, :description, :scrumMasterUserId, :byUserId, :status, :productId)";
    private static final String SQL_UPDATE_QUERY = "UPDATE Sprint SET sprintId = :sprintId, sprintName = :sprintName, doe = :doe, durationFrom = :durationFrom, durationTo = :durationTo, description = :description, scrumMasterUserId = :scrumMasterUserId, byUserId = :byUserId, status = :status, productId = :productId WHERE sprintId= :sprintId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM Sprint WHERE sprintId= :sprintId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM Sprint";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM Sprint WHERE sprintId= :sprintId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM Sprint WHERE sprintId?";

    @Override
    public void save(Sprint sprint) {
        Map p = new HashMap();
        p.put("sprintId", sprint.getSprintId());
        p.put("sprintName", sprint.getSprintName());
        p.put("doe", sprint.getDoe());
        p.put("durationFrom", sprint.getDurationFrom());
        p.put("durationTo", sprint.getDurationTo());
        p.put("description", sprint.getDescription());
        p.put("scrumMasterUserId", sprint.getScrumMasterUserId());
        p.put("byUserId", sprint.getByUserId());
        p.put("status", sprint.getStatus());
        p.put("productId", sprint.getProductId());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        sprint.setSprintId(pk);
    }

    @Override
    public void update(Sprint sprint) {
        Map p = new HashMap();
        p.put("sprintId", sprint.getSprintId());
        p.put("sprintName", sprint.getSprintName());
        p.put("doe", sprint.getDoe());
        p.put("durationFrom", sprint.getDurationFrom());
        p.put("durationTo", sprint.getDurationTo());
        p.put("description", sprint.getDescription());
        p.put("scrumMasterUserId", sprint.getScrumMasterUserId());
        p.put("byUserId", sprint.getByUserId());
        p.put("status", sprint.getStatus());
        p.put("productId", sprint.getProductId());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(Sprint sprint) {
        delete(sprint.getSprintId());
    }

    @Override
    public void delete(Integer sprintId) {
        SqlParameterSource ps = new MapSqlParameterSource("sprintid", sprintId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public Sprint findById(Integer sprintId) {
        Sprint sprint = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new SprintRowMapper(), sprintId);
        return sprint;
    }

    @Override
    public List<Sprint> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new SprintRowMapper());
    }

    @Override
    public List<Sprint> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new SprintRowMapper(), value);
    }
}
