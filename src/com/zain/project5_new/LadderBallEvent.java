package com.zain.project5_new;

public class LadderBallEvent extends Event {

    int numRugs;
    public LadderBallEvent(int numRugs,Team[] teams)
    {
        super("LadderBall",teams);
        this.numRugs=numRugs;
    }
    public String getName() {
        return name;}
    public String getExtraInfo() {
        return numRugs + "";

    }
    public int getNumRugs() {
        return numRugs;
    }
    public void setNumRugs(int numRugs) {
        this.numRugs = numRugs;
    }


}