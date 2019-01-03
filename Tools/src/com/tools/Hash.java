package com.tools;

import java.util.HashMap;

class Tent
{
    int data;

    public Tent( int data )
    {
        this.data = data;
    }

    @Override
    public int hashCode()
    {
        return data % 10;
    }

    @Override
    public boolean equals( Object obj )
    {
        if( data % 2 == 0 )
            return true;
        return false;
    }

}

public class Hash
{

    public static void main( String[] args )
    {
        HashMap<Tent, String> map = new HashMap<>();
        Tent t = new Tent( 2 );
        map.put( t, "testclass1" );
        Tent t1 = new Tent( 2 );
        map.put( t, "testClass1" );

        System.out.println( map.size() );

        t = new Tent( 2 );
        map.put( t, "testClass2" );
        System.out.println( map.size() );

    }

}
