package com.CoffeGames.Framework2D.impl;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.CoffeGames.Framework2D.Music;
import android.media.MediaPlayer.OnCompletionListener;

import java.io.IOException;

/**
 * Created by Paco on 19/04/2015.
 */
public class AndMusic implements Music, OnCompletionListener {
    MediaPlayer mediaPlayer;
    boolean isPrepared = false;

    public AndMusic (AssetFileDescriptor assetDescriptor){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(), assetDescriptor.getStartOffset(), assetDescriptor.getLength());
            mediaPlayer.prepare();
            isPrepared = true;
            mediaPlayer.setOnCompletionListener(this);
        }catch (Exception e){
            throw new RuntimeException("Couldn't load music");
        }
    }

    @Override
    public void dispose(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

    @Override
    public  boolean isLooping(){
        return mediaPlayer.isLooping();
    }
    @Override
    public boolean isPlaying(){
        return mediaPlayer.isPlaying();
    }
    @Override
    public  boolean isStopped(){
        return !isPrepared;
    }
    @Override
    public void play(){

        if(mediaPlayer.isPlaying()){
            return;
        }
        try {
            synchronized (this) {
                if (!isPrepared) {
                    mediaPlayer.prepare();
                }
                mediaPlayer.start();
            }
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void setLooping( boolean isLooping){
        mediaPlayer.setLooping(isLooping);
    }
    @Override
    public void setVolume(float volume){
        mediaPlayer.setVolume(volume, volume);
    }
    @Override
    public void stop(){
        mediaPlayer.stop();
        synchronized (this){
            isPrepared = false;
        }
    }
    @Override
    public void onCompletion(MediaPlayer mediaPlayer){

    }
}
