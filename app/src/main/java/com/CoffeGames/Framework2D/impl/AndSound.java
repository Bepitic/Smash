package com.CoffeGames.Framework2D.impl;

import android.media.SoundPool;
import com.CoffeGames.Framework2D.Sound;

/**
 * Created by Paco on 19/04/2015.
 */
public class AndSound implements Sound {
    int soundId;
    SoundPool soundPool;

    public AndSound(SoundPool soundPool, int soundId ){
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume){
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }
    @Override
    public void dispose(){
        soundPool.unload(soundId);
    }

}
