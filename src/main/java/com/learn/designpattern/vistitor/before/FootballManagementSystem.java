package com.learn.designpattern.vistitor.before;

import java.util.ArrayList;
import java.util.List;

public class FootballManagementSystem {

    private List<FootballPlayer> footballPlayers = new ArrayList<>();

    public void addPlayer(FootballPlayer footballPlayer){
        footballPlayers.add(footballPlayer);
    }

    public void handle(CoachType coachType) {
        switch (coachType) {
            case Coach:
                footballPlayers.forEach(FootballPlayer::getRating);
                break;
            case OffensiveCoach:
                footballPlayers.forEach(footballPlayer -> {
                    if(footballPlayer instanceof Forward){
                        Forward forward = (Forward)footballPlayer;
                        forward.getGoal();
                    } else if(footballPlayer instanceof Midfielder){
                        Midfielder midfielder = (Midfielder)footballPlayer;
                        midfielder.getAssist();
                    }
                });
                break;
            case DefensiveCoach:
                footballPlayers.forEach(footballPlayer -> {
                    if(footballPlayer instanceof Midfielder){
                        Midfielder midfielder = (Midfielder)footballPlayer;
                        midfielder.getRating();
                    } else if(footballPlayer instanceof CentreBack){
                        CentreBack centreBack = (CentreBack) footballPlayer;
                        centreBack.getClearance();
                    }
                });
                break;
        }
    }

    public enum CoachType {
        Coach, OffensiveCoach, DefensiveCoach
    }
}
