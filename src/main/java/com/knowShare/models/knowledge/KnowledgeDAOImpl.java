package com.knowshare.models.knowledge;

import com.knowshare.models.BaseDAO;
import com.knowshare.models.problem.Problem;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class KnowledgeDAOImpl extends BaseDAO<Knowledge> implements KnowledgeDAO{

    @Override
    public void save(Knowledge knowledge){

        updateRating(knowledge);

        super.save(knowledge);
    }

    @Override
    public void update(Knowledge knowledge) {

        updateRating(knowledge);

        super.update(knowledge);
    }
    
    @Override
    public void delete(Knowledge knowledge) {
        super.delete(knowledge);
    }

    @Override
    public Knowledge findById(long id) {
        Transaction t = getSession().beginTransaction();
        List result = getSession().getNamedQuery("findKnowledgeById").setLong("id", id ).list();
        if (result.size() > 0){
            Knowledge knowledge = (Knowledge) result.get(0);
            Hibernate.initialize(knowledge.getSourceWhoWrote());
            Hibernate.initialize(knowledge.getSourceWithKnowledge());
            Hibernate.initialize(knowledge.getSourceCanImprove());
            Hibernate.initialize(knowledge.getProblem());
            t.commit();
            return knowledge;
        }
        t.rollback();
        return null;
    }

    @Override
    public Set<Knowledge> getAll() {
        Transaction t = getSession().beginTransaction();
        Set<Knowledge> result = new LinkedHashSet<Knowledge>(getSession().getNamedQuery("findAllKnowledges").list());
        for(Knowledge knowledge : result){
            Hibernate.initialize(knowledge.getProblem());
        }
        t.commit();
        return result;
    }

    @Override
    public Set<Knowledge> getKnowledgesThatSolvedProblems() {
        Transaction t = getSession().beginTransaction();
        Set<Knowledge> result = new LinkedHashSet<Knowledge>(getSession().getNamedQuery("findKnowledgesThatSolvedProblem").list());
        for(Knowledge knowledge : result){
            Hibernate.initialize(knowledge.getProblem());
            Hibernate.initialize(knowledge.getProblem().getArea());
            Hibernate.initialize(knowledge.getSourceWithKnowledge());
            Hibernate.initialize(knowledge.getSourceCanImprove());
        }
        t.commit();
        return result;
    }

    @Override
    public Set<Knowledge> getKnowledgesToBeImproved(long sourceId) {
        Transaction t = getSession().beginTransaction();
        Set<Knowledge> result = new LinkedHashSet<Knowledge>(getSession().getNamedQuery("findKnowledgesToImprove")
                .setLong("sourceId", sourceId).list());
        for(Knowledge knowledge : result){
            Hibernate.initialize(knowledge.getProblem());
            Hibernate.initialize(knowledge.getProblem().getArea());
            Hibernate.initialize(knowledge.getSourceWithKnowledge());
            Hibernate.initialize(knowledge.getSourceCanImprove());
        }
        t.commit();
        return result;
    }

    @Override
    public Set<Knowledge> getMostRatedKnowledges() {
        Set<Knowledge> result = new LinkedHashSet<Knowledge>(getSession().getNamedQuery("findAllKnowledgesOrderByRating")
                .setMaxResults(5)
                .list());
        return result;
    }

    private void updateRating(Knowledge knowledge){

        double rating = (knowledge.getSourceWithKnowledge().getExpertiseLevel() + knowledge.getVeracity() + knowledge.getTimeToSolved() + knowledge.getUsageFrecuency()) / 3d;
        knowledge.setRating(rating);

    }
}
