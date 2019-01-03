package com.misc;

public class Singleton
{
    private static final Singleton single = new Singleton();

    private Singleton()
    {

    }

    public Singleton getInstance()
    {
        if( null == single )
        {
            synchronized( Singleton.class )
            {
                return single;
            }
        }
        return single;
    }

}
