package com.gestacweb.servlets.community;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.community.Community;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "DeleteCommunityServlet", urlPatterns = "/deletecommunity")
public class DeleteCommunityServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(DeleteCommunityServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside community delete doGet");

        long communityId = Long.parseLong(request.getParameter("id"));
        Community community = (Community)DAOFactory.getDAO(DAOType.COMMUNITY).findById(communityId);
        community.setValid(false);
        DAOFactory.getDAO(DAOType.COMMUNITY).update(community);
        response.sendRedirect("managecommunities");
    }

}
