package org.template.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.template.dao.AssignedProductDAO;
import org.template.dao.BaseDAO;
import org.template.domain.AssignedProduct;
import org.template.rm.AssignedproductRowMapper;

@Repository
public class AssignedproductDAOImpl extends BaseDAO implements AssignedProductDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO Assignedproduct ( assignedProductId, productId, userId, doe, byUserId) VALUES( :assignedProductId, :productId, :userId, :doe, :byUserId)";
    private static final String SQL_UPDATE_QUERY = "UPDATE Assignedproduct SET assignedProductId = :assignedProductId, productId = :productId, userId = :userId, doe = :doe, byUserId = :byUserId WHERE assignedProductId= :assignedProductId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM Assignedproduct WHERE assignedProductId= :assignedProductId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM Assignedproduct";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM Assignedproduct WHERE assignedProductId= :assignedProductId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM Assignedproduct WHERE assignedProductId?";

    @Override
    public void save(AssignedProduct assignedproduct) {
        Map p = new HashMap();
        p.put("assignedProductId", assignedproduct.getAssignedProductId());
        p.put("productId", assignedproduct.getProductId());
        p.put("userId", assignedproduct.getUserId());
        p.put("doe", assignedproduct.getDoe());
        p.put("byUserId", assignedproduct.getByUserId());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        assignedproduct.setAssignedProductId(pk);
    }

    @Override
    public void update(AssignedProduct assignedproduct) {
        Map p = new HashMap();
        p.put("assignedProductId", assignedproduct.getAssignedProductId());
        p.put("productId", assignedproduct.getProductId());
        p.put("userId", assignedproduct.getUserId());
        p.put("doe", assignedproduct.getDoe());
        p.put("byUserId", assignedproduct.getByUserId());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(AssignedProduct assignedproduct) {
        delete(assignedproduct.getAssignedProductId());
    }

    @Override
    public void delete(Integer assignedproductId) {
        SqlParameterSource ps = new MapSqlParameterSource("assignedproductid", assignedproductId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public AssignedProduct findById(Integer assignedproductId) {
        AssignedProduct assignedproduct = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new AssignedproductRowMapper(), assignedproductId);
        return assignedproduct;
    }

    @Override
    public List<AssignedProduct> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new AssignedproductRowMapper());
    }

    @Override
    public List<AssignedProduct> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new AssignedproductRowMapper(), value);
    }
}
