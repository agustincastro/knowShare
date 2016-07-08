package com.gestacweb.servlets.knowledge;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "ManageKnowledgeServlet", urlPatterns = "/manageknowledge")
public class ManageKnowledgeServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(ManageKnowledgeServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        Set<Knowledge> knowledgeList = DAOFactory.getDAO(DAOType.KNOWLEDGE).getAll();
        request.setAttribute(WebConstants.KNOWLEDGES_LIST, knowledgeList);

        request.getRequestDispatcher("manage-knowledge.jsp").forward(request, response);

    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        String title = request.getParameter("title");
        String briefDescription = request.getParameter("brief_description");
        String description = request.getParameter("description");
        String keywords = request.getParameter("keywords");
        String videoUrl = request.getParameter("videoUrl");

        double timeToSolved = Double.parseDouble(request.getParameter("time_to_solved"));
        double usageFrequency = Double.parseDouble(request.getParameter("usage_frequency"));
        double veracity = Double.parseDouble(request.getParameter("veracity"));

        long problemId = Long.parseLong(request.getParameter("problem"));
        long sourceWhoWroteId = Long.parseLong(request.getParameter("source_who_wrote"));
        long sourceWithKnowledgeId = Long.parseLong(request.getParameter("source_with_knowledge"));

        Knowledge knowledge = new Knowledge();
        knowledge.setTitle(title);
        knowledge.setBriefDescription(briefDescription);
        knowledge.setDescription(description);
        knowledge.setKeywords(keywords);
        knowledge.setVideoUrl(videoUrl);

        knowledge.setTimeToSolved(timeToSolved);
        knowledge.setUsageFrecuency(usageFrequency);
        knowledge.setVeracity(veracity);

        /*
        Problem problem = (Problem)DAOFactory.getDAO(DAOType.PROBLEM).findById(problemId);
        knowledge.setProblem(problem);

        Source sourceWhoWrote = (Source) DAOFactory.getDAO(DAOType.SOURCE).findById(sourceWhoWroteId);
        knowledge.setSourceWhoWrote(sourceWhoWrote);

        Source sourceWithKnowledge = (Source) DAOFactory.getDAO(DAOType.SOURCE).findById(sourceWithKnowledgeId);
        knowledge.setSourceWithKnowledge(sourceWithKnowledge);
        */

        DAOFactory.getDAO(DAOType.KNOWLEDGE).save(knowledge);

        response.sendRedirect("newknowledge");

    }

}
