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
import org.template.dao.ModuleDAO;
import org.template.domain.Module;
import org.template.rm.ModuleRowMapper;

@Repository
public class ModuleDAOImpl extends BaseDAO implements ModuleDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO Module ( moduleId, name, doe, description, status, productId) VALUES( :moduleId, :name, :doe, :description, :status, :productId)";
    private static final String SQL_UPDATE_QUERY = "UPDATE Module SET moduleId = :moduleId, name = :name, doe = :doe, description = :description, status = :status, productId = :productId WHERE moduleId= :moduleId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM Module WHERE moduleId= :moduleId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM Module";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM Module WHERE moduleId= :moduleId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM Module WHERE moduleId?";

    @Override
    public void save(Module module) {
        Map p = new HashMap();
        p.put("moduleId", module.getModuleId());
        p.put("name", module.getName());
        p.put("doe", module.getDoe());
        p.put("description", module.getDescription());
        p.put("status", module.getStatus());
        p.put("productId", module.getProductId());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        module.setModuleId(pk);
    }

    @Override
    public void update(Module module) {
        Map p = new HashMap();
        p.put("moduleId", module.getModuleId());
        p.put("name", module.getName());
        p.put("doe", module.getDoe());
        p.put("description", module.getDescription());
        p.put("status", module.getStatus());
        p.put("productId", module.getProductId());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(Module module) {
        delete(module.getModuleId());
    }

    @Override
    public void delete(Integer moduleId) {
        SqlParameterSource ps = new MapSqlParameterSource("moduleid", moduleId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public Module findById(Integer moduleId) {
        Module module = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new ModuleRowMapper(), moduleId);
        return module;
    }

    @Override
    public List<Module> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new ModuleRowMapper());
    }

    @Override
    public List<Module> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new ModuleRowMapper(), value);
    }
}
