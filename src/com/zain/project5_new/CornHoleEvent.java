package com.zain.project5_new;

public class CornHoleEvent extends Event {

    int numBeanBags;

    public CornHoleEvent(int numBeamBags,Team[] teams)
    {
        super("CornHole",teams);
        this.numBeanBags=numBeamBags;
    }
    public String getName() {
        return name;}
    public String getExtraInfo() {
        return numBeanBags + "";

    }
    public int getnumBeanBags(){
        return numBeanBags;
    }
    public void setnumBeanBags(int numBeanBags){
        this.numBeanBags=numBeanBags;
    }


}
