package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class BaseAgent extends Agent {

    private Logger LOG;

    protected BaseAgent(){
    }

    protected Logger getLog(){
        return LOG;
    }

    @Override
    protected void setup(){
        LOG = LogManager.getLogger(this.getClass());

    }
    protected void logACLMessage(ACLMessage message){

        switch (message.getPerformative()){
            case ACLMessage.CONFIRM:
                getLog().info(message.getSender().getName() + " sends CONFIRM message to " + ((AID)message.getAllReceiver().next()).getName());
                break;
            case ACLMessage.FAILURE:
                getLog().info(message.getSender().getName() + " sends FAILURE message to " + ((AID)message.getAllReceiver().next()).getName());
                break;
            case ACLMessage.INFORM:
                getLog().info(message.getSender().getName() + " sends INFORM message to " + ((AID)message.getAllReceiver().next()).getName());
                break;
            case ACLMessage.CANCEL:
                getLog().info(message.getSender().getName() + " sends CANCEL message to " + ((AID)message.getAllReceiver().next()).getName());
                break;

        }

    }

}
