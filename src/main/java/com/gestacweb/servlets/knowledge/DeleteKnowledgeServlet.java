package com.gestacweb.servlets.knowledge;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.knowledge.Knowledge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "DeleteKnowledgeServlet", urlPatterns = "/deleteknowledge")
public class DeleteKnowledgeServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(DeleteKnowledgeServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside delete problem doGet");

        long knowledgeId = Long.parseLong(request.getParameter("id"));
        Knowledge knowledge = (Knowledge)DAOFactory.getDAO(DAOType.KNOWLEDGE).findById(knowledgeId);
        knowledge.setValid(false);
        DAOFactory.getDAO(DAOType.PROBLEM).update(knowledge);
        response.sendRedirect("manageknowledge");
    }

}
