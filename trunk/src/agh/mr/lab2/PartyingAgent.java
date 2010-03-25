package agh.mr.lab2;

import agh.mr.lab2.strategy.Strategy;

/**
 * created at: Mar 24, 2010, 10:53:56 AM
 *
 * @author: Michal Orzechowski
 */
public interface PartyingAgent {

    public boolean isGoingToParty();

    public void addStrategy(Strategy strategy);

    public void learnFromTheExperience();
}
