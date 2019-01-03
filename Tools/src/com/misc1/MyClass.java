package com.misc1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MyClass
{
    int i;
    double j;

    @SuppressWarnings( "finally" )
    public int method()
    {
        try
        {
            return 2;
        }
        finally
        {
            return 5;
        }
    }

    @SuppressWarnings( "unchecked" )
    public static Collection get()
    {
        Collection sorted = new LinkedList<>();
        sorted.add( "B" );
        sorted.add( "C" );
        sorted.add( "A" );
        return sorted;
    }

    public static void main( String[] args )
    {
        MyClass cls = new MyClass();

        //   System.out.println( cls.i + " " + cls.j );

        //  System.out.println( cls.method() );

        NavigableMap<Integer, String> nM = new ConcurrentSkipListMap<>();

        nM.put( 4, "WED" );
        nM.put( 5, "THU" );
        nM.put( 6, "FRI" );
        nM.put( 1, "SUN" );
        nM.put( 2, "MON" );

        System.out.println( nM.ceilingKey( 1 ) );
        System.out.println( nM.floorEntry( 3 ) );

        System.out.println( nM.higherEntry( 2 ) );
        System.out.println( nM.ceilingKey( 2 ) );
        System.out.println( nM.ceilingKey( 3 ) );
        System.out.println( nM.ceilingKey( 4 ) );

        for( Object obj : get() )
        {
            System.out.println( "-->" + obj );
        }

    }

}
