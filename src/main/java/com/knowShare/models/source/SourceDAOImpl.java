package com.knowshare.models.source;

import com.knowshare.models.BaseDAO;
import com.knowshare.utils.BCrypt;
import java.util.ArrayList;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class SourceDAOImpl extends BaseDAO<Source> implements SourceDAO {

    @Override
    public void save(Source source){
        source.setPassword(BCrypt.hashpw(source.getPassword(), BCrypt.gensalt()));
        source.setValid(false);
        super.save(source);
    }

    @Override
    public Source findById(long id) {
        Transaction t = getSession().beginTransaction();
        List result = getSession().getNamedQuery("findSourceById").setLong("id", id ).list();
        if (result.size() > 0){
            t.commit();
            return (Source)result.get(0);
        }
        t.rollback();
        return null;
    }

    @Override
    public Set<Source> getAll() {
        Transaction t = getSession().beginTransaction();
        Set<Source> result = new LinkedHashSet<>(getSession().getNamedQuery("findAllSources").list());
        for(Source source: result){
            Hibernate.initialize(source.getArea());
        }
        t.commit();
        return result;
    }

    @Override
    public List<Source> getMostRatedSources() {
        Transaction t = getSession().beginTransaction();
        List<Source> result = new ArrayList<>();
        try {
                result = getSession().getNamedQuery("findAllSourcesOrderByRating")
                .setMaxResults(5)
                .list();
        }
        catch(StringIndexOutOfBoundsException e) {
            
        }
        t.commit();
        return result;
    }
}
