package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.SprintBacklog;

public class SprintbacklogRowMapper implements RowMapper<SprintBacklog> {

    @Override
    public SprintBacklog mapRow(ResultSet rs, int i) throws SQLException {
        SprintBacklog sprintbacklog = new SprintBacklog();
        sprintbacklog.setSprintBacklogId(rs.getInt("sprintBacklogId"));
        sprintbacklog.setSprintBacklogId(rs.getInt("sprintId"));
        sprintbacklog.setProductBacklogId(rs.getInt("productBacklogId"));
        sprintbacklog.setSize(rs.getString("size"));
        sprintbacklog.setDoe(rs.getDate("doe"));
        sprintbacklog.setByUserId(rs.getInt("byUserId"));
        return sprintbacklog;
    }
}
