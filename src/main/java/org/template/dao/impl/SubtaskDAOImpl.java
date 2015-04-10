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
import org.template.dao.SubTaskDAO;
import org.template.domain.SubTask;
import org.template.rm.SubtaskRowMapper;

@Repository
public class SubtaskDAOImpl extends BaseDAO implements SubTaskDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO Subtask ( subTaskId, sprintBacklogId, name, doe, status, totalTime, summary, startDate, completeDate, assignedTo, assignedDate) VALUES( :subTaskId, :sprintBacklogId, :name, :doe, :status, :totalTime, :summary, :startDate, :completeDate, :assignedTo, :assignedDate)";
    private static final String SQL_UPDATE_QUERY = "UPDATE Subtask SET subTaskId = :subTaskId, sprintBacklogId = :sprintBacklogId, name = :name, doe = :doe, status = :status, totalTime = :totalTime, summary = :summary, startDate = :startDate, completeDate = :completeDate, assignedTo = :assignedTo, assignedDate = :assignedDate WHERE subTaskId= :subTaskId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM Subtask WHERE subTaskId= :subTaskId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM Subtask";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM Subtask WHERE subTaskId= :subTaskId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM Subtask WHERE subTaskId?";

    @Override
    public void save(SubTask subtask) {
        Map p = new HashMap();
        p.put("subTaskId", subtask.getSubTaskId());
        p.put("sprintBacklogId", subtask.getSprintBacklogId());
        p.put("name", subtask.getName());
        p.put("doe", subtask.getDoe());
        p.put("status", subtask.getStatus());
        p.put("totalTime", subtask.getTotalTime());
        p.put("summary", subtask.getSummary());
        p.put("startDate", subtask.getStartDate());
        p.put("completeDate", subtask.getCompleteDate());
        p.put("assignedTo", subtask.getAssignedTo());
        p.put("assignedDate", subtask.getAssignedDate());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        subtask.setSubTaskId(pk);
    }

    @Override
    public void update(SubTask subtask) {
        Map p = new HashMap();
        p.put("subTaskId", subtask.getSubTaskId());
        p.put("sprintBacklogId", subtask.getSprintBacklogId());
        p.put("name", subtask.getName());
        p.put("doe", subtask.getDoe());
        p.put("status", subtask.getStatus());
        p.put("totalTime", subtask.getTotalTime());
        p.put("summary", subtask.getSummary());
        p.put("startDate", subtask.getStartDate());
        p.put("completeDate", subtask.getCompleteDate());
        p.put("assignedTo", subtask.getAssignedTo());
        p.put("assignedDate", subtask.getAssignedDate());
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(SubTask subtask) {
        delete(subtask.getSubTaskId());
    }

    @Override
    public void delete(Integer subtaskId) {
        SqlParameterSource ps = new MapSqlParameterSource("subtaskid", subtaskId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public SubTask findById(Integer subtaskId) {
        SubTask subtask = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new SubtaskRowMapper(), subtaskId);
        return subtask;
    }

    @Override
    public List<SubTask> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new SubtaskRowMapper());
    }

    @Override
    public List<SubTask> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new SubtaskRowMapper(), value);
    }
}
