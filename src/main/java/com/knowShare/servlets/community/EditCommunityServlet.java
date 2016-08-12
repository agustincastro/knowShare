package com.knowshare.servlets.community;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.community.Community;
import com.knowshare.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "EditCommunityServlet", urlPatterns = "/editcommunity")
public class EditCommunityServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(EditCommunityServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // load source
        long communityId = Long.parseLong(request.getParameter("id"));
        Community community = (Community) DAOFactory.getDAO(DAOType.COMMUNITY).findById(communityId);
        request.setAttribute(WebConstants.COMMUNITY, community);

        request.getRequestDispatcher("/community.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        long communityId = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        LOG.debug("NAME = " + name);
        LOG.debug("DESCRIPTION = " + description);

        Community community = (Community) DAOFactory.getDAO(DAOType.COMMUNITY).findById(communityId);
        community.setName(name);
        community.setDescription(description);

        DAOFactory.getDAO(DAOType.COMMUNITY).update(community);

        response.sendRedirect("managecommunities");
    }

}
