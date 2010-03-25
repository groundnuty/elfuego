package agh.mr.lab2;

import agh.mr.lab2.strategy.Strategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * created at: Mar 23, 2010, 10:54:49 PM
 *
 * @author: Michal Orzechowski, lewickitom
 */
public class JazzLovingAgent implements PartyingAgent {

    /* constant used in rating system */
	public static final double LAMBDA=0.3;
    
	/* Strategy and its rating -  the lower the better */
    private HashMap<Strategy, Double> strategiesRegistry = new HashMap<Strategy, Double>();
    private HashMap<Strategy, Integer> lastAssumptions= new HashMap<Strategy, Integer>();
    
    private ElFarloBar elFarloBar;
    
    
    public JazzLovingAgent(ElFarloBar elFarloBar){
    	
    	this.elFarloBar=elFarloBar;
    	
    }
    
    public void addStrategy(Strategy strategy) {
        
        strategiesRegistry.put(strategy, 0.0);
        
    }
    
    /* updates ratings of each strategy on the base of accuracies of their last predictions  */
    public void learnFromTheExperience() {
        
    	double currError=0.0;
    	double newRating=0.0;
    	double currRating=0.0;
    	
    	for(Map.Entry<Strategy,Double> strategyEntry:strategiesRegistry.entrySet()){
    		
    		currError=Math.abs(lastAssumptions.get(strategyEntry.getKey())-elFarloBar.getCrowdednessHistory().getLast());
    		currRating=strategyEntry.getValue();
    		newRating=(LAMBDA*currRating)+(1.0-LAMBDA)*(currError);
    		strategyEntry.setValue(newRating);
    		
    	}
    	
    }
    
    public boolean isGoingToParty() {
        
    	calculateAssumptions();
        Strategy chosenStrategy = chooseBestStrategy();
        int assumption=chosenStrategy.makePreciseAssumption(elFarloBar.getCrowdednessHistory(),elFarloBar.crowdednessBoundary);
        
        if(assumption<elFarloBar.crowdednessBoundary)
        	return true;
        else 
        	return false;
       	  
    }


    
    /* pick strategy with the lowest  */
    private Strategy chooseBestStrategy(){
    	
    	Map.Entry<Strategy,Double> currentBest=null;
    	for(Map.Entry<Strategy,Double> strategyEntry:strategiesRegistry.entrySet()){
    	
    		if(currentBest==null || currentBest.getValue()>strategyEntry.getValue())
    			currentBest=strategyEntry;
    	
    	}
    	return currentBest.getKey();
    	
    }
    
    /* calculates assumptions for each strategy and store results - necessary to evaluate strategies */
    private void calculateAssumptions(){
    	
    	for(Strategy strategy:strategiesRegistry.keySet()){
    		
    		int assumption=strategy.makePreciseAssumption(elFarloBar.getCrowdednessHistory(), elFarloBar.crowdednessBoundary);	
    		lastAssumptions.put(strategy,assumption);
    		
    	}
    }
    
}
