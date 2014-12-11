package com.zain.project5_new;

public class HorseShoesEvent extends Event {

    int numHorseShoes;
    public HorseShoesEvent(int numHorseShoes,Team[] teams) {
        super("HorseShoes",teams);
        this.numHorseShoes=numHorseShoes;
    }

    public String getName() {
        return name;}
    public String getExtraInfo() {
        return numHorseShoes + "";

    }
    public int getnumHorseShoes(){
        return numHorseShoes;
    }
    public void setnumHorseShoes(int numHorseShoes){
        this.numHorseShoes=numHorseShoes;
    }

}