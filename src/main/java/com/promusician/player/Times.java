package com.promusician.player;

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
