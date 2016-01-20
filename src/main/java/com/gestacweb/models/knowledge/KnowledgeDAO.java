package com.gestacweb.models.knowledge;

import com.gestacweb.models.DAO;

import java.util.List;
import java.util.Set;


public interface KnowledgeDAO extends DAO<Knowledge> {

    public Set<Knowledge> getKnowledgesThatSolvedProblems();
    public Set<Knowledge> getKnowledgesToBeImproved(long sourceId);
    public Set<Knowledge> getMostRatedKnowledges();

}
