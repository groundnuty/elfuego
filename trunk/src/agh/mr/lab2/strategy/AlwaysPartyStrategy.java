package agh.mr.lab2.strategy;

import java.util.LinkedList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import agh.mr.lab2.ElFarloBar;

/**
 * created at: Mar 25, 2010, 8:48:28 AM
 *
 * @author: Michal Orzechowski
 */
public class AlwaysPartyStrategy implements Strategy {

	@Override
	public boolean makeAssumption(LinkedList<Integer> history, int crowdenessBoundary) {
		return true;
	}

	@Override
	public int makePreciseAssumption(LinkedList<Integer> history,
			int crowdenessBoundary) {
		throw new NotImplementedException();
	}

}
