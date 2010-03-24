package agh.mr.lab2;

import agh.mr.lab2.strategies.Strategy;

import java.util.HashMap;

/**
 * created at: Mar 23, 2010, 10:54:49 PM
 *
 * @author: Michal Orzechowski
 */
public class JazzLovingAgent implements PartyingAgent {

    /* Strategy and its effectiveness */
    HashMap<Strategy,Integer> strategiesRegistry = new HashMap<Strategy,Integer>();

    public boolean isGoingToParty() {
        Strategy chosenStrategy ;

        /* Chose strategy */

        /* For the moment we are choosing the first one */
        chosenStrategy = strategiesRegistry.keySet().iterator().next();

        return chosenStrategy.makeAssumption();
    }

    
}
