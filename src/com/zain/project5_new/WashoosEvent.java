package com.zain.project5_new;

public class WashoosEvent extends Event {
    int numWashoos;
    boolean hasAutoWinStick;

    public WashoosEvent(int numWashoos,boolean hasAutoWinStick,Team[] teams)
    {
        super("Washoos",teams);
        this.numWashoos=numWashoos;
        this.hasAutoWinStick=hasAutoWinStick;
    }
    public String getName() {
        return name;
    }
    public String getExtraInfo() {
        return numWashoos + "";

    }
    public int getNumWashoos() {
        return numWashoos;
    }
    public void setNumWashoos(int numWashoos) {
        this.numWashoos = numWashoos;
    }
    public boolean isHasAutoWinStick() {
        return hasAutoWinStick;
    }
    public void setHasAutoWinStick(boolean hasAutoWinStick) {
        this.hasAutoWinStick = hasAutoWinStick;
    }

}
