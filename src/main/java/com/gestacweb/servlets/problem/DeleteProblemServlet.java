package com.gestacweb.servlets.problem;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.problem.Problem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "DeleteProblemServlet", urlPatterns = "/deleteproblem")
public class DeleteProblemServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(DeleteProblemServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside delete problem doGet");

        long problemId = Long.parseLong(request.getParameter("id"));
        Problem problem = (Problem)DAOFactory.getDAO(DAOType.PROBLEM).findById(problemId);
        DAOFactory.getDAO(DAOType.PROBLEM).delete(problem);

        response.sendRedirect("manageknowledge");
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside delete problem doPost");

        long problemId = Long.parseLong(request.getParameter("id"));
        Problem problem = (Problem)DAOFactory.getDAO(DAOType.PROBLEM).findById(problemId);
        DAOFactory.getDAO(DAOType.PROBLEM).delete(problem);

        response.sendRedirect("manageknowledge");

    }

}
