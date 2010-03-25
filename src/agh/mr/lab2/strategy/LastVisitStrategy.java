package agh.mr.lab2.strategy;

import java.util.LinkedList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import agh.mr.lab2.ElFarloBar;

/**
 * created at: Mar 24, 2010, 11:20:43 AM
 *
 * @author: Michal Orzechowski
 * <p/>
 * Simple strategy, checking if last time it was crowded.
 */
public class LastVisitStrategy implements Strategy{


    @Override
    public boolean makeAssumption(LinkedList<Integer> history, int crowdenessBoundary) {
        if (history.getLast() >= crowdenessBoundary) {
            return false;
        } else {
            return true;
        }
    }

	@Override
	public int makePreciseAssumption(LinkedList<Integer> history,
			int crowdenessBoundary) {
		return history.getLast();
	}

}
