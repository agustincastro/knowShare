package com.knowshare.servlets.knowledge;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.knowledge.Knowledge;
import com.knowshare.models.problem.Problem;
import com.knowshare.models.source.Source;
import com.knowshare.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "EditKnowledgeServlet", urlPatterns = "/editknowledge")
public class EditKnowledgeServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(EditKnowledgeServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // load knowledge
        long knowledgeId = Long.parseLong(request.getParameter("id"));
        Knowledge knowledge = (Knowledge)DAOFactory.getDAO(DAOType.KNOWLEDGE).findById(knowledgeId);
        request.setAttribute(WebConstants.KNOWLEDGE, knowledge);

        // get all problems to be shown on select input
        Set<Problem> problemsList = DAOFactory.getDAO(DAOType.PROBLEM).getAll();
        request.setAttribute(WebConstants.PROBLEMS_LIST, problemsList);

        // get all sources to be shown on select input
        Set<Source> sourcesList = knowledge.getProblem().getArea().getSources();
        request.setAttribute(WebConstants.SOURCES_LIST, sourcesList);


        request.getRequestDispatcher("knowledge.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        long knowledgeId = Long.parseLong(request.getParameter("id"));
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

        Knowledge knowledge = (Knowledge)DAOFactory.getDAO(DAOType.KNOWLEDGE).findById(knowledgeId);
        knowledge.setTitle(title);
        knowledge.setBriefDescription(briefDescription);
        knowledge.setDescription(description);
        knowledge.setKeywords(keywords);
        knowledge.setVideoUrl(videoUrl);

        knowledge.setTimeToSolved(timeToSolved);
        knowledge.setUsageFrecuency(usageFrequency);
        knowledge.setVeracity(veracity);

        Problem problem = (Problem) DAOFactory.getDAO(DAOType.PROBLEM).findById(problemId);
        knowledge.setProblem(problem);

        Source sourceWhoWrote = (Source) DAOFactory.getDAO(DAOType.SOURCE).findById(sourceWhoWroteId);
        knowledge.setSourceWhoWrote(sourceWhoWrote);

        Source sourceWithKnowledge = (Source) DAOFactory.getDAO(DAOType.SOURCE).findById(sourceWithKnowledgeId);
        knowledge.setSourceWithKnowledge(sourceWithKnowledge);

        if(knowledge.getTitle().indexOf("-") > 0){
            String newTitle = knowledge.getTitle().substring(0, knowledge.getTitle().indexOf("-"))
                    + String.format(" - mejorado por %s %s", sourceWhoWrote.getName(), sourceWhoWrote.getLastName());
            knowledge.setTitle(newTitle);
        }else{
            String newTitle = knowledge.getTitle()
                    + String.format(" - mejorado por %s %s", sourceWhoWrote.getName(), sourceWhoWrote.getLastName());
            knowledge.setTitle(newTitle);
        }


        DAOFactory.getDAO(DAOType.KNOWLEDGE).update(knowledge);

        response.sendRedirect("manageknowledge");

    }

}
