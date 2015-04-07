package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.Module;

public class ModuleRowMapper implements RowMapper<Module> {

    @Override
    public Module mapRow(ResultSet rs, int i) throws SQLException {
        Module module = new Module();
        module.setModuleId(rs.getInt("moduleId"));
        module.setName(rs.getString("name"));
        module.setDoe(rs.getDate("doe"));
        module.setDescription(rs.getString("description"));
        module.setStatus(rs.getString("status"));
        module.setProductId(rs.getInt("productId"));
        return module;
    }
}
