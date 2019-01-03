package com.Prac;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Example:  For the input array {1,2,2,2,4,4,4,4,5,5,5,5,5,7,7,8,8,8,8}
    if n = 1, then the output returned should be 5 because it is the most frequent number,
    if n = 2, output can be either 4 or 8 since any of these numbers could be considered as the 2nd most frequent number,
    if n = 3, again output can be either 4 or 8
    if n = 4, output should be 2.
 *
 */

public class NthFreqInArray
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 2, 2, 2, 4, 4, 4, 4, 5, 5, 5, 5, 5, 7, 7, 8, 8, 8, 8 };
        TreeMap<Integer, Integer> lMap = new TreeMap<>();
        generateFrequency( arr, lMap );

        int n = 4;

        char c = '1';
        System.out.println();

        for( Entry<Integer, Integer> e : lMap.entrySet() )
        {
            System.out.println( e.getKey() + " -- " + e.getValue() );
        }

    }

    private static void generateFrequency( int[] arr,
                                           TreeMap<Integer, Integer> lMap )
    {
        int count = 1;
        for( int i = 0; i < arr.length - 1; i++ )
        {
            if( arr[i] != arr[i + 1] )
            {
                lMap.put( arr[i], count );
                count = 1;
                continue;
            }
            count++;
        }

        lMap.put( arr[arr.length - 1], count );

    }

}
