package com.gestacweb.servlets.problem;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.problem.Problem;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "ManageProblemsServlet", urlPatterns = "/manageproblems")
public class ManageProblemsServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(ManageProblemsServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        Set<Problem> problemList = DAOFactory.getDAO(DAOType.PROBLEM).getAll();
        request.setAttribute(WebConstants.PROBLEMS_LIST, problemList);

        request.getRequestDispatcher("/manage-problems.jsp").forward(request, response);
    }

}
