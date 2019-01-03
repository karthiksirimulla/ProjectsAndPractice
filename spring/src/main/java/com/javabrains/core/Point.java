/**
 * 
 */
package com.javabrains.core;

/**
 * @author migue
 *
 */
public class Point
{
    private int x;
    private int y;

    /**
     * @return the x
     */
    public int getX()
    {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX( int x )
    {
        System.out.println( "------ Setters" );
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY()
    {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY( int y )
    {
        this.y = y;
    }

}
