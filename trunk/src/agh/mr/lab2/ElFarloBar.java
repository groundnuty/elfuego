package agh.mr.lab2;

import java.util.LinkedList;

/**
 * created at: Mar 23, 2010, 10:50:57 PM
 *
 * @author: Michal Orzechowski
 */
public class ElFarloBar {

    public final int populationCount = 100 ;
    
    public final int crowdednessBoundary  = 60 ;

    private int barCrowdedness = 0 ;

    private LinkedList<Integer> crowdednessHistory = new LinkedList<Integer>();

    public LinkedList<Integer> getCrowdednessHistory() {
            return crowdednessHistory;
        }

}
