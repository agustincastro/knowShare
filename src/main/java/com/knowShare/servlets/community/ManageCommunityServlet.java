package com.knowshare.servlets.community;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.community.Community;
import com.knowshare.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "ManageCommunityServlet", urlPatterns = "/managecommunities")
public class ManageCommunityServlet extends HttpServlet{

    private static Logger LOG = LogManager.getLogger(ManageCommunityServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        Set<Community> communityList = DAOFactory.getDAO(DAOType.COMMUNITY).getAll();
        request.setAttribute(WebConstants.COMMUNITIES_LIST, communityList);

        request.getRequestDispatcher("/manage-communities.jsp").forward(request, response);
    }
}
