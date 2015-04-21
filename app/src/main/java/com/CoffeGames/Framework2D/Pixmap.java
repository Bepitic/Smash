package com.CoffeGames.Framework2D;

import com.CoffeGames.Framework2D.Graphics.PixmapFormat;

/**
 * Created by Paco on 19/04/2015.
 */


public interface Pixmap {
    public int getWidth();
    public int getHeight();
    public PixmapFormat getFormat();
    public void dispose();

}
