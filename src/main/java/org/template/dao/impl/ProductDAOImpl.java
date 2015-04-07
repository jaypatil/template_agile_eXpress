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
import org.template.dao.ProductDAO;
import org.template.domain.Product;
import org.template.rm.ProductRowMapper;

@Repository
public class ProductDAOImpl extends BaseDAO implements ProductDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO Product ( productId, doe, name, startDate, endDate, description, remark, logoPath, uploadPath, status, byUserId) VALUES( :productId, :doe, :name, :startDate, :endDate, :description, :remark, :logoPath, :uploadPath, :status, :byUserId)";
    private static final String SQL_UPDATE_QUERY = "UPDATE Product SET productId = :productId, doe = :doe, name = :name, startDate = :startDate, endDate = :endDate, description = :description, remark = :remark, logoPath = :logoPath, uploadPath = :uploadPath, status = :status, byUserId = :byUserId WHERE productId= :productId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM Product WHERE productId= :productId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM Product";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM Product WHERE productId= :productId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM Product WHERE productId?";

    @Override
    public void save(Product product) {
        Map p = new HashMap();
        p.put("productId", product.getProductId());
        p.put("doe", product.getDoe());
        p.put("name", product.getName());
        p.put("startDate", product.getStartDate());
        p.put("endDate", product.getEndDate());
        p.put("description", product.getDescription());
        p.put("remark", product.getRemark());
        p.put("logoPath", product.getLogoPath());
        p.put("uploadPath", product.getUploadPath());
        p.put("status", product.getStatus());
        p.put("byUserId", product.getByUserId());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        product.setProductId(pk);
    }

    @Override
    public void update(Product product) {
        Map p = new HashMap();
        p.put("productId", product.getProductId());
        p.put("doe", product.getDoe());
        p.put("name", product.getName());
        p.put("startDate", product.getStartDate());
        p.put("endDate", product.getEndDate());
        p.put("description", product.getDescription());
        p.put("remark", product.getRemark());
        p.put("logoPath", product.getLogoPath());
        p.put("uploadPath", product.getUploadPath());
        p.put("status", product.getStatus());
        p.put("byUserId", product.getByUserId());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(Product product) {
        delete(product.getProductId());
    }

    @Override
    public void delete(Integer productId) {
        SqlParameterSource ps = new MapSqlParameterSource("productid", productId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public Product findById(Integer productId) {
        Product product = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new ProductRowMapper(), productId);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new ProductRowMapper());
    }

    @Override
    public List<Product> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new ProductRowMapper(), value);
    }
}
