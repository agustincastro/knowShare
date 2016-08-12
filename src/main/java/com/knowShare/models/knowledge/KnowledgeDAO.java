package com.knowshare.models.knowledge;

import com.knowshare.models.DAO;

import java.util.List;
import java.util.Set;


public interface KnowledgeDAO extends DAO<Knowledge> {

    public Set<Knowledge> getKnowledgesThatSolvedProblems();
    public Set<Knowledge> getKnowledgesToBeImproved(long sourceId);
    public Set<Knowledge> getMostRatedKnowledges();

}
