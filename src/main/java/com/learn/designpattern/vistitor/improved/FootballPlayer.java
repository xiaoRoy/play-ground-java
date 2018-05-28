package com.learn.designpattern.vistitor.improved;

public abstract class FootballPlayer {

    private String name;

    private float rating;

    public FootballPlayer(String name, float rating) {
        this.name = name;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    abstract void accept(IAnalyst analyst);
}
