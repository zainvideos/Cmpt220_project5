package com.zain.project5_new;

public class StickGameEvent extends Event {
    int frisbeeSize;

    public StickGameEvent(int frisbeeSize,Team[] teams)
    {
        super("StickGame",teams);
        this.frisbeeSize=frisbeeSize;
    }
    public String getName() {
        return name;}
    public String getExtraInfo() {
        return frisbeeSize + "";

    }
    public int getfrisbeeSize(){
        return frisbeeSize;
    }
    public void setfrisbeeSize(int frisbeeSize){
        this.frisbeeSize=frisbeeSize;
    }
}