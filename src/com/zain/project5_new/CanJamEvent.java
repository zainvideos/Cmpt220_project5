package com.zain.project5_new;

public class CanJamEvent extends Event {
    int frisbeeSize;
    public CanJamEvent(int frisbeeSize,Team[] teams) {
        super("CanJam",teams);
        this.frisbeeSize=frisbeeSize;
    }

    public String getName() {
        return name;}
    public String getExtraInfo() {
        return frisbeeSize + "";

    }
    public int getnumHorseShoes(){
        return frisbeeSize;
    }
    public void setfrisbeeSize(int frisbeeSize){
        this.frisbeeSize=frisbeeSize;
    }
}