package org.template.dao;

import java.util.List;
import org.template.domain.Subtask;

public interface SubtaskDAO {

    public void save(Subtask subtask);

    public void update(Subtask subtask);

    public void delete(Subtask subtask);

    public void delete(Integer subtask);

    public Subtask findById(Integer subtaskId);

    public List<Subtask> findAll();

    public List<Subtask> findByProperty(String property, Object value);
}
