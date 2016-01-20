package com.gestacweb.servlets;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.models.knowledge.KnowledgeDAO;
import com.gestacweb.models.problem.Problem;
import com.gestacweb.models.problem.ProblemDAO;
import com.gestacweb.models.source.Source;
import com.gestacweb.models.source.SourceDAO;
import com.gestacweb.models.user.User;
import com.gestacweb.models.user.UserDAO;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet{

    private static Logger LOG = LogManager.getLogger(IndexServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // load sources
        List sources = ((SourceDAO)DAOFactory.getDAO(DAOType.SOURCE)).getMostRatedSources();
        LOG.debug("SOURCES SIZE = " + sources.size());
        request.setAttribute(WebConstants.SOURCES_LIST, sources);

        // load knowledges
        Set<Knowledge> knowledges = DAOFactory.getDAO(DAOType.KNOWLEDGE).getAll();
        LOG.debug("KNOWLEDGES SIZE = " + knowledges.size());
        request.setAttribute(WebConstants.KNOWLEDGES_LIST, knowledges);

        // check if there are unsolved problems
        List<Problem> unsolvedProblems = ((ProblemDAO)DAOFactory.getDAO(DAOType.PROBLEM)).getUnsolvedProblems();
        LOG.debug("UNSOLVED PROBLEMS SIZE = " + unsolvedProblems.size());
        request.setAttribute(WebConstants.UNSOLVED_PROBLEMS, unsolvedProblems.size() > 0);

        String loggedUserName = (String) request.getSession().getAttribute(WebConstants.LOGGED_USER);
        User user = ((UserDAO)DAOFactory.getDAO(DAOType.USER)).findByEmail(loggedUserName);
        if(user.getType() != null && user.getType().equals(WebConstants.SOURCE)){
            Source source = (Source) user;
            request.getSession().setAttribute(WebConstants.SOURCE_RATED, source.isValid());
            request.setAttribute(WebConstants.LOGGED_USER_ID, user.getId());
            if(!source.isValid()){
                request.setAttribute(WebConstants.SOURCE, source);
                response.sendRedirect("ratesource");
                return;
            }
        }


        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

    }
}
