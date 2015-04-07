package org.template.dao;

import java.util.List;
import org.template.domain.State;

public interface StateDAO {

    public void save(State state);

    public void update(State state);

    public void delete(State state);

    public void delete(Integer state);

    public State findById(Integer stateId);

    public List<State> findAll();

    public List<State> findByProperty(String property, Object value);
}
