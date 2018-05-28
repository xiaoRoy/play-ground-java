package com.learn.designpattern.vistitor.improved;

import java.util.ArrayList;
import java.util.List;

public class FootballManagementSystem {

    private List<FootballPlayer> footballPlayers = new ArrayList<>();

    public void addPlayer(FootballPlayer footballPlayer){
        footballPlayers.add(footballPlayer);
    }

    public void doAnalysis(IAnalyst analyst){
        footballPlayers.forEach(footballPlayer -> footballPlayer.accept(analyst));
    }
}
