package com.gestacweb.rest;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.models.knowledge.KnowledgeDAO;
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
import java.util.Set;


@Path("/knowledges/improve")
public class GetKnowledgesToBeImproved implements Serializable {

    @GET
    @Path("/{sourceId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject get(@PathParam("sourceId") long sourceId) throws JSONException{

        Set<Knowledge> knowledgesToBeImproved = ((KnowledgeDAO) DAOFactory.getDAO(DAOType.KNOWLEDGE)).getKnowledgesToBeImproved(sourceId);

        JSONArray knowledges = new JSONArray();
        for(Knowledge knowledge : knowledgesToBeImproved){
            knowledges.put(knowledge.toJson());

        }
        JSONObject response = new JSONObject();
        response.put("knowledges", knowledges);

        return response;

    }

}
