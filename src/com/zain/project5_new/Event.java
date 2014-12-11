package com.zain.project5_new;

public abstract class Event {
    public BracketingSystem bracketing_system;
    public PlacingSystem placing_system;
    public String name;
    public int playTo;
    public boolean isPlayToExact;
    public int playDistance;
    public Team[] teams;
    private Team loser=null;
    private Team winner=null;

    public Event(String name,Team[] teams) {
        this.name=name;
        this.teams=teams;
        bracketing_system=new BracketingSystem();
        placing_system=new PlacingSystem(teams.length);
        for(int i=0;i<teams.length;i++)
            bracketing_system.enqueue(teams[i]);

    }
    public abstract String getExtraInfo();

    Team[] PeakNextTeams()
    {
        if(bracketing_system.getTotal()==1)
            return null;

        Team[] next=new Team[2];
        next[0]=bracketing_system.front();
        next[1]=bracketing_system.NextTofront();
        return next;
    }
    Team[] GetNextTeams()
    {
        if(bracketing_system.getTotal()==1)
            return null;

        Team[] next=new Team[2];
        next[0]=bracketing_system.dequeue();
        next[1]=bracketing_system.dequeue();
        return next;
    }

    void ReturnTeams(Team winner, Team loser)
    {
        this.winner=winner;
        this.loser=loser;
    }

}
class BracketingSystem
{
    private int total;

    private Node first, last;

    private class Node {
        private Team team;
        private Node next;
    }

    public BracketingSystem() {
        total=0;
    }

    public BracketingSystem enqueue(Team ele)
    {
        Node current = last;
        last = new Node();
        last.team = ele;

        if (total++ == 0) first = last;
        else current.next = last;

        return this;
    }
    public Team front()
    {
        return first.team;
    }
    public Team NextTofront()
    {
        return first.next.team;
    }

    public Team dequeue()
    {
        if (total == 0) throw new java.util.NoSuchElementException();
        Team ele = first.team;
        first = first.next;
        if (--total == 0) last = null;
        return ele;
    }

    public int getTotal() {
        return total;
    }



}

class PlacingSystem  {

    private int total;
    private int total_teams;

    private Node first;

    private class Node {
        private Team team;
        private Node next;
    }

    public PlacingSystem(int total_teams) {
        this.total_teams=total_teams;
    }

    public PlacingSystem push(Team ele)
    {
        Node current = first;
        first = new Node();
        first.team = ele;
        first.next = current;
        total++;
        return this;
    }
    public Team top()
    {
        return first.team;
    }

    public Team pop()
    {
        if (first == null) new java.util.NoSuchElementException();
        Team ele = first.team;
        first = first.next;
        total--;
        return ele;
    }

    public int getTotal() {
        return total;
    }
    public void printPlaces()
    {
        int place=total_teams-getTotal()+1;
        Node current = first;
        while(current!=null)
        {
            Team current_team=current.team;
            System.out.println("Place #"+place +": Team  => Members : " + current_team.getTeam_olymp1().getName() + " and " +current_team.getTeam_olymp2().getName() );
            place++;
            current=current.next;
        }
        if(first==null)
            System.out.println("no teams placed yet");

    }

    public Team getLoser() {
        Node current = first;
        while(current.next!=null)
        {
            current=current.next;
        }
        return current.team;
    }



}
