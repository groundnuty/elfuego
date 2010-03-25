package agh.mr.lab2.strategy;

import java.util.LinkedList;
import java.util.List;

import agh.mr.lab2.ElFarloBar;

/**
 * created at: Mar 24, 2010, 11:19:16 AM
 *
 * @author: Michal Orzechowski
 */
public interface Strategy {

    public boolean makeAssumption(LinkedList<Integer> history, int crowdenessBoundary);
    
    public int makePreciseAssumption(LinkedList<Integer> history, int crowdenessBoundary); 

}
