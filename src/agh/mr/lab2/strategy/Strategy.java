package agh.mr.lab2.strategy;

import agh.mr.lab2.ElFarloBar;

/**
 * created at: Mar 24, 2010, 11:19:16 AM
 *
 * @author: Michal Orzechowski
 */
public abstract class Strategy {

    ElFarloBar elFarloBar;

    public Strategy(ElFarloBar elFarloBar) {
        this.elFarloBar = elFarloBar;
    }

    public abstract boolean makeAssumption();

}
