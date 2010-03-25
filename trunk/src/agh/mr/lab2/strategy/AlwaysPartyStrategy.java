package agh.mr.lab2.strategy;

import agh.mr.lab2.ElFarloBar;

/**
 * created at: Mar 25, 2010, 8:48:28 AM
 *
 * @author: Michal Orzechowski
 */
public class AlwaysPartyStrategy extends Strategy {

    public AlwaysPartyStrategy(ElFarloBar elFarloBar) {
        super(elFarloBar);
    }

    @Override
    public boolean makeAssumption() {
        return true;
    }

}
