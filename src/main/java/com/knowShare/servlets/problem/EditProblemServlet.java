package com.knowshare.servlets.problem;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.area.Area;
import com.knowshare.models.problem.Problem;
import com.knowshare.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "EditProblemServlet", urlPatterns = "/editproblem")
public class EditProblemServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(NewProblemServlet.class);


    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // load problem
        long problemId = Long.parseLong(request.getParameter("id"));
        Problem problem = (Problem)DAOFactory.getDAO(DAOType.PROBLEM).findById(problemId);
        request.setAttribute(WebConstants.PROBLEM, problem);

        // get all areas to be shown on select input
        Set<Area> areasList = DAOFactory.getDAO(DAOType.AREA).getAll();
        request.setAttribute(WebConstants.AREAS_LIST, areasList);

        request.getRequestDispatcher("/problem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        long problemId = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        long areaId = Long.parseLong(request.getParameter("area"));

        LOG.debug("TITLE = " + title);
        LOG.debug("DESCRIPTION = " + description);
        LOG.debug("AREA = " + areaId);

        Problem problem = (Problem) DAOFactory.getDAO(DAOType.PROBLEM).findById(problemId);
        problem.setTitle(title);
        problem.setDescription(description);


        Area area = (Area) DAOFactory.getDAO(DAOType.AREA).findById(areaId);
        if(area != null){
            problem.setArea(area);
            DAOFactory.getDAO(DAOType.PROBLEM).update(problem);

            request.setAttribute(WebConstants.SUCCESS_MSG, "El área ha sido guardada exitosamente");
        }else{
            request.setAttribute(WebConstants.ERROR_MSG, "El área seleccionada no existe en el sistema");
        }


        response.sendRedirect("manageproblems");

    }

}
