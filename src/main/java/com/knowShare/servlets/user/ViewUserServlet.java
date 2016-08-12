package com.knowshare.servlets.user;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.user.User;
import com.knowshare.models.user.UserDAO;
import com.knowshare.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "ViewUserServlet", urlPatterns = "/view-user")
public class ViewUserServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(ViewUserServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // load user
        String userEmail = (String) request.getSession().getAttribute(WebConstants.LOGGED_USER);
        User user = ((UserDAO)DAOFactory.getDAO(DAOType.USER)).findByEmail(userEmail);
        request.setAttribute(WebConstants.USER, user);

        request.getRequestDispatcher("/view-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");



    }

}
