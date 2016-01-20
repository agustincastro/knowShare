package agents;

import jade.core.AID;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;


public class ABDAgent extends BaseAgent {

    public static final String PROBLEMS_TO_SOLVE = "PROBLEMS_TO_SOLVE";
    public static final String PROBLEMS_TO_IMPROVE = "PROBLEMS_TO_IMPROVE";
    public static final String GET_BEST_KNOWLEDGE = "GET_BEST_KNOWLEDGE";
    public static final String UPD_PROBLEM_KNOWLEDGE = "UPD_PROBLEM_KNOWLEDGE";

    @Override
    protected void setup() {
        super.setup();
        getLog().debug("Setting up agent " + getAID().getName());

        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {

                ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
                message.addReceiver(new AID("AFAgent", false));
                message.setConversationId(PROBLEMS_TO_SOLVE);
                send(message);
                ACLMessage reply = blockingReceive(AFAgent.mtPTS);
                if(reply != null){
                    getLog().info("Finished Problems To Be Solved Task. Calling ACAgent to update problems/knowledges map");

                    ACLMessage notifyAC = new ACLMessage(ACLMessage.INFORM);
                    notifyAC.addReceiver(new AID("ACAgent", false));
                    notifyAC.setConversationId(UPD_PROBLEM_KNOWLEDGE);
                    send(notifyAC);
                    reply = blockingReceive(ACAgent.mtUpdPK);
                    if(reply != null){
                        logACLMessage(reply);
                    }

                }

            }
        });

        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {

                ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
                message.addReceiver(new AID("APAgent", false));
                message.setConversationId(PROBLEMS_TO_IMPROVE);
                send(message);
                ACLMessage reply = blockingReceive(APAgent.mtPTI);
                if(reply != null){
                    logACLMessage(reply);
                    getLog().info("Finished Problems To Be Improved Task");
                }

            }
        });

    }
}
