package com.gestacweb.models.problem;

import com.gestacweb.models.BaseDAO;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class ProblemDAOImpl extends BaseDAO<Problem> implements ProblemDAO {

    public ProblemDAOImpl(){
        super();
    }

    @Override
    public Problem findById(long id) {
        Transaction t = getSession().beginTransaction();
        List result = getSession().getNamedQuery("findProblemById").setLong("id", id ).list();
        if (result.size() > 0){
            t.commit();
            return (Problem)result.get(0);
        }
        t.rollback();
        return null;
    }

    @Override
    public Set<Problem> getAll() {
        Transaction t = getSession().beginTransaction();
        Set<Problem> result = new LinkedHashSet<Problem>(getSession().getNamedQuery("findAllProblems").list());
        t.commit();
        return result;
    }

    @Override
    public List<Problem> getUnsolvedProblems() {
        Transaction t  = getSession().beginTransaction();
        List<Problem> result = getSession().getNamedQuery("findUnsolvedProblems").list();
        t.commit();
        return result;
    }

    @Override
    public List<Problem> getProblemsToBeImproved(long sourceId) {
        Transaction t =  getSession().beginTransaction();
        List<Problem> result = getSession().getNamedQuery("findProblemsToImprove")
                .setLong("sourceId", sourceId).list();
        t.commit();
        return result;
    }
}
