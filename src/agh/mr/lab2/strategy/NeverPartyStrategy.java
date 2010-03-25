package agh.mr.lab2.strategy;

import agh.mr.lab2.ElFarloBar;

/**
 * created at: Mar 25, 2010, 8:48:36 AM
 *
 * @author: Michal Orzechowski
 */
public class NeverPartyStrategy extends Strategy {

    public NeverPartyStrategy(ElFarloBar elFarloBar) {
        super(elFarloBar);
    }

    @Override
    public boolean makeAssumption() {
        return false;
    }

}
