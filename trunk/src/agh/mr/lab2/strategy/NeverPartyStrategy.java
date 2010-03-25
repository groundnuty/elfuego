package agh.mr.lab2.strategy;

import java.util.LinkedList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.sun.org.apache.xml.internal.utils.UnImplNode;

import agh.mr.lab2.ElFarloBar;

/**
 * created at: Mar 25, 2010, 8:48:36 AM
 *
 * @author: Michal Orzechowski
 */
public class NeverPartyStrategy implements Strategy {


    @Override
    public  boolean makeAssumption(LinkedList<Integer> history, int crowdenessBoundary) {
        return false;
    }
    
    @Override
    public  int makePreciseAssumption(LinkedList<Integer> history, int crowdenessBoundary) {
        throw new NotImplementedException();
    }
}
