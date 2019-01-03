package com.collections;

import java.util.Deque;
import java.util.LinkedList;

public class Test
{

    public static void main( String[] args )
    {
        Deque<Integer> aa = new LinkedList<>();
        aa.add( 1 );
        aa.add( 2 );
        aa.add( 3 );
        aa.addFirst( 5 );
        aa.addLast( 5 );

        while( !aa.isEmpty() )
        {
            aa.removeLastOccurrence( 5 );

            System.out.print( aa.poll() + " " );
        }
    }

}
