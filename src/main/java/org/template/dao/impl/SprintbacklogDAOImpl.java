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
import org.template.dao.SprintbacklogDAO;
import org.template.domain.Sprintbacklog;
import org.template.rm.SprintbacklogRowMapper;

@Repository
public class SprintbacklogDAOImpl extends BaseDAO implements SprintbacklogDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO Sprintbacklog ( sprintBacklogId, sprintId, productBacklogId, size, doe, byUserId) VALUES( :sprintBacklogId, :sprintId, :productBacklogId, :size, :doe, :byUserId)";
    private static final String SQL_UPDATE_QUERY = "UPDATE Sprintbacklog SET sprintBacklogId = :sprintBacklogId, sprintId = :sprintId, productBacklogId = :productBacklogId, size = :size, doe = :doe, byUserId = :byUserId WHERE sprintBacklogId= :sprintBacklogId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM Sprintbacklog WHERE sprintBacklogId= :sprintBacklogId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM Sprintbacklog";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM Sprintbacklog WHERE sprintBacklogId= :sprintBacklogId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM Sprintbacklog WHERE sprintBacklogId?";

    @Override
    public void save(Sprintbacklog sprintbacklog) {
        Map p = new HashMap();
        p.put("sprintBacklogId", sprintbacklog.getSprintBacklogId());
        p.put("sprintId", sprintbacklog.getSprintBacklogId());
        p.put("productBacklogId", sprintbacklog.getProductBacklogId());
        p.put("size", sprintbacklog.getSize());
        p.put("doe", sprintbacklog.getDoe());
        p.put("byUserId", sprintbacklog.getByUserId());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        sprintbacklog.setSprintBacklogId(pk);
    }

    @Override
    public void update(Sprintbacklog sprintbacklog) {
        Map p = new HashMap();
        p.put("sprintBacklogId", sprintbacklog.getSprintBacklogId());
        p.put("sprintId", sprintbacklog.getSprintBacklogId());
        p.put("productBacklogId", sprintbacklog.getProductBacklogId());
        p.put("size", sprintbacklog.getSize());
        p.put("doe", sprintbacklog.getDoe());
        p.put("byUserId", sprintbacklog.getByUserId());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(Sprintbacklog sprintbacklog) {
        delete(sprintbacklog.getSprintBacklogId());
    }

    @Override
    public void delete(Integer sprintbacklogId) {
        SqlParameterSource ps = new MapSqlParameterSource("sprintbacklogid", sprintbacklogId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public Sprintbacklog findById(Integer sprintbacklogId) {
        Sprintbacklog sprintbacklog = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new SprintbacklogRowMapper(), sprintbacklogId);
        return sprintbacklog;
    }

    @Override
    public List<Sprintbacklog> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new SprintbacklogRowMapper());
    }

    @Override
    public List<Sprintbacklog> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new SprintbacklogRowMapper(), value);
    }
}
