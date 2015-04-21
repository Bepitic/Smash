package com.CoffeGames.Framework2D.impl;

import com.CoffeGames.Framework2D.FileIO;
import android.content.res.AssetManager;
import android.os.Environment;
import com.CoffeGames.Framework2D.Input;
import com.CoffeGames.Framework2D.Screen;

import java.io.*;


/**
 * Created by Paco on 19/04/2015.
 */
public class AndFileIO implements FileIO {
    AssetManager assets;
    String externalStoragePath;

    public AndFileIO(AssetManager assets){
        this.assets = assets;
        this.externalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }
    @Override
    public InputStream readAssert(String fileName) throws IOException{
        return assets.open(fileName);
    }
    @Override
    public InputStream readFile(String fileName) throws IOException{
        return new FileInputStream(externalStoragePath + fileName);
    }
    @Override
    public OutputStream writeFile(String fileName) throws IOException{
        return new FileOutputStream(externalStoragePath + fileName);
    }


}
