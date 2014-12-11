package com.zain.project5_new;

public class CompetitionManager {

    private CompetitionLinkedList linked_list;
    private Event[] events;
    public CompetitionManager(Event events[])
    {
        this.events=events;
        linked_list=new CompetitionLinkedList();
        for(int i=0;i<events.length;i++)
        {
            Team teams1[]=events[i].PeakNextTeams();
            if(teams1!=null)
                StartCompetition(events[i], teams1[0], teams1[1]);
        }
    }
    //hiding StartCompetition from other classes
    private void StartCompetition(Event event, Team team1, Team team2)
    {
        if(isEventAlreadyHappening(event))
            return;
        if(isTeamAlreadyPlaying(team1))
            return;
        if(isTeamAlreadyPlaying(team2))
            return;
        linked_list.add(event, team1, team2);

    }
    boolean isEventAlreadyHappening(Event event)
    {
        for(int i=1;i<=linked_list.size();i++)
        {
            if(linked_list.get(i).event.name==event.name)
                return true;
        }
        return false;

    }
    boolean isTeamAlreadyPlaying(Team team)
    {
        for(int i=1;i<=linked_list.size();i++)
        {
            if(linked_list.get(i).team1==team||linked_list.get(i).team2==team)
                return true;
        }
        return false;

    }
    ICompetition[] GetCompetitions()
    {
        ICompetition[] competitions=new ICompetition[linked_list.size()];
        for(int i=0;i<competitions.length;i++)
            competitions[i]=linked_list.get(i+1);
        return competitions;
    }
    public void EndCompetition(Competition competition, Team winningTeam)
    {
        for(int i=0;i<linked_list.size();i++)
        {
            if(linked_list.get(i+1)==competition)
            {
                linked_list.get(i+1).setWinningTeam(winningTeam);
                winningTeam.wins++;

                if(linked_list.get(i+1).team1==winningTeam)
                    linked_list.get(i+1).team2.losses++;
                else
                    linked_list.get(i+1).team1.losses++;

                Event current_event=linked_list.get(i+1).event;
                Team teams[]=current_event.GetNextTeams();
                if(teams==null)
                {
                    Team winner=current_event.bracketing_system.front();
                    Team loser=current_event.placing_system.getLoser();
                    current_event.ReturnTeams(winner, loser);
                }
                else
                {
                    current_event.bracketing_system.enqueue(winningTeam);
                    if(linked_list.get(i+1).team1==winningTeam)
                        current_event.placing_system.push(teams[1]);
                    else
                        current_event.placing_system.push(teams[0]);

                }
                linked_list.remove(i+1);
            }

        }
        for(int i=0;i<events.length;i++)
        {
            Team teams[]=events[i].PeakNextTeams();
            if(teams!=null)
                StartCompetition(events[i], teams[0], teams[1]);
        }



    }

}

class CompetitionLinkedList {

    private Competition head;
    private int listCount;

    // LinkedList constructor
    public CompetitionLinkedList() {

        head = new Competition(null,null,null);
        listCount = 0;
    }

    public void add(Event event,Team team1,Team team2)
    {
        Competition Temp = new Competition(event,team1,team2);
        Competition current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(Temp);
        listCount++;// increment the number of elements variable
    }

    public void add(Event event,Team team1,Team team2, int index)
    // inserts the specified element at the specified position in this list
    {
        Competition Temp = new Competition(event,team1,team2);
        Competition current = head;
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        Temp.setNext(current.getNext());
        current.setNext(Temp);
        listCount++;// increment the number of elements variable
    }

    public Competition get(int index)
    // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index <= 0)
            return null;

        Competition current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return null;

            current = current.getNext();
        }
        return current;
    }

    public boolean remove(int index)
    // removes the element at the specified position in this list.
    {
        if (index < 1 || index > size())
            return false;

        Competition current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return false;

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--;
        return true;
    }

    public int size()
    {
        return listCount;
    }



}
