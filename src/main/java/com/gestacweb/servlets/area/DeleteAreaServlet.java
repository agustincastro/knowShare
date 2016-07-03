package com.gestacweb.servlets.area;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.area.Area;
import com.gestacweb.models.community.Community;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "DeleteAreaServlet", urlPatterns = "/deletearea")
public class DeleteAreaServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(DeleteAreaServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside area delete doGet");

        long areaId = Long.parseLong(request.getParameter("id"));
        Area area = (Area)DAOFactory.getDAO(DAOType.COMMUNITY).findById(areaId);
        DAOFactory.getDAO(DAOType.COMMUNITY).delete(area);

        response.sendRedirect("managearea");
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside area delete doGet");

        long areaId = Long.parseLong(request.getParameter("id"));
        Area area = (Area)DAOFactory.getDAO(DAOType.COMMUNITY).findById(areaId);
        DAOFactory.getDAO(DAOType.COMMUNITY).delete(area);

        response.sendRedirect("managearea");

    }

}
