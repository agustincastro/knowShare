package com.gestacweb.servlets.security;

import com.gestacweb.models.user.User;
import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(RegisterServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        String name = request.getParameter("name");
        String lastName = request.getParameter("last-name");
        String email = request.getParameter("email");
        String confirmEmail = request.getParameter("confirm-email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        if(!email.equals(confirmEmail)){
            request.setAttribute(WebConstants.ERROR_MSG, "Los emails no coinciden");
            response.sendRedirect("register");
            return;
        }
        if(!password.equals(confirmPassword)){
            request.setAttribute(WebConstants.ERROR_MSG, "Las contraseñas no coinciden");
            response.sendRedirect("register");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        DAOFactory.getDAO(DAOType.USER).save(user);

        response.sendRedirect("login");
    }

}
