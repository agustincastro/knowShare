package com.knowshare.servlets.source;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.user.User;
import com.knowshare.models.source.Source;
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
        Source source = (Source)DAOFactory.getDAO(DAOType.SOURCE).findById(sourceId);
        source.setValid(false);
        DAOFactory.getDAO(DAOType.SOURCE).update(source);
        response.sendRedirect("managesources");
    }
}
