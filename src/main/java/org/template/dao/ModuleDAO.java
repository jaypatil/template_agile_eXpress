package org.template.dao;

import java.util.List;
import org.template.domain.Module;

public interface ModuleDAO {

    public void save(Module module);

    public void update(Module module);

    public void delete(Module module);

    public void delete(Integer module);

    public Module findById(Integer moduleId);

    public List<Module> findAll();

    public List<Module> findByProperty(String property, Object value);
}
