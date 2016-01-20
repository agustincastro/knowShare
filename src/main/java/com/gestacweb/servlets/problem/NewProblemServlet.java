package com.gestacweb.servlets.problem;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.area.Area;
import com.gestacweb.models.problem.Problem;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "NewProblemServlet", urlPatterns = "/newproblem")
public class NewProblemServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(NewProblemServlet.class);


    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // get all areas to be shown on select input
        Set<Area> areasList = DAOFactory.getDAO(DAOType.AREA).getAll();
        request.setAttribute(WebConstants.AREAS_LIST, areasList);

        request.getRequestDispatcher("/problem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        long areaId = Long.parseLong(request.getParameter("area"));

        LOG.debug("TITLE = " + title);
        LOG.debug("DESCRIPTION = " + description);
        LOG.debug("AREA = " + areaId);

        Problem problem = new Problem();
        problem.setTitle(title);
        problem.setDescription(description);

        Area area = (Area) DAOFactory.getDAO(DAOType.AREA).findById(areaId);
        if(area != null){
            problem.setArea(area);
            DAOFactory.getDAO(DAOType.PROBLEM).save(problem);

            request.setAttribute(WebConstants.SUCCESS_MSG, "El área ha sido guardada exitosamente");
        }else{
            request.setAttribute(WebConstants.ERROR_MSG, "El área seleccionada no existe en el sistema");
        }
        response.sendRedirect("newproblem");

    }


}
