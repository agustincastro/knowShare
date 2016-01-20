package com.gestacweb.servlets.knowledge;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.models.knowledge.KnowledgeDAO;
import com.gestacweb.models.user.User;
import com.gestacweb.models.user.UserDAO;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "KnowledgesToImproveServlet", urlPatterns = "/knowledges-to-improve")
public class KnowledgesToImproveServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(KnowledgesToImproveServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        String loggedUserName = (String) request.getSession().getAttribute(WebConstants.LOGGED_USER);
        User user = ((UserDAO) DAOFactory.getDAO(DAOType.USER)).findByEmail(loggedUserName);

        Set<Knowledge> knowledgeList = ((KnowledgeDAO)DAOFactory.getDAO(DAOType.KNOWLEDGE)).getKnowledgesToBeImproved(user.getId());
        request.setAttribute(WebConstants.KNOWLEDGES_LIST, knowledgeList);

        request.getRequestDispatcher("knowledges-to-improve.jsp").forward(request, response);

    }
}
