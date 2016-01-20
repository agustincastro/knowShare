package agents;

import com.gestacweb.models.DAOFactory;
import com.gestacweb.models.DAOType;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.models.knowledge.KnowledgeDAO;
import com.gestacweb.models.problem.Problem;
import com.gestacweb.models.source.Source;
import com.gestacweb.utils.HibernateUtil;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import java.util.List;
import java.util.Set;


public class APAgent extends BaseAgent {

    public static MessageTemplate mtPTI = MessageTemplate.MatchConversationId(ABDAgent.PROBLEMS_TO_IMPROVE);;

    @Override
    protected void setup(){
        super.setup();
        getLog().debug("Setting up agent " + getAID().getName());

        // Improve already solved problems behaviour
        addBehaviour(new TickerBehaviour(this, 10000){

            @Override
            public void onTick() {

                ACLMessage message = blockingReceive(mtPTI);
                if(message != null){
                    logACLMessage(message);
                    // improve problems

                    // get list of sources for each area
                    //Set<Source> sources = DAOFactory.getDAO(DAOType.SOURCE).getAll();

                    // get knowledges that solved problems
                    Set<Knowledge> knowledges = ((KnowledgeDAO)DAOFactory.getDAO(DAOType.KNOWLEDGE)).getKnowledgesThatSolvedProblems();
                    // for each knowledge that provided the solution to a problem, look if there is a source that has better rating in the problem's area
                    for(Knowledge knowledge : knowledges){
                        Source sourceCanImprove = null;
                        Set<Source> sources = knowledge.getProblem().getArea().getSources();
                        for(Source source : sources){
                            if(knowledge.getSourceWithKnowledge().getArea()!= null && knowledge.getSourceWithKnowledge().getArea().equals(source.getArea())
                                    && source.getExpertiseLevel() > knowledge.getSourceWithKnowledge().getExpertiseLevel()){

                                if((knowledge.getSourceCanImprove() != null && !knowledge.getSourceCanImprove().equals(source)) || knowledge.getSourceCanImprove() == null){

                                    getLog().debug("Found source that can improve! id = " + source.getId());
                                    sourceCanImprove = source;
                                    break;
                                }
                            }
                        }
                        if(sourceCanImprove != null){
                            getLog().info("Found source that can improve knowledge! " + sourceCanImprove.getEmail());
                            knowledge.setSourceCanImprove(sourceCanImprove);
                            DAOFactory.getDAO(DAOType.KNOWLEDGE).update(knowledge);
                        }
                    }

                    // inform finished task
                    ACLMessage reply = message.createReply();
                    reply.setPerformative(ACLMessage.INFORM);
                    send(reply);
                }
            }
        });

        // Penalize sources behaviour
        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {

                getLog().debug("Initiating penalize process...");
                Set<Problem> problems = DAOFactory.getDAO(DAOType.PROBLEM).getAll();

                for(Problem problem : problems){

                    List<Knowledge> knowledges = problem.getKnowledges();

                    for(Knowledge knowledge : knowledges){

                        Source sourceWithKnowledge = knowledge.getSourceWithKnowledge();
                        double sourceRating = sourceWithKnowledge.getExpertiseLevel();

                        for(Knowledge auxKnowledge : knowledges){

                            if(!auxKnowledge.equals(knowledge)
                                    && knowledge.getRating() < auxKnowledge.getRating()
                                    && sourceRating > auxKnowledge.getSourceWithKnowledge().getExpertiseLevel()
                                    ){

                                // penalize source
                                getLog().debug("Penalizing " + sourceWithKnowledge.getName() + " with rating " + auxKnowledge.getSourceWithKnowledge().getExpertiseLevel());
                                sourceWithKnowledge.setExpertiseLevel(auxKnowledge.getSourceWithKnowledge().getExpertiseLevel());
                                DAOFactory.getDAO(DAOType.SOURCE).update(sourceWithKnowledge);

                            }
                        }
                    }
                }
            }
        });
    }

}
