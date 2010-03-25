package agh.mr.lab2;

import agh.mr.lab2.strategy.AlwaysPartyStrategy;

import java.util.HashSet;

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
            partyingAgent = new JazzLovingAgent();

            /* here we can customize agents, giving them different strategies */
            partyingAgent.addStrategy(new AlwaysPartyStrategy(elFarloBar));

            agentsPopulation.add(partyingAgent);
        }

    }


    private void simulateParty() {
        for (PartyingAgent aPartyingAgent : agentsPopulation) {
            if (aPartyingAgent.isGoingToParty()) {
                elFarloBar.registerGuest();
            }
        }

        /* inform agents of bar crowdness */
        for (PartyingAgent aPartyingAgent : agentsPopulation) {
            aPartyingAgent.learnFromTheExperience(elFarloBar.isBarCrowded());
        }

    }


    public void runSimulation() {
        for (int i = 0; i < simulationTime; i++) {
            /* start single simulation */
            simulateParty();

            /* reset bar crowdedness */
            elFarloBar.closeBar();
        }

        elFarloBar.printBarsHistory();
    }

    public static void main(String args[]) {

        /*
        *  In future we can get it from args -> command line
        * */
        MasterMind masterMind = new MasterMind(10);
        masterMind.runSimulation();


    }

}
