
package org.template.dao;

import java.util.List;
import org.template.domain.Assignedproduct;

public interface AssignedproductDAO {

    public void save(Assignedproduct assignedproduct);

    public void update(Assignedproduct assignedproduct);

    public void delete(Assignedproduct assignedproduct);

    public void delete(Integer assignedproduct);

    public Assignedproduct findById(Integer assignedproductId);

    public List<Assignedproduct> findAll();

    public List<Assignedproduct> findByProperty(String property, Object value);
}
