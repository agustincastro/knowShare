package com.gestacweb.servlets.security;

import com.gestacweb.models.user.User;
import com.gestacweb.models.user.UserDAO;
import com.gestacweb.utils.BCrypt;
import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

    private static Logger LOG = LogManager.getLogger(LoginServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username == null && password == null && username.equals("") && password.equals("")){
            request.setAttribute(WebConstants.ERROR_MSG, "El usuario y la contraseña no pueden ser vacíos");
            request.getRequestDispatcher("login.jsp");
        } else {

            if(authenticateUser(username, password)){
                request.getSession().setAttribute(WebConstants.LOGGED_USER, username);
                request.getSession().setAttribute(WebConstants.LOGGED_USER_TYPE, ((UserDAO)DAOFactory.getDAO(DAOType.USER)).findByEmail(username).getType());
                request.setAttribute(WebConstants.LOGGED_USER, username);

                // redirects to index page
                response.sendRedirect("index");
            }else{
                response.sendRedirect("login");
            }

        }
    }

    private boolean authenticateUser(String username, String password){

        User user = ((UserDAO)DAOFactory.getDAO(DAOType.USER)).findByEmail(username);
        return user !=  null && BCrypt.checkpw(password, user.getPassword());

    }

}
