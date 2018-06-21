package com.example.kirkegaard.mathirialdesign.Tools;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Kirkegaard on 06/03/2018.
 */

public class ColorFactory
{
    public static int GetRandomColor()
    {
        int bound = 255;
        Random random = new Random();
        int red = random.nextInt(bound);
        int green = random.nextInt(bound);
        int blue = random.nextInt(bound);

        int randomColor = Color.argb(255, red, green, blue);
        return randomColor;
    }
}
