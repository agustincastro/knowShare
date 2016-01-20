package com.gestacweb.servlets.area;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.area.Area;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "EditAreaServlet", urlPatterns = "/editarea")
public class EditAreaServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(EditAreaServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        long areaId = Long.parseLong(request.getParameter("id"));
        Area area = (Area) DAOFactory.getDAO(DAOType.AREA).findById(areaId);
        request.setAttribute(WebConstants.AREA, area);

        request.getRequestDispatcher("/area.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        long areaId = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        description = description.length() <= 255 ? description : description.substring(0,255);

        LOG.debug("NAME = " + name);
        LOG.debug("DESCRIPTION = " + description);

        Area area = (Area) DAOFactory.getDAO(DAOType.AREA).findById(areaId);
        area.setName(name);
        area.setDescription(description);

        DAOFactory.getDAO(DAOType.AREA).update(area);

        response.sendRedirect("manageareas");

    }
}
