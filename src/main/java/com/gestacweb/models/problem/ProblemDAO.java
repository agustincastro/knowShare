package com.gestacweb.models.problem;

import com.gestacweb.models.DAO;

import java.util.List;


public interface ProblemDAO extends DAO<Problem>{

    List<Problem> getUnsolvedProblems();
    List<Problem> getProblemsToBeImproved(long sourceId);

}
