package org.template.dao;

import java.util.List;
import org.template.domain.ProductBacklog;

public interface ProductBacklogDAO {

    public void save(ProductBacklog productBacklog);

    public void update(ProductBacklog productBacklog);

    public void delete(ProductBacklog productBacklog);

    public void delete(Integer productBacklog);

    public ProductBacklog findById(Integer productBacklogId);

    public List<ProductBacklog> findAll();

    public List<ProductBacklog> findByProperty(String property, Object value);
}
