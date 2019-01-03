package com.Rough;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionPrac
{
    public static void main( String[] args )
    {
        PriorityQueue<Integer> pQ = new PriorityQueue<>( new Comparator<Integer>()
        {

            @Override
            public int compare( Integer o1,
                                Integer o2 )
            {
                if( o1 == null || o2 == null )
                    return 0;
                if( o1 > o2 )
                    return -1;
                return 1;
            }
        } );

        pQ.add( 2 );
        pQ.add( 3 );
        pQ.add( 1 );
        pQ.add( 5 );
        pQ.add( 4 );
        while( !pQ.isEmpty() )
            System.out.println( pQ.poll() );

        System.out.println( pQ.toString() );

        TreeMap<Integer, Integer> lMap = new TreeMap<>();

        Map<Integer, Integer> lConc = new ConcurrentHashMap<>();
    }

}
