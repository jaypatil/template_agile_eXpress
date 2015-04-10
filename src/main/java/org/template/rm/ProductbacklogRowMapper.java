package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.ProductBacklog;

public class ProductbacklogRowMapper implements RowMapper<ProductBacklog> {

    @Override
    public ProductBacklog mapRow(ResultSet rs, int i) throws SQLException {
        ProductBacklog productbacklog = new ProductBacklog();
        productbacklog.setProductBacklogId(rs.getInt("productBacklogId"));
        productbacklog.setName(rs.getString("name"));
        productbacklog.setDoe(rs.getDate("doe"));
        productbacklog.setModuleId(rs.getInt("moduleId"));
        productbacklog.setPriority(rs.getInt("priority"));
        productbacklog.setDescription(rs.getString("description"));
        productbacklog.setUserStory(rs.getString("userStory"));
        productbacklog.setUploadPath(rs.getString("uploadPath"));
        productbacklog.setStatus(rs.getString("status"));
        productbacklog.setByUserId(rs.getInt("byUserId"));
        productbacklog.setReason(rs.getString("reason"));
        productbacklog.setStatusUpdatedBy(rs.getInt("statusUpdatedBy"));
        productbacklog.setProductId(rs.getInt("productId"));
        return productbacklog;
    }
}
