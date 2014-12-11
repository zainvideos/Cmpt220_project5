package com.zain.project5_new;

/**
 * Created by Zain on 11/20/2014.
 */
public class Team {
    // construct team object
    Olympian team_olymp1;
    Olympian team_olymp2;
    int wins;
    int losses;

    public Team (Olympian olympian1, Olympian olympian2){
        this.team_olymp1 = olympian1;
        this.team_olymp2 = olympian2;
        wins=0;
        losses=0;

    }

    public Olympian getTeam_olymp1() {
        return team_olymp1;
    }

    public void setTeam_olymp1(Olympian team_olymp1) {
        this.team_olymp1 = team_olymp1;
    }

    public Olympian getTeam_olymp2() {
        return team_olymp2;
    }

    public void setTeam_olymp2(Olympian team_olymp2) {
        this.team_olymp2 = team_olymp2;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

}
