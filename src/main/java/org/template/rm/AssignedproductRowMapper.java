package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.Assignedproduct;

public class AssignedproductRowMapper implements RowMapper<Assignedproduct> {

    @Override
    public Assignedproduct mapRow(ResultSet rs, int i) throws SQLException {
        Assignedproduct assignedproduct = new Assignedproduct();
        assignedproduct.setAssignedProductId(rs.getInt("assignedProductId"));
        assignedproduct.setProductId(rs.getInt("productId"));
        assignedproduct.setUserId(rs.getInt("userId"));
        assignedproduct.setDoe(rs.getDate("doe"));
        assignedproduct.setByUserId(rs.getInt("byUserId"));
        return assignedproduct;
    }
}
