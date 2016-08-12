package com.knowshare.servlets.area;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.area.Area;
import com.knowshare.models.community.Community;
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
        Area area = (Area)DAOFactory.getDAO(DAOType.AREA).findById(areaId);
        area.setValid(false);
        DAOFactory.getDAO(DAOType.AREA).update(area);
        response.sendRedirect("manageareas");
    }
}
