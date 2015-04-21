package com.CoffeGames.Framework2D.impl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by Paco on 20/04/2015.
 */
public class AcelerometrerHandler implements SensorEventListener {
    float accelX;
    float accelY;
    float accelZ;
    public class AcelerometerHandler (Context context){
        SensorManager manager = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0 ){
            Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        }
        
    }
    @Override
    public void onAcurracyChanged(Sensor sensor, int accurracy){
        // nothing to do
    }
    @Override
    public void onSensorChanged(SensorEvent event){
        accelX = event.values[0];
        accelY = event.values[1];
        accelZ = event.values[2];
    }
    public float getAccelX(){
        return accelX;
    }
    public float getAccelY(){
        return accelY;
    }
    public float getAccelZ(){
        return accelZ;
    }

}
