package com.learn.designpattern.vistitor.before;

public class CentreBack extends FootballPlayer{

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
}
