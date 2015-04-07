package org.template.dao;

import java.util.List;
import org.template.domain.User;

public interface UserDAO {

    public void save(User user);

    public void update(User user);

    public void delete(User user);

    public void delete(Integer user);

    public User findById(Integer userId);

    public List<User> findAll();

    public List<User> findByProperty(String property, Object value);
}
