package org.template.dao;

import java.util.List;
import org.template.domain.SprintBacklog;

public interface SprintBacklogDAO {

    public void save(SprintBacklog sprintBacklog);

    public void update(SprintBacklog sprintBacklog);

    public void delete(SprintBacklog sprintBacklog);

    public void delete(Integer sprintBacklog);

    public SprintBacklog findById(Integer sprintBacklogId);

    public List<SprintBacklog> findAll();

    public List<SprintBacklog> findByProperty(String property, Object value);
}
