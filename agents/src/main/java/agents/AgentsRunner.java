package agents;


import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


public class AgentsRunner {

    public static AgentContainer agentContainer;

    public static void main(String[] args) {

        try{
            jade.core.Runtime runtime = jade.core.Runtime.instance();
            Profile profile = new ProfileImpl();
            agentContainer = runtime.createMainContainer(profile);

            AgentController abdAgentController = agentContainer.createNewAgent("ABDAgent", "agents.ABDAgent", null);
            abdAgentController.start();

            AgentController afAgentController = agentContainer.createNewAgent("AFAgent", "agents.AFAgent", null);
            afAgentController.start();

            AgentController apAgentController = agentContainer.createNewAgent("APAgent", "agents.APAgent", null);
            apAgentController.start();

            AgentController acAgentController = agentContainer.createNewAgent("ACAgent", "agents.ACAgent", null);
            acAgentController.start();

            // run the jade gui
            jade.Boot.main(new String[]{"-gui", "-agents", "ABDAgent:agents.ABDAgent;AFAgent:agents.AFAgent;APAgent:agents.APAgent;ACAgent:agents.ACAgent"});
        }catch (StaleProxyException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}
