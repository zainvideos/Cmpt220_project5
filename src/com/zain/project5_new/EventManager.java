package com.zain.project5_new;

import java.util.Random;

public class EventManager {

    Event[] events;
    public  EventManager(Team[] teams) {

        shuffleArray(teams);
        LadderBallEvent Event1 = new LadderBallEvent(5,teams);

        StickGameEvent Event2 = new StickGameEvent(3,teams);
        WashoosEvent Event3 = new WashoosEvent(10,false,teams);
        CanJamEvent Event4 = new CanJamEvent(12,teams);
        CornHoleEvent Event5 = new CornHoleEvent(30,teams);
        HorseShoesEvent Event6 = new HorseShoesEvent(5,teams);
        events = new Event[]{
                Event3, Event2, Event1, Event4, Event5, Event6};
    }
    public Event[] getEvents()
    {
        return events;
    }

    // Implementing Fisher–Yates shuffle
    private void shuffleArray(Team[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Team a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}