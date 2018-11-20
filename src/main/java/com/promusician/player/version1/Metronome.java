package com.promusician.player.version1;

@Deprecated
public class Metronome {
    public static final int DEFUALT_BPM=60;

    private int BPM;
    private int tempo;

    public void begin(){
        //实现演奏的队列，调用前端
    }


    public int getBPM() {
        return BPM;
    }

    public void setBPM(int BPM) {
        this.BPM = BPM;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
