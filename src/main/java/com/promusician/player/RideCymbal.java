package com.promusician.player;

import com.promusician.player.Drums.Drums;

public class RideCymbal implements Drums {
    private int beat;

    public int getBeat() {
        return beat;
    }

    public void setBeat(int beat) {
        this.beat = beat;
    }
}
