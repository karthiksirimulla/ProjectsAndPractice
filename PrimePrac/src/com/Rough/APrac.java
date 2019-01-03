package com.Rough;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class APrac
{
    /**
     * 
     */
    public static void main( String[] args )
    {
        int[] num = { 2, 4 };
        int[] den = { 3, 5 };

        int[] res = { ( num[0] * den[1] + num[1] * den[0] ), den[0] * den[1] };
        System.out.println( Arrays.toString( res ) );

        Comparator<Integer> lDescen = new Comparator<Integer>()
        {

            @Override
            public int compare( Integer o1,
                                Integer o2 )
            {
                if( o1 == null || o2 == null )
                    return 0;
                if( o1 > o2 )
                    return 1;
                else
                    return -1;
            }
        };

        Map<Integer, Integer> lMap = new TreeMap<>( lDescen );
        lMap.put( 1, 1 );
        lMap.put( 3, 3 );
        lMap.put( 2, 2 );

        for( Entry<Integer, Integer> e : lMap.entrySet() )
            System.out.println( e.getValue() );

        Deque<Integer> lQ = new LinkedList<>();
        lQ.addFirst( 1 );
        lQ.removeLast();

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.add( 2 );
        pQ.add( 3 );
        pQ.add( 1 );

        System.out.println( "-------------------------" );
        System.out.println( pQ.poll() );
        System.out.println( pQ.peek() );
        System.out.println( pQ.peek() );

        Map<Integer, Integer> lMaop = new ConcurrentHashMap<>();

        System.out.println( 18 / 10 + "----------" + 18 % 10 );
        String str = "POLE";
        StringBuilder ss = new StringBuilder();

        Map<Integer, Integer> lLinked = new LinkedHashMap<>( 3 );
        lLinked.put( 1, 1 );
        lLinked.put( 2, 1 );
        lLinked.put( 3, 1 );
        System.out.println( lLinked.size() );
        lLinked.put( 4, 1 );
        System.out.println( lLinked.size() );

    }

}
