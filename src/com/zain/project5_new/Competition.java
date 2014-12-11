package com.zain.project5_new;

public class Competition implements ICompetition{
    Event event;
    Team team1,team2;
    Competition next;
    Team winningTeam;
    public Competition(Event event,Team team1,Team team2)
    {
        this.event=event;
        this.team1=team1;
        this.team2=team2;
    }
    public Competition(Event event,Team team1,Team team2,Competition next)
    {
        this.event=event;
        this.team1=team1;
        this.team2=team2;
        this.next=next;
    }

    public Event getEvent() {
        return event;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }
    public Team getWinningTeam()
    {
        return winningTeam;
    }
    public Competition getNext() {
        return next;
    }
    public void setNext(Competition next) {
        this.next = next;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
    public void setWinningTeam(Team team)
    {
        this.winningTeam=team;
    }


}
