package com.zain.project5_new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome To the Smith Family Olympics App.");

        OlympianManager olympain_manager=new OlympianManager();
        Olympian[] olympians=olympain_manager.getOlympians();

        TeamManager team_manager=new TeamManager(olympians);
        Team[] teams=team_manager.getTeams();

        EventManager event_manager=new EventManager(teams);
        Event[] events=event_manager.getEvents();

        CompetitionManager competition_manager=new CompetitionManager(events);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println("Please enter a command or type h for help : ");
            String command=br.readLine();
            if(command.equals("h")||command.equals("help"))
            {
                System.out.println("The following commands are available");
                System.out.println("events or e: list events");
                System.out.println("teams or t: list teams");
                System.out.println("competitions or c: list the currently running competitions");
                System.out.println("endcompetition or ec: end a currently running competition");
                System.out.println("quit or q: to quit (quitting is for losers)");
                System.out.println("help or h: for help(i think this is easy enough though...)");
            }
            else if(command.equals("e")||command.equals("events"))
            {
                System.out.println("The following events are today: ");
                int index=1;
                for (Event event : events) {
                    System.out.println("#" + index+ " " + event.name);
                    System.out.println("Following are currently placed teams for " + event.name);
                    event.placing_system.printPlaces();
                    index++;
                }
            }
            else if(command.equals("t")||command.equals("teams"))
            {
                System.out.println("The following teams are participating today: ");
                int index=1;
                for (Team team : teams) {
                    System.out.println("Team #"+index+" => Members : " + team.getTeam_olymp1().getName() + " and " +team.getTeam_olymp2().getName() );
                    index++;
                }
            }
            else if(command.equals("c")||command.equals("competitions"))
            {
                ICompetition[] running_competitions=competition_manager.GetCompetitions();
                System.out.println("Currently Running competitions are as follows: ");
                for(int i=0;i<running_competitions.length;i++)
                {
                    Event e=running_competitions[i].getEvent();
                    Team team1=running_competitions[i].getTeam1();
                    Team team2=running_competitions[i].getTeam2();
                    System.out.println("Competition :" + (i+1));
                    System.out.println("Event Name: " + e.name);
                    System.out.println("Team 1 => Members : " + team1.getTeam_olymp1().getName() + " and " +team1.getTeam_olymp2().getName() );
                    System.out.println("Team 2 => Members : " + team2.getTeam_olymp1().getName() + " and " +team2.getTeam_olymp2().getName() );
                    System.out.println("");
                }
                if(running_competitions.length==0)
                    System.out.println("No running competitions");

            }

            else if(command.equals("ec")||command.equals("endcompetition"))
            {

                ICompetition[] running_competitions=competition_manager.GetCompetitions();
                System.out.println("Currently Running competitions are as follows: ");
                for(int i=0;i<running_competitions.length;i++)
                {
                    Event e=running_competitions[i].getEvent();
                    Team team1=running_competitions[i].getTeam1();
                    Team team2=running_competitions[i].getTeam2();
                    System.out.println("Competition :" + (i+1));
                    System.out.println("Event Name: " + e.name);
                    System.out.println("Team 1 => Members : " + team1.getTeam_olymp1().getName() + " and " +team1.getTeam_olymp2().getName() );
                    System.out.println("Team 2 => Members : " + team2.getTeam_olymp1().getName() + " and " +team2.getTeam_olymp2().getName() );
                    System.out.println("");
                }
                System.out.println("Enter which competition to end : ");
                int option=Integer.parseInt(br.readLine());
                if(option<=0||option>running_competitions.length)
                {
                    System.out.println("Invalid contest selected! Please choose between 1 and " + running_competitions.length);
                    continue;
                }
                System.out.println("Enter winning team (1/2): ");
                int winning=Integer.parseInt(br.readLine());
                if(winning==1||winning==2)
                {
                    if(winning==1)
                        competition_manager.EndCompetition((Competition) running_competitions[option-1], running_competitions[option-1].getTeam1());
                    else
                        competition_manager.EndCompetition((Competition) running_competitions[option-1], running_competitions[option-1].getTeam2());

                }
                else
                {
                    System.out.println("team selected should be 1 or 2");
                }

            }
            else if(command.equals("q")||command.equals("quit"))
            {
                break;
            }


        }
        br.close();


    }
}
