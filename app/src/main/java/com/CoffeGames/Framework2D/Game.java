package com.CoffeGames.Framework2D;

/**
 * Created by Paco on 19/04/2015.
 */
public interface Game {
    public Input getInput();
    public FileIO getFileIO();
    public Graphics getGraphics();
    public Audio getAudio();
    public void setScreen(Screen screen);
    public Screen getCurrentScreen();
    public Screen getStartScreen();

}
