package com.knowshare.servlets.area;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.area.Area;
import com.knowshare.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "ManageAreaServlet", urlPatterns = "/manageareas")
public class ManageAreaServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(ManageAreaServlet.class);


    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        Set<Area> areasList = DAOFactory.getDAO(DAOType.AREA).getAll();
        request.setAttribute(WebConstants.AREAS_LIST, areasList);

        request.getRequestDispatcher("/manage-areas.jsp").forward(request, response);
    }

}
