package com.learn.designpattern.vistitor.before;

public class Forward extends FootballPlayer{

    private int goal;

    public Forward(String name, float rating) {
        super(name, rating);
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }
}
