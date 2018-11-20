package com.promusician.player.version1;

import com.promusician.player.version1.Drums.Drums;

@Deprecated
public class RideCymbal implements Drums {
    private int beat;

    public int getBeat() {
        return beat;
    }

    public void setBeat(int beat) {
        this.beat = beat;
    }
}
