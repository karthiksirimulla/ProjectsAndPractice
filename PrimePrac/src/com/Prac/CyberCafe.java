package com.Prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * A Company is having a number is cyber cafe. Many customer visit cyber cafe and 
 * number if computers are limited. If customer don't find available computer then he leave. 
 * You have given a function with 2 arguments : 1 number of computers, 1 : a string with pairs. 
 * 1st occurrence of alphabet indicate start of customer and 
 * second occurrence indicate end. Only 1 person can use a computer at a time. 
 * Return count of customers who left cafe without using computer so that company can improve process.
    Example :
    process(1, ABAB) : should return 1 as only 1 computer is there that is occupied by A when B comes.
    process(2,ABACBCDD) : should return 0 as all customer A,B,C, D are able to use Cafe.
    process(3, ABCDCDEFEFA) : should return 2 as D and F could not use computer.
 * 
 *
 */
public class CyberCafe
{
    public static void main( String[] args )
    {
        cyberReturns( 1, "ABAB" );
        cyberReturns( 2, "ABACBCDD" );
        cyberReturns( 3, "ABCDCDEFEFA" );
        List<Integer> lList = new ArrayList<>();
        PriorityQueue<Double> lQ = new PriorityQueue<>( Collections.reverseOrder() );
        lQ.add( 1.1 );
        lQ.add( 2.3 );
        lQ.add( 0.5 );

        System.out.println( lQ.poll() );
        System.out.println( lQ.poll() );

        Map<Integer, Integer> lMap = new HashMap<>();
        lMap.put( 1, 1 );
        Object[] ss = lMap.entrySet().toArray();

        Entry<Integer, Integer> s = (Entry<Integer, Integer>) ss[0];
        System.out.println( s.getValue() );

    }

    private static void cyberReturns( int k,
                                      String string )
    {
        Set<Character> lSet = new HashSet<>();
        Set<Character> lEntrySet = new HashSet<>();
        char[] arr = string.toCharArray();
        int counter = 0;
        //ABCDCDEFEFA
        for( int i = 0; i < arr.length; i++ )
        {
            if( lSet.contains( arr[i] ) )
            {
                counter--;

            }
            else
            {
                if( counter < k && !lEntrySet.contains( arr[i] ) )
                {
                    lSet.add( arr[i] );
                    counter++;
                }
                else
                {
                    lEntrySet.add( arr[i] );
                }
            }
        }

        System.out.println( "res : " + lEntrySet.size() );

    }

}
