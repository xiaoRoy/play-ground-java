package com.learn.designpattern.vistitor.improved;

public class CentreBack extends FootballPlayer {

    private int clearance;

    public CentreBack(String name, float rating) {
        super(name, rating);
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    @Override
    void accept(IAnalyst analyst) {
        analyst.analyze(this);
    }
}
