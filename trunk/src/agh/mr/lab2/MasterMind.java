package agh.mr.lab2;

import agh.mr.lab2.strategy.AlwaysPartyStrategy;
import agh.mr.lab2.strategy.LikeNWeeksAgoStrategy;
import agh.mr.lab2.strategy.MirrorImageStrategy;
import agh.mr.lab2.strategy.NWeeksAverageStrategy;

import java.util.HashSet;
import java.util.Random;

import sun.security.x509.AVA;

/**
 * created at: Mar 24, 2010, 10:49:05 AM
 *
 * @author: Michal Orzechowski
 */
public class MasterMind {

    public final int totalPopulation = 100;

    /* In weeks */
    private int simulationTime;

    ElFarloBar elFarloBar;

    private HashSet<PartyingAgent> agentsPopulation = new HashSet<PartyingAgent>();

    public MasterMind(int simulationTime) {
        this.simulationTime = simulationTime;

        /* Create Bar */
        elFarloBar = new ElFarloBar();

        PartyingAgent partyingAgent;

        
       
        /* Make agents
        * Probably we will need agents with few types of strategies ;
        * */
        for (int i = 0; i < totalPopulation; i++) {
        	
            partyingAgent = new JazzLovingAgent(elFarloBar);

            /* here we can customize agents, giving them different strategies */
            if(i<34){
            	partyingAgent.addStrategy(new LikeNWeeksAgoStrategy(i+1));
            //	partyingAgent.addStrategy(new NWeeksAverageStrategy(4));
            //	partyingAgent.addStrategy(new NWeeksAverageStrategy(3));
            }
            if(i>=34 && i<66){
              	partyingAgent.addStrategy(new NWeeksAverageStrategy(i-33));
             	//partyingAgent.addStrategy(new LikeNWeeksAgoStrategy(4));
        	//	partyingAgent.addStrategy(new LikeNWeeksAgoStrategy(3));
            }  
            if(i>=66 && i<=100){
             	partyingAgent.addStrategy(new MirrorImageStrategy(i-67));
        	//	partyingAgent.addStrategy(new MirrorImageStrategy(30));
        	//	partyingAgent.addStrategy(new MirrorImageStrategy(60));
            }  

            agentsPopulation.add(partyingAgent);
            
        }

    }


    private void simulateParty() {
        for (PartyingAgent aPartyingAgent : agentsPopulation) {
            if (aPartyingAgent.isGoingToParty()) {
                elFarloBar.registerGuest();
            }
        }
        /* reset bar crowdedness */
        elFarloBar.closeBar();
        /* give agents order to learn */
        for (PartyingAgent aPartyingAgent : agentsPopulation) {
            aPartyingAgent.learnFromTheExperience();
        }

    }


    public void runSimulation() {
    	
    
        for (int i = 0; i < simulationTime; i++) {
            /* start single simulation */
            simulateParty();

          
        }

        elFarloBar.printBarsHistory();
    }
    
    public void createInitialRandomHistory(int weeks){
    	
    	Random rand=new Random();
    	for(int i=0;i<weeks;i++)
    		elFarloBar.getCrowdednessHistory().add(rand.nextInt(totalPopulation));
    	
    	
    }
    
    public static void main(String args[]) {

        /*
        *  In future we can get it from args -> command line
        * */
        MasterMind masterMind = new MasterMind(5000);
        masterMind.createInitialRandomHistory(1);
        masterMind.runSimulation();


    }

}
