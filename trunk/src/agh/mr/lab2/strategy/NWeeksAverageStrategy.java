package agh.mr.lab2.strategy;

import java.util.LinkedList;

public class NWeeksAverageStrategy implements Strategy {

	private int numberOfWeeks;
	
	public NWeeksAverageStrategy(int numberOfWeeks){
		
		this.numberOfWeeks=numberOfWeeks;
	
	}

	@Override
	public int makePreciseAssumption(LinkedList<Integer> history,
			int crowdenessBoundary) {
		
		int startIndex=0;
		int sum=0;
		if(history.size()>=numberOfWeeks){
			startIndex=history.size()-numberOfWeeks;
		}
		int weeksTaken=0;
		for(int i=startIndex;i<history.size();i++){
			sum+=history.get(i);
			weeksTaken++;
		}

		return sum/weeksTaken;
		
	}

	@Override
	public boolean makeAssumption(LinkedList<Integer> history,
			int crowdenessBoundary) {
		return false;
	}

}
