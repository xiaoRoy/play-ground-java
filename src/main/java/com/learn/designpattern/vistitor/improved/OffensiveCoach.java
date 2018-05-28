package com.learn.designpattern.vistitor.improved;

public class OffensiveCoach implements IAnalyst{
    @Override
    public void analyze(Forward forward) {
        forward.getGoal();
    }

    @Override
    public void analyze(Midfielder midfielder) {
        midfielder.getAssist();
    }

    @Override
    public void analyze(CentreBack centreBack) {
        centreBack.getRating();
    }
}
