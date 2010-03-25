package agh.mr.lab2.strategy;

import agh.mr.lab2.ElFarloBar;

/**
 * created at: Mar 24, 2010, 11:20:43 AM
 *
 * @author: Michal Orzechowski
 * <p/>
 * Simple strategy, checking if last time it was crowded.
 */
public class LastVisitStrategy extends Strategy {

    public LastVisitStrategy(ElFarloBar elFarloBar) {
        super(elFarloBar);
    }

    @Override
    public boolean makeAssumption() {
        if (elFarloBar.getCrowdednessHistory().getLast() >= elFarloBar.crowdednessBoundary) {
            return false;
        } else {
            return true;
        }
    }

}
