package agh.mr.lab2.strategy;

import java.util.LinkedList;

public class MirrorImageStrategy implements Strategy {

	int mirrorPoint;
	
	
	public MirrorImageStrategy(int mirrorPoint){
		
		this.mirrorPoint=mirrorPoint;
		
	}
	
	@Override
	public boolean makeAssumption(LinkedList<Integer> history,
			int crowdenessBoundary) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int makePreciseAssumption(LinkedList<Integer> history,
			int crowdenessBoundary) {
		
		int assumption= mirrorPoint+(mirrorPoint-history.getLast());
		if(assumption>0) 
			return assumption;
		else return 0;
	}

}
