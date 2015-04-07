package org.template.dao;

import java.util.List;
import org.template.domain.City;

public interface CityDAO {

    public void save(City city);

    public void update(City city);

    public void delete(City city);

    public void delete(Integer city);

    public City findById(Integer cityId);

    public List<City> findAll();

    public List<City> findByProperty(String property, Object value);
}
