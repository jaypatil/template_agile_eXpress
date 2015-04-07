package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.Sprint;

public class SprintRowMapper implements RowMapper<Sprint> {

    @Override
    public Sprint mapRow(ResultSet rs, int i) throws SQLException {
        Sprint sprint = new Sprint();
        sprint.setSprintId(rs.getInt("sprintId"));
        sprint.setSprintName(rs.getString("sprintName"));
        sprint.setDoe(rs.getDate("doe"));
        sprint.setDurationFrom(rs.getDate("durationFrom"));
        sprint.setDurationTo(rs.getDate("durationTo"));
        sprint.setDescription(rs.getString("description"));
        sprint.setScrumMasterUserId(rs.getInt("scrumMasterUserId"));
        sprint.setByUserId(rs.getInt("byUserId"));
        sprint.setStatus(rs.getString("status"));
        sprint.setProductId(rs.getInt("productId"));
        return sprint;
    }
}
