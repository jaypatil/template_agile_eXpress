package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.Product;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("productId"));
        product.setDoe(rs.getDate("doe"));
        product.setName(rs.getString("name"));
        product.setStartDate(rs.getDate("startDate"));
        product.setEndDate(rs.getDate("endDate"));
        product.setDescription(rs.getString("description"));
        product.setRemark(rs.getString("remark"));
        product.setLogoPath(rs.getString("logoPath"));
        product.setUploadPath(rs.getString("uploadPath"));
        product.setStatus(rs.getString("status"));
        product.setByUserId(rs.getInt("byUserId"));
        return product;
    }
}
