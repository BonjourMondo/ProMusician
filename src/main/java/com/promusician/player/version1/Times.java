package com.promusician.player.version1;

@Deprecated
public class Times {
    public static final int FOREVER=Integer.MAX_VALUE;

    private int times;

    public Times(int times) {
        this.times = times;
    }

    public Times() {
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
