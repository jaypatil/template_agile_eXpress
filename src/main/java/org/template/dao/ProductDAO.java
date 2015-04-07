package org.template.dao;

import java.util.List;
import org.template.domain.Product;

public interface ProductDAO {

    public void save(Product product);

    public void update(Product product);

    public void delete(Product product);

    public void delete(Integer product);

    public Product findById(Integer productId);

    public List<Product> findAll();

    public List<Product> findByProperty(String property, Object value);
}
