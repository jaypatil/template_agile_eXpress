package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.SubTask;

public class SubtaskRowMapper implements RowMapper<SubTask> {

    @Override
    public SubTask mapRow(ResultSet rs, int i) throws SQLException {
        SubTask subtask = new SubTask();
        subtask.setSubTaskId(rs.getInt("subTaskId"));
        subtask.setSprintBacklogId(rs.getInt("sprintBacklogId"));
        subtask.setName(rs.getString("name"));
        subtask.setDoe(rs.getDate("doe"));
        subtask.setStatus(rs.getString("status"));
        subtask.setTotalTime(rs.getString("totalTime"));
        subtask.setSummary(rs.getString("summary"));
        subtask.setStartDate(rs.getDate("startDate"));
        subtask.setCompleteDate(rs.getDate("completeDate"));
        subtask.setAssignedTo(rs.getInt("assignedTo"));
        subtask.setAssignedDate(rs.getDate("assignedDate"));
        return subtask;
    }
}
