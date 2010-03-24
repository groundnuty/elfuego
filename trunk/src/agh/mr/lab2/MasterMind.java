package agh.mr.lab2;

import java.util.HashSet;

/**
 * created at: Mar 24, 2010, 10:49:05 AM
 *
 * @author: Michal Orzechowski
 */
public class MasterMind {


    public final int totalPopulation = 100;

    /* In weeks */
    private int simulationTime ;


    ElFarloBar elFarloBar ;

    private HashSet<PartyingAgent> agentsPopulation = new HashSet<PartyingAgent>();

    public MasterMind(int simulationTime) {
        this.simulationTime = simulationTime;


        /* Make agents
        * Probably we will need agents with few types of strategies ;
        * */
        for(int i = 0;i<totalPopulation;i++) {
            agentsPopulation.add(new JazzLovingAgent());
        }

        /* Create Bar */
        elFarloBar = new ElFarloBar();

        /* Start Simulation */
        for(int i = 0;i<simulationTime;i++) {
                        
        }




    }


    


    public static void main(String args[]) {

       /* Set simulation time
        *  In future we can get it from args -> command line
        * */
        MasterMind masterMind = new MasterMind(10) ;



    }

}
