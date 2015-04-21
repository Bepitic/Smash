package com.CoffeGames.Framework2D.impl;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.CoffeGames.Framework2D.Audio;
import android.media.AudioManager;
import android.media.SoundPool;
import com.CoffeGames.Framework2D.Music;
import com.CoffeGames.Framework2D.Sound;

import java.io.IOException;

/**
 * Created by Paco on 19/04/2015.
 */
public class AndAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;

    public AndAudio(Activity activity){
        activity.setVolumeControlStream( AudioManager.STREAM_MUSIC );
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public Music newMusic(String fileName){
        try{
            AssetFileDescriptor assetDescriptor = assets.openFd(fileName);
            return new AndAudio(assetDescriptor);
        }catch (IOException e){
            throw new RuntimeException("Cloudn't load music`" + fileName + "´");
        }

    }
    @Override
    public Sound newSound(String fileName){
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(fileName);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndSound(soundPool, soundId);
        }catch (IOException e){
            throw new RuntimeException("Cloudn't load sound`" + fileName + "´");
        }
    }


}
