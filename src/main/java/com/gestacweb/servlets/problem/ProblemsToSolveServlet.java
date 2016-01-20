package com.gestacweb.servlets.problem;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.problem.Problem;
import com.gestacweb.models.problem.ProblemDAO;
import com.gestacweb.models.source.Source;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;


@WebServlet(name = "ProblemsToSolveServlet", urlPatterns = "/problems-to-solve")
public class ProblemsToSolveServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(ProblemsToSolveServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // check if there are unsolved problems
        List<Problem> unsolvedProblems = ((ProblemDAO)DAOFactory.getDAO(DAOType.PROBLEM)).getUnsolvedProblems();
        LOG.debug("UNSOLVED PROBLEMS SIZE = " + unsolvedProblems.size());
        request.setAttribute(WebConstants.UNSOLVED_PROBLEMS, unsolvedProblems);

        request.getRequestDispatcher("problems-to-solve.jsp").forward(request, response);
    }


}
