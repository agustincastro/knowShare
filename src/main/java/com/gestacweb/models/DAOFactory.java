package com.gestacweb.models;

import com.gestacweb.models.area.AreaDAOImpl;
import com.gestacweb.models.community.CommunityDAOImpl;
import com.gestacweb.models.knowledge.KnowledgeDAOImpl;
import com.gestacweb.models.problem.ProblemDAOImpl;
import com.gestacweb.models.source.SourceDAOImpl;
import com.gestacweb.models.user.UserDAOImpl;


public class DAOFactory {

    public static DAO getDAO(DAOType daoType){
        switch (daoType){
            case USER:
                return new UserDAOImpl();
            case PROBLEM:
                return new ProblemDAOImpl();
            case SOURCE:
                return new SourceDAOImpl();
            case AREA:
                return new AreaDAOImpl();
            case COMMUNITY:
                return new CommunityDAOImpl();
            case KNOWLEDGE:
                return new KnowledgeDAOImpl();
            default:
                return null;
        }

    }

}
