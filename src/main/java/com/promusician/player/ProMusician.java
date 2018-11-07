package com.promusician.player;

public class ProMusician {

    public static void main(String[] args) {
        //创建Metronome基础乐队
        Metronome metronome=new Metronome();
        //设置BPM，即default为一秒一拍
        metronome.setBPM(Metronome.DEFUALT_BPM);
        metronome.setTempo(4);

        //初始化循环次数
        Times t=new Times(5);

        //初始化乐器
        RideCymbal r=new RideCymbal();
        r.setHit(1);

        //定义演奏规则
        Tips tips =new Tips() {
            @Override
            public void tips() {
                super.tips();
            }
        };

        //开始演奏
        metronome.begin();


    }
}
