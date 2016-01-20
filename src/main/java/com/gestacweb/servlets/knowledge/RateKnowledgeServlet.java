package com.gestacweb.servlets.knowledge;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.models.source.Source;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;


@WebServlet(name = "RateKnowledgeServlet", urlPatterns = "/rateknowledge")
public class RateKnowledgeServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(ManageKnowledgeServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        long knowledgeId = Long.parseLong(request.getParameter("id"));

        Knowledge knowledge = (Knowledge) DAOFactory.getDAO(DAOType.KNOWLEDGE).findById(knowledgeId);
        request.setAttribute(WebConstants.KNOWLEDGE, knowledge);

        request.getRequestDispatcher("rate-knowledge.jsp").forward(request, response);

    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");


        if(request.getParameter("source_id") != null){
            long sourceId = Long.parseLong(request.getParameter("source_id"));
            Source source = (Source) DAOFactory.getDAO(DAOType.SOURCE).findById(sourceId);

            double q1 = request.getParameter("question_1") != null ? Double.parseDouble(request.getParameter("question_1")) : 0d;
            double q2 = request.getParameter("question_2") != null ? Double.parseDouble(request.getParameter("question_2")) : 0d;
            double workExperience = (q1 + q2)/2d;

            double q3 = request.getParameter("question_3") != null ? Double.parseDouble(request.getParameter("question_3")) : 0d;
            double knowledgeLevel = q3;

            double expertiseLevel =  (source.getExpertiseLevel() + workExperience + knowledgeLevel) / 3d;
            source.setExpertiseLevel(expertiseLevel);
            DAOFactory.getDAO(DAOType.SOURCE).update(source);
        }

        long knowledgeId = Long.parseLong(request.getParameter("id"));
        double timeToSolved = request.getParameter("time_to_solved") != null ? Double.parseDouble(request.getParameter("time_to_solved")) : 0d;
        double usageFrequency = request.getParameter("usage_frequency") != null ? Double.parseDouble(request.getParameter("usage_frequency")) : 0d;
        double veracity = request.getParameter("veracity") != null ? Double.parseDouble(request.getParameter("veracity")) : 0d;

        Knowledge knowledge = (Knowledge) DAOFactory.getDAO(DAOType.KNOWLEDGE).findById(knowledgeId);

        knowledge.setTimeToSolved(timeToSolved);
        knowledge.setUsageFrecuency(usageFrequency);
        knowledge.setVeracity(veracity);

        DAOFactory.getDAO(DAOType.KNOWLEDGE).update(knowledge);

        response.sendRedirect("manageknowledges");

    }
}
