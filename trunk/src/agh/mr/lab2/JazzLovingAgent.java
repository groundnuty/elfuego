package agh.mr.lab2;

import agh.mr.lab2.strategy.Strategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * created at: Mar 23, 2010, 10:54:49 PM
 *
 * @author: Michal Orzechowski
 */
public class JazzLovingAgent implements PartyingAgent {

    /* Strategy and its effectiveness */
    private HashMap<Strategy, Double> strategiesRegistry = new HashMap<Strategy, Double>();
    private HashMap<Strategy, Integer> lastAssumptions= new HashMap<Strategy, Integer>();
    
    private ElFarloBar elFarloBar;
    
    public static final double LAMBDA=0.3;
    
    
    public JazzLovingAgent(ElFarloBar elFarloBar){
    	
    	this.elFarloBar=elFarloBar;
    	
    }
    
    public void learnFromTheExperience() {
        
    	double currError=0.0;
    	double newEffectiveness=0.0;
    	double currEffectiveness=0.0;
    	
    	for(Map.Entry<Strategy,Double> strategyEntry:strategiesRegistry.entrySet()){
    		
    		currError=Math.abs(lastAssumptions.get(strategyEntry.getKey())-elFarloBar.getCrowdednessHistory().getLast());
    		currEffectiveness=strategyEntry.getValue();
    		newEffectiveness=(LAMBDA*currEffectiveness)+(1.0-LAMBDA)*(currError);
    		strategyEntry.setValue(newEffectiveness);
    		
    	}
    	
    	
    }
    
    public boolean isGoingToParty() {

        
    	calculateAssumptions();
        Strategy chosenStrategy = chooseBestStrategy();
 	
        //   return chosenStrategy.makeAssumption(elFarloBar.getCrowdednessHistory(),elFarloBar.crowdednessBoundary);
        if(chosenStrategy.makePreciseAssumption(elFarloBar.getCrowdednessHistory(),elFarloBar.crowdednessBoundary)<elFarloBar.crowdednessBoundary)
        	return true;
        else return false;
       	  
    }

    public void addStrategy(Strategy strategy) {
        
    	/* Not sure if 0 is good initial value for the learning process.
         */
        strategiesRegistry.put(strategy, 0.0);
        
    }

    private Strategy chooseBestStrategy(){
    	
    	Map.Entry<Strategy,Double> currentBest=null;
    	for(Map.Entry<Strategy,Double> strategyEntry:strategiesRegistry.entrySet()){
    		if(currentBest==null || currentBest.getValue()>strategyEntry.getValue())
    			currentBest=strategyEntry;
    	
    	}
    	return currentBest.getKey();
    	
    }
    
    
    private void calculateAssumptions(){
    	
    	
    	for(Strategy strategy:strategiesRegistry.keySet()){
    		
    		int assumption=strategy.makePreciseAssumption(elFarloBar.getCrowdednessHistory(), elFarloBar.crowdednessBoundary);
    	
    		lastAssumptions.put(strategy,assumption);
    		
    	}
    
    }
    
}
