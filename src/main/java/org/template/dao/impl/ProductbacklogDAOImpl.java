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
import org.template.dao.ProductBacklogDAO;
import org.template.domain.ProductBacklog;
import org.template.rm.ProductbacklogRowMapper;

@Repository
public class ProductbacklogDAOImpl extends BaseDAO implements ProductBacklogDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO Productbacklog ( productBacklogId, name, doe, moduleId, priority, description, userStory, uploadPath, status, byUserId, reason, statusUpdatedBy, productId) VALUES( :productBacklogId, :name, :doe, :moduleId, :priority, :description, :userStory, :uploadPath, :status, :byUserId, :reason, :statusUpdatedBy, :productId)";
    private static final String SQL_UPDATE_QUERY = "UPDATE Productbacklog SET productBacklogId = :productBacklogId, name = :name, doe = :doe, moduleId = :moduleId, priority = :priority, description = :description, userStory = :userStory, uploadPath = :uploadPath, status = :status, byUserId = :byUserId, reason = :reason, statusUpdatedBy = :statusUpdatedBy, productId = :productId WHERE productBacklogId= :productBacklogId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM Productbacklog WHERE productBacklogId= :productBacklogId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM Productbacklog";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM Productbacklog WHERE productBacklogId= :productBacklogId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM Productbacklog WHERE productBacklogId?";

    @Override
    public void save(ProductBacklog productbacklog) {
        Map p = new HashMap();
        p.put("productBacklogId", productbacklog.getProductBacklogId());
        p.put("name", productbacklog.getName());
        p.put("doe", productbacklog.getDoe());
        p.put("moduleId", productbacklog.getModuleId());
        p.put("priority", productbacklog.getPriority());
        p.put("description", productbacklog.getDescription());
        p.put("userStory", productbacklog.getUserStory());
        p.put("uploadPath", productbacklog.getUploadPath());
        p.put("status", productbacklog.getStatus());
        p.put("byUserId", productbacklog.getByUserId());
        p.put("reason", productbacklog.getReason());
        p.put("statusUpdatedBy", productbacklog.getStatusUpdatedBy());
        p.put("productId", productbacklog.getProductId());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        productbacklog.setProductBacklogId(pk);
    }

    @Override
    public void update(ProductBacklog productbacklog) {
        Map p = new HashMap();
        p.put("productBacklogId", productbacklog.getProductBacklogId());
        p.put("name", productbacklog.getName());
        p.put("doe", productbacklog.getDoe());
        p.put("moduleId", productbacklog.getModuleId());
        p.put("priority", productbacklog.getPriority());
        p.put("description", productbacklog.getDescription());
        p.put("userStory", productbacklog.getUserStory());
        p.put("uploadPath", productbacklog.getUploadPath());
        p.put("status", productbacklog.getStatus());
        p.put("byUserId", productbacklog.getByUserId());
        p.put("reason", productbacklog.getReason());
        p.put("statusUpdatedBy", productbacklog.getStatusUpdatedBy());
        p.put("productId", productbacklog.getProductId());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(ProductBacklog productbacklog) {
        delete(productbacklog.getProductBacklogId());
    }

    @Override
    public void delete(Integer productbacklogId) {
        SqlParameterSource ps = new MapSqlParameterSource("productbacklogid", productbacklogId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public ProductBacklog findById(Integer productbacklogId) {
        ProductBacklog productbacklog = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new ProductbacklogRowMapper(), productbacklogId);
        return productbacklog;
    }

    @Override
    public List<ProductBacklog> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new ProductbacklogRowMapper());
    }

    @Override
    public List<ProductBacklog> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new ProductbacklogRowMapper(), value);
    }
}
