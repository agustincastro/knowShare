package com.gestacweb.servlets.source;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.user.User;
import com.gestacweb.models.source.Source;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "DeleteSourceServlet", urlPatterns = "/deletesource")
public class DeleteSourceServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(DeleteSourceServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside delete source doGet");

        long sourceId = Long.parseLong(request.getParameter("id"));
        Source source = (Source)DAOFactory.getDAO(DAOType.SOURCE).findById(userId);
        source.isActive = false;
        //User userToDelete = source;
        //DAOFactory.getDAO(DAOType.USER).delete(userToDelete);

        response.sendRedirect("managesources");
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside delete problem doPost");
        response.sendRedirect("managesources");
    }

}