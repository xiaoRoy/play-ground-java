package com.learn.designpattern.vistitor.improved;

public class DefensiveCoach implements IAnalyst {
    @Override
    public void analyze(Forward forward) {
        forward.getRating();
    }

    @Override
    public void analyze(Midfielder midfielder) {
        midfielder.getRating();
    }

    @Override
    public void analyze(CentreBack centreBack) {
        centreBack.getClearance();
    }
}
