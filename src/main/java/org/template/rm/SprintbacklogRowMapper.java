package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.Sprintbacklog;

public class SprintbacklogRowMapper implements RowMapper<Sprintbacklog> {

    @Override
    public Sprintbacklog mapRow(ResultSet rs, int i) throws SQLException {
        Sprintbacklog sprintbacklog = new Sprintbacklog();
        sprintbacklog.setSprintBacklogId(rs.getInt("sprintBacklogId"));
        sprintbacklog.setSprintBacklogId(rs.getInt("sprintId"));
        sprintbacklog.setProductBacklogId(rs.getInt("productBacklogId"));
        sprintbacklog.setSize(rs.getString("size"));
        sprintbacklog.setDoe(rs.getDate("doe"));
        sprintbacklog.setByUserId(rs.getInt("byUserId"));
        return sprintbacklog;
    }
}
