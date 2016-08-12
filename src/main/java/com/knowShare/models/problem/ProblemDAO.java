package com.knowshare.models.problem;

import com.knowshare.models.DAO;

import java.util.List;


public interface ProblemDAO extends DAO<Problem>{

    List<Problem> getUnsolvedProblems();
    List<Problem> getProblemsToBeImproved(long sourceId);

}
