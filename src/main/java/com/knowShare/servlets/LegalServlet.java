package com.knowshare.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "LegalServlet", urlPatterns = "/legal")
public class LegalServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(LegalServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        request.getRequestDispatcher("legal.jsp").forward(request, response);

    }

}
