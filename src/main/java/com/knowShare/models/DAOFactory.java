package com.knowshare.models;

import com.knowshare.models.area.AreaDAOImpl;
import com.knowshare.models.community.CommunityDAOImpl;
import com.knowshare.models.knowledge.KnowledgeDAOImpl;
import com.knowshare.models.problem.ProblemDAOImpl;
import com.knowshare.models.source.SourceDAOImpl;
import com.knowshare.models.user.UserDAOImpl;


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
