package org.template.dao;

import java.util.List;
import org.template.domain.SubTask;

public interface SubTaskDAO {

    public void save(SubTask subTask);

    public void update(SubTask subTask);

    public void delete(SubTask subTask);

    public void delete(Integer subTask);

    public SubTask findById(Integer subTaskId);

    public List<SubTask> findAll();

    public List<SubTask> findByProperty(String property, Object value);
}
