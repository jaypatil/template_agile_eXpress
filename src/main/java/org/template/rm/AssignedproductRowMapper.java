package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.AssignedProduct;

public class AssignedproductRowMapper implements RowMapper<AssignedProduct> {

    @Override
    public AssignedProduct mapRow(ResultSet rs, int i) throws SQLException {
        AssignedProduct assignedproduct = new AssignedProduct();
        assignedproduct.setAssignedProductId(rs.getInt("assignedProductId"));
        assignedproduct.setProductId(rs.getInt("productId"));
        assignedproduct.setUserId(rs.getInt("userId"));
        assignedproduct.setDoe(rs.getDate("doe"));
        assignedproduct.setByUserId(rs.getInt("byUserId"));
        return assignedproduct;
    }
}
