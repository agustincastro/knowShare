package com.gestacweb.filters;

import com.gestacweb.utils.HibernateUtil;
import com.gestacweb.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(
        filterName = "RequestFilter",
        urlPatterns = "/*",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
)
public class RequestFilter implements Filter {

    private static final Logger LOG = LogManager.getLogger(RequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding("UTF-8");

        String uri = req.getRequestURI();

        HttpSession session = req.getSession();

        LOG.debug("URI " + uri);
        LOG.debug("SESSION " + session);

        /**
         * apply the filter if:
         * is not login request
         * not register page
         * not legal page
         **/
        if(session.getAttribute(WebConstants.LOGGED_USER) == null
                && !uri.endsWith("login.jsp") && !uri.endsWith("login")
                && !uri.matches(".*/static/.*")
                && !uri.matches(".*/register(\\.jsp)?")
                && !uri.matches(".*/legal(\\.jsp)?")
                && !uri.matches(".*/rest/.*")
                ){
            res.sendRedirect("login");
        }else{
            filterChain.doFilter(req, res);
        }

    }

    @Override
    public void destroy() {}
}



