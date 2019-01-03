package com.javabrains.core;

import org.springframework.beans.factory.annotation.Autowired;

public class Circle implements Shape
{
    private Point center;

    public Point getCenter()
    {
        return center;
    }

    @Autowired
    public void setCenter( Point center )
    {
        this.center = center;
    }

    public void draw()
    {
        System.out.println( "Drawing Circle ...." );
        System.out.println( "Center = " + "(" + center.getX() + "," + center.getY() + ")" );

    }

}
