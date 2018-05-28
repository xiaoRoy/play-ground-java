package com.learn.designpattern.vistitor.improved;

public interface IAnalyst {
    void analyze(Forward forward);
    void analyze(Midfielder midfielder);
    void analyze(CentreBack centreBack);
}
