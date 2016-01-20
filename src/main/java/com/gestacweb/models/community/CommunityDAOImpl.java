package com.gestacweb.models.community;

import com.gestacweb.models.BaseDAO;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class CommunityDAOImpl extends BaseDAO<Community> implements CommunityDAO {

    @Override
    public Community findById(long id) {
        Transaction t = getSession().beginTransaction();
        List result = getSession().getNamedQuery("findCommunityById").setLong("id", id ).list();
        if (result.size() > 0){
            t.commit();
            return (Community)result.get(0);
        }
        t.rollback();
        return null;
    }

    @Override
    public Set<Community> getAll() {
        Transaction t = getSession().beginTransaction();
        Set<Community> result = new LinkedHashSet<Community>(getSession().getNamedQuery("findAllCommunities").list());
        t.commit();
        return result;
    }
}
