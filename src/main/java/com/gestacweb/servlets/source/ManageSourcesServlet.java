package com.gestacweb.servlets.source;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.source.Source;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "ManageSourcesServlet", urlPatterns = "/managesources")
public class ManageSourcesServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(ManageSourcesServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        Set<Source> sourceList = DAOFactory.getDAO(DAOType.SOURCE).getAll();
        request.setAttribute(WebConstants.SOURCES_LIST, sourceList);

        request.getRequestDispatcher("/manage-sources.jsp").forward(request, response);
    }

}
