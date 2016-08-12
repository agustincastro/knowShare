package com.knowshare.servlets.source;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.area.Area;
import com.knowshare.models.community.Community;
import com.knowshare.models.source.Source;
import com.knowshare.models.user.UserDAO;
import com.knowshare.utils.WebConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;


@WebServlet(name = "RateSourceServlet", urlPatterns = "/ratesource")
public class RateSourceServlet extends HttpServlet {

    private static Logger LOG = LogManager.getLogger(RateSourceServlet.class);

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doGet");

        // load source
        String sourceEmail = (String) request.getSession().getAttribute(WebConstants.LOGGED_USER);
        Source source = (Source) ((UserDAO)DAOFactory.getDAO(DAOType.USER)).findByEmail(sourceEmail);
        request.setAttribute(WebConstants.SOURCE, source);

        // get all areas to be shown on select input
        Set<Area> areasList = DAOFactory.getDAO(DAOType.AREA).getAll();
        request.setAttribute(WebConstants.AREAS_LIST, areasList);

        // get all communities to be shown on select input
        Set<Community> communitiesList = DAOFactory.getDAO(DAOType.COMMUNITY).getAll();
        request.setAttribute(WebConstants.COMMUNITIES_LIST, communitiesList);

        request.getRequestDispatcher("/rate-source.jsp").forward(request, response);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        LOG.debug("Inside doPost");

        // load source
        String sourceEmail = (String) request.getSession().getAttribute(WebConstants.LOGGED_USER);
        Source source = (Source) ((UserDAO)DAOFactory.getDAO(DAOType.USER)).findByEmail(sourceEmail);
        request.setAttribute(WebConstants.SOURCE, source);

        // get each of the question answers and get a value which would be the rating
        boolean pFlag = request.getParameter("perception_flag") != null ? Boolean.valueOf(request.getParameter("perception_flag")) : false;
        double perception = 0d;
        if(pFlag){
            double q1 = request.getParameter("question_1") != null ? Double.valueOf(request.getParameter("question_1")) : 0d;
            double q2 = request.getParameter("question_2") != null ? Double.valueOf(request.getParameter("question_2")) : 0d;
            perception = (q1 + q2)/2d;
        }


        double q3 = request.getParameter("question_3") != null ? Double.valueOf(request.getParameter("question_3")) : 0d;
        double workExperience = q3;


        double q4 = request.getParameter("question_4").equals("") ? 0d : Double.valueOf(request.getParameter("question_4"));
        double q5 = request.getParameter("question_5").equals("") ? 0d : Double.valueOf(request.getParameter("question_5"));
        double q6 = request.getParameter("question_6").equals("") ? 0d : Double.valueOf(request.getParameter("question_6"));
        double q7 = request.getParameter("question_7").equals("") ? 0d : Double.valueOf(request.getParameter("question_7"));
        double q8 = request.getParameter("question_8").equals("") ? 0d : Double.valueOf(request.getParameter("question_8"));
        double q9 = request.getParameter("question_9").equals("") ? 0d : Double.valueOf(request.getParameter("question_9"));
        double knowledgeLevel = (q4+q5+q6+q7+q8+q9) / 6d;

        double q10 = request.getParameter("question_10").equals("") ? 0d : Double.valueOf(request.getParameter("question_10"));
        double position = q10;

        double expertiseLevel = (perception + workExperience + knowledgeLevel + position) / 4d;
        source.setExpertiseLevel(expertiseLevel);
        source.setValid(true);

        DAOFactory.getDAO(DAOType.SOURCE).update(source);

        request.getSession().setAttribute(WebConstants.SOURCE_RATED, source.getValid());

        response.sendRedirect("managesources");

    }

}
