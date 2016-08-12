package agents;

import com.knowshare.models.DAOFactory;
import com.knowshare.models.DAOType;
import com.knowshare.models.problem.Problem;
import com.knowshare.models.problem.ProblemDAO;
import com.knowshare.models.source.Source;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Set;


public class AFAgent extends BaseAgent {

    public static MessageTemplate mtPTS = MessageTemplate.MatchConversationId(ABDAgent.PROBLEMS_TO_SOLVE);

    @Override
    protected void setup(){
        super.setup();
        getLog().debug("Setting up agent " + getAID().getName());

        addBehaviour(new CyclicBehaviour(this){

            @Override
            public void action() {

                    ACLMessage message = blockingReceive(mtPTS);
                    if(message != null){
                        getLog().info("Message Received! Must solve problems");
                        logACLMessage(message);
                        // solve problems
                        List<Problem> problems = ((ProblemDAO)DAOFactory.getDAO(DAOType.PROBLEM)).getUnsolvedProblems();
                        for(Problem problem : problems){
                            Source bestRatedSource = null;
                            if(problem.getArea() != null){
                                Hibernate.initialize(problem.getArea().getSources());
                                Set<Source> sources = problem.getArea().getSources();
                                if(sources != null){
                                    for(Source source : sources){
                                        if(bestRatedSource == null)
                                            bestRatedSource = source;
                                        else{
                                            if(source.getExpertiseLevel() > bestRatedSource.getExpertiseLevel())
                                                bestRatedSource = source;
                                        }
                                    }
                                }
                            }
                            if(bestRatedSource != null){
                                getLog().info("Found best source to solve problem! " + bestRatedSource.getEmail());
                                problem.setBestSourceToSolveProblem(bestRatedSource);
                                DAOFactory.getDAO(DAOType.PROBLEM).update(problem);

                            }
                        }

                        // inform finished task
                        ACLMessage reply = message.createReply();
                        reply.setPerformative(ACLMessage.INFORM);
                        send(reply);

                    }

            }
        });
    }
}