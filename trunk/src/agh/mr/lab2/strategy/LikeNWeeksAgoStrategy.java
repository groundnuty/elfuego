package agh.mr.lab2.strategy;

import java.util.LinkedList;

public class LikeNWeeksAgoStrategy implements Strategy {

	private int howManyAgo;
	
	public LikeNWeeksAgoStrategy(int howManyAgo){
		
		this.howManyAgo=howManyAgo;
	
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

		if(history.size()<howManyAgo)
			return history.getFirst();
		else
			return history.get(history.size()-howManyAgo);
		
	}

}
