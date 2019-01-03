package com.Java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaEight
{
    public static void main( String[] args )
    {
        List<Integer> list = new ArrayList<>();
        for( int i = 0; i < 10; i++ )
            list.add( i );

        list.forEach( j -> {
            System.out.println( j );
        } );

        Map<String, Integer> dMap = new HashMap<String, Integer>()
        {
            {
                put( "a", 1 );
                put( "b", 2 );
            }
        };
        ;
        for( int i = 0; i < 10; i++ )
        {
            dMap.put( String.valueOf( i ), i );
        }

        dMap.entrySet().forEach( e -> {
            System.out.println( e.getKey() + " - " + e.getValue() );
        } );

        Integer ss = dMap.get( "1" );
        System.out.println( "SS :" + ss );

    }

    private static void print( Integer i )
    {
        System.out.println( i );

    }
}
