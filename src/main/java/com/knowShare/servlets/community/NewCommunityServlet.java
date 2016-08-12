package com.knowshare.servlets.community;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.community.Community;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "NewCommunityServlet", urlPatterns = "/newcommunity")
public class NewCommunityServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(NewCommunityServlet.class);


    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        request.getRequestDispatcher("/community.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        LOG.debug("NAME = " + name);
        LOG.debug("DESCRIPTION = " + description);

        Community community = new Community();
        community.setName(name);
        community.setDescription(description);

        DAOFactory.getDAO(DAOType.COMMUNITY).save(community);

        response.sendRedirect("newcommunity");
    }

}