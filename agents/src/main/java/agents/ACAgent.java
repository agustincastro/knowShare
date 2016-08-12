package agents;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.knowledge.Knowledge;
import com.knowshare.models.problem.Problem;
import com.knowshare.utils.HibernateUtil;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class ACAgent extends BaseAgent {

    public static final MessageTemplate mtGBK = MessageTemplate.MatchConversationId(ABDAgent.GET_BEST_KNOWLEDGE);
    public static final MessageTemplate mtUpdPK = MessageTemplate.MatchConversationId(ABDAgent.UPD_PROBLEM_KNOWLEDGE);

    private Map<Long, Long> problemKnowledgeMap =  new ConcurrentHashMap<Long, Long>();

    @Override
    protected void setup(){
        super.setup();
        getLog().debug("Setting up agent " + getAID().getName());

        addBehaviour(new OneShotBehaviour(this) {
            @Override
            public void action() {

                updateInternalMap();

            }
        });



        addBehaviour(new TickerBehaviour(this, 5000){

            @Override
            public void onTick() {

                ACLMessage message = blockingReceive(mtGBK, 3000);
                if(message != null){
                    logACLMessage(message);
                    // get problem id from message content and get best knowledge from internal map
                    Long problemId = Long.parseLong(message.getContent());
                    Long knowledegeId = problemKnowledgeMap.get(problemId);

                    ACLMessage reply = message.createReply();
                    if(knowledegeId ==  null){
                        reply.setPerformative(ACLMessage.FAILURE);
                        reply.setContent("Best Knowledge Not Found");
                    }else{
                        reply.setPerformative(ACLMessage.PROPOSE);
                        reply.setContent(knowledegeId.toString());
                    }

                    send(reply);

                }else{
                    getLog().info("Didn't receive message from ABDAgent to get best knowledge from P/K map");
                    ACLMessage reply = new ACLMessage(ACLMessage.FAILURE);
                    reply.addReceiver(new AID("ABDAgent", false));
                    reply.setConversationId(ABDAgent.GET_BEST_KNOWLEDGE);
                    reply.setContent("Didn't receive message from ABDAgent to get best knowledge from P/K map");
                    send(reply);

                }
            }
        });


        addBehaviour(new TickerBehaviour(this, 5000){

            @Override
            public void onTick() {

                ACLMessage message = blockingReceive(mtUpdPK, 3000);
                if(message != null){
                    logACLMessage(message);
                    updateInternalMap();
                    ACLMessage reply = message.createReply();
                    reply.setPerformative(ACLMessage.CONFIRM);
                    send(reply);
                }else{
                    //getLog().info("Didn't receive message from ABDAgent to update P/K map");
                    ACLMessage reply = new ACLMessage(ACLMessage.FAILURE);
                    reply.addReceiver(new AID("ABDAgent", false));
                    reply.setConversationId(ABDAgent.UPD_PROBLEM_KNOWLEDGE);
                    reply.setContent("Didn't receive message from ABDAgent to update P/K map");
                    send(reply);

                }
            }
        });

    }

    private void updateInternalMap(){

        // update internal problem/best knowledge map
        Set<Problem> problems = DAOFactory.getDAO(DAOType.PROBLEM).getAll();
        for(Problem problem : problems){
            List<Knowledge> knowledges = problem.getKnowledges();
            if(knowledges != null && knowledges.size() > 0){
                Collections.sort(knowledges, new Comparator<Knowledge>() {
                    @Override
                    public int compare(Knowledge o1, Knowledge o2) {
                        if(o1.getRating() > o2.getRating())
                            return 1;
                        if(o1.getRating() < o2.getRating())
                            return -1;

                        return 0;
                    }
                });
                problemKnowledgeMap.put(problem.getId(), knowledges.get(0).getId());
            }
        }

    }
}
