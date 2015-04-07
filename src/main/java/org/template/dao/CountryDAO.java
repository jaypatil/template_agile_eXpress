package org.template.dao;

import java.util.List;
import org.template.domain.Country;

public interface CountryDAO {

    public void save(Country country);

    public void update(Country country);

    public void delete(Country country);

    public void delete(Integer country);

    public Country findById(Integer countryId);

    public List<Country> findAll();

    public List<Country> findByProperty(String property, Object value);
}
