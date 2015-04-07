package org.template.dao;

import java.util.List;
import org.template.domain.Sprint;

public interface SprintDAO {

    public void save(Sprint sprint);

    public void update(Sprint sprint);

    public void delete(Sprint sprint);

    public void delete(Integer sprint);

    public Sprint findById(Integer sprintId);

    public List<Sprint> findAll();

    public List<Sprint> findByProperty(String property, Object value);
}
