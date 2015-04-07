package org.template.dao;

import java.util.List;
import org.template.domain.Sprintbacklog;

public interface SprintbacklogDAO {

    public void save(Sprintbacklog sprintbacklog);

    public void update(Sprintbacklog sprintbacklog);

    public void delete(Sprintbacklog sprintbacklog);

    public void delete(Integer sprintbacklog);

    public Sprintbacklog findById(Integer sprintbacklogId);

    public List<Sprintbacklog> findAll();

    public List<Sprintbacklog> findByProperty(String property, Object value);
}
