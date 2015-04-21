package com.CoffeGames.Framework2D;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Paco on 19/04/2015.
 */
public interface FileIO {

    public InputStream readAssert(String fileName) throws IOException;
    public InputStream readFile(String fileName) throws IOException;
    public OutputStream writeFile(String fileName) throws IOException;

}
