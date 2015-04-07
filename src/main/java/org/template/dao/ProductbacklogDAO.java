package org.template.dao;

import java.util.List;
import org.template.domain.Productbacklog;

public interface ProductbacklogDAO {

    public void save(Productbacklog productbacklog);

    public void update(Productbacklog productbacklog);

    public void delete(Productbacklog productbacklog);

    public void delete(Integer productbacklog);

    public Productbacklog findById(Integer productbacklogId);

    public List<Productbacklog> findAll();

    public List<Productbacklog> findByProperty(String property, Object value);
}
