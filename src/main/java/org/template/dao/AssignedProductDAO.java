
package org.template.dao;

import java.util.List;
import org.template.domain.AssignedProduct;

public interface AssignedProductDAO {

    public void save(AssignedProduct assignedProduct);

    public void update(AssignedProduct assignedProduct);

    public void delete(AssignedProduct assignedProduct);

    public void delete(Integer assignedProduct);

    public AssignedProduct findById(Integer assignedProductId);

    public List<AssignedProduct> findAll();

    public List<AssignedProduct> findByProperty(String property, Object value);
}
