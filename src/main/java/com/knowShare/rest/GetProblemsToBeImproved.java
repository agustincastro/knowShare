package com.knowshare.rest;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.knowledge.Knowledge;
import com.knowshare.models.knowledge.KnowledgeDAO;
import com.knowshare.models.problem.Problem;
import com.knowshare.models.problem.ProblemDAO;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

@Path("/problems/improve")
public class GetProblemsToBeImproved implements Serializable {


    @GET
    @Path("/{sourceId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject get(@PathParam("sourceId") long sourceId) throws JSONException {

        List<Problem> problemsToBeImproved = ((ProblemDAO) DAOFactory.getDAO(DAOType.PROBLEM)).getProblemsToBeImproved(sourceId);

        JSONArray problems = new JSONArray();
        for(Problem problem : problemsToBeImproved){
            problems.put(problem.toJson());

        }
        JSONObject response = new JSONObject();
        response.put("problems", problems);

        return response;

    }

}
