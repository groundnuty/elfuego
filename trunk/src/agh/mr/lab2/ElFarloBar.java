package agh.mr.lab2;

import java.util.LinkedList;
import java.util.Random;

/**
 * created at: Mar 23, 2010, 10:50:57 PM
 *
 * @author: Michal Orzechowski
 */
public class ElFarloBar {

    public final int crowdednessBoundary = 60;

    private int barCrowdedness = 0;

    private LinkedList<Integer> crowdednessHistory = new LinkedList<Integer>();

    public LinkedList<Integer> getCrowdednessHistory() {
        return crowdednessHistory;
    }

    public void closeBar() {
        crowdednessHistory.add(barCrowdedness);
        barCrowdedness = 0;
    }

    public void registerGuest() {
        barCrowdedness++;
    }

    public boolean isBarCrowded() {
        return barCrowdedness > crowdednessBoundary ? true : false;
    }

    public void initBarHistory(int numberOfHistoryRecords) {
        /* for testing purposes, no seed */
        Random random = new Random();

        for (int i = 0; i < numberOfHistoryRecords; i++) {
            crowdednessHistory.add(random.nextInt());
        }
    }

    public void printBarsHistory() {
        System.out.println("ElFarloBar history:");
        for (Integer historyRecord : crowdednessHistory) {
            System.out.println("  " + historyRecord);
        }
        System.out.println();
    }

}
