package com.knowshare.servlets.source;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.area.Area;
import com.knowshare.models.community.Community;
import com.knowshare.models.source.Source;
import com.knowshare.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "EditSourceServlet", urlPatterns = "/editsource")
public class EditSourceServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(EditSourceServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // load source
        long sourceId = Long.parseLong(request.getParameter("id"));
        Source source = (Source)DAOFactory.getDAO(DAOType.SOURCE).findById(sourceId);
        request.setAttribute(WebConstants.SOURCE, source);

        // get all areas to be shown on select input
        Set<Area> areasList = DAOFactory.getDAO(DAOType.AREA).getAll();
        request.setAttribute(WebConstants.AREAS_LIST, areasList);

        // get all communities to be shown on select input
        Set<Community> communitiesList = DAOFactory.getDAO(DAOType.COMMUNITY).getAll();
        request.setAttribute(WebConstants.COMMUNITIES_LIST, communitiesList);

        request.getRequestDispatcher("/source.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        long sourceId = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("last-name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String description = request.getParameter("description");
        String sourceType = request.getParameter("source_type");
        long areaId = Long.parseLong(request.getParameter("area"));
        long communityId = Long.parseLong(request.getParameter("community"));

        LOG.debug("EMAIL = " + email);
        LOG.debug("NAME = " + name);
        LOG.debug("LASTNAME = " + lastName);
        LOG.debug("PASSWORD = " + password);
        LOG.debug("SOURCE_TYPE = " + sourceType);
        LOG.debug("AREA = " + areaId);
        LOG.debug("COMMUNITY = " + communityId);

        Source source = (Source) DAOFactory.getDAO(DAOType.SOURCE).findById(sourceId);
        source.setName(name);
        source.setLastName(lastName);
        source.setEmail(email);
        source.setDescription(description);
        source.setSourceType(sourceType);

        Area area = (Area)DAOFactory.getDAO(DAOType.AREA).findById(areaId);
        source.setArea(area);

        Community community = (Community) DAOFactory.getDAO(DAOType.COMMUNITY).findById(communityId);
        source.setCommunity(community);

        DAOFactory.getDAO(DAOType.SOURCE).update(source);

        response.sendRedirect("managesources");

    }

}
