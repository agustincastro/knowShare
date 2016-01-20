package com.gestacweb.models.area;

import com.gestacweb.models.BaseDAO;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class AreaDAOImpl extends BaseDAO<Area> implements AreaDAO {
    @Override
    public Area findById(long id) {
        Transaction t = getSession().beginTransaction();
        List result = getSession().getNamedQuery("findAreaById").setLong("id", id ).list();
        if (result.size() > 0){
            t.commit();
            return (Area)result.get(0);
        }
        t.rollback();
        return null;
    }

    @Override
    public Set<Area> getAll() {
        Transaction t = getSession().beginTransaction();
        Set<Area> result = new LinkedHashSet<Area>(getSession().getNamedQuery("findAllAreas").list());
        t.commit();
        return result;
    }
}
