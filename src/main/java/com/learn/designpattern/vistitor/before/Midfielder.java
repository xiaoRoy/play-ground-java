package com.learn.designpattern.vistitor.before;

public class Midfielder extends FootballPlayer {

    private int assist;

    public Midfielder(String name, float rating) {
        super(name, rating);
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }
}
