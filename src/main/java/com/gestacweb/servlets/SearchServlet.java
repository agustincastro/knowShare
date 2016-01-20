package com.gestacweb.servlets;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.models.problem.Problem;
import com.gestacweb.models.source.Source;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(SearchServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        String query = request.getParameter("query");
        String queryType = request.getParameter("queryType");

        LOG.debug("QUERY = " + query);
        LOG.debug("QUERY TYPE = " + queryType);

        if (queryType.equals("PROBLEM")){

            LOG.debug("IS A PROBLEM QUERY");
            request.setAttribute(WebConstants.PROBLEMS_LIST, getProblemSearchResult(query));

        }else if(queryType.equals("SOURCE")){
            LOG.debug("IS A SOURCE QUERY");
            request.setAttribute(WebConstants.SOURCES_LIST, getSourceSearchResult(query));

        }else if(queryType.equals("KNOWLEDGE")){
            LOG.debug("IS A KNOWLEDGE QUERY");
            request.setAttribute(WebConstants.KNOWLEDGES_LIST, getKnowledgeSearchResult(query));

        }else{
            // all (both problems and sources
            LOG.debug("IS AN ALL QUERY");
            // PROBLEMS
            request.setAttribute(WebConstants.PROBLEMS_LIST, getProblemSearchResult(query));

            // SOURCES
            request.setAttribute(WebConstants.SOURCES_LIST, getSourceSearchResult(query));

            // KNOWLEDGES
            request.setAttribute(WebConstants.KNOWLEDGES_LIST, getKnowledgeSearchResult(query));

        }

        request.setAttribute(WebConstants.SEARCH_QUERY, query);
        request.setAttribute(WebConstants.SEARCH_QUERY_TYPE, queryType);

        request.getRequestDispatcher("/search.jsp").forward(request, response);

    }

    private List<Problem> getProblemSearchResult(String query){

        Set<Problem> problemList = DAOFactory.getDAO(DAOType.PROBLEM).getAll();

        List<Problem> queryResults = new ArrayList<Problem>();
        for(Problem problem : problemList){
            if(problem.getTitle().matches(".*" + query + ".*") || problem.getDescription().matches(".*" + query + ".*")){
                queryResults.add(problem);
            }
        }

        return queryResults;

    }

    private List<Source> getSourceSearchResult(String query){

        Set<Source> sourceList = DAOFactory.getDAO(DAOType.SOURCE).getAll();

        List<Source> queryResults = new ArrayList<Source>();
        for(Source source : sourceList){
            if(source.getName().matches(".*" + query + ".*") || source.getDescription().matches(".*" + query + ".*")){
                queryResults.add(source);
            }
        }

        return queryResults;

    }

    private List<Knowledge> getKnowledgeSearchResult(String query){
        Set<Knowledge> knowledgeList = DAOFactory.getDAO(DAOType.KNOWLEDGE).getAll();

        List<Knowledge> queryResults = new ArrayList<Knowledge>();
        for(Knowledge knowledge : knowledgeList){
            if(knowledge.getTitle().matches(".*" + query + ".*") || knowledge.getDescription().matches(".*" + query + ".*")){
                queryResults.add(knowledge);
            }
        }

        return queryResults;

    }

}

