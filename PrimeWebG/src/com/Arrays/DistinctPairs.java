package com.Arrays;

import java.util.HashSet;
import java.util.Set;

public class DistinctPairs
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 2, 3, 6, 7, 8, 9, 1 };
        int k = 10;

        int res = findDistinctPairs( arr, k );
        System.out.println( "Distinct  : " + res );
    }

    private static int findDistinctPairs( int[] arr,
                                          int k )
    {
        Set<Integer> set = new HashSet<>();

        int count = 0;
        for( int i = 0; i < arr.length; i++ )
        {
            int t = arr[i];
            if( set.contains( Math.abs( t - k ) ) )
            {
                System.out.println( "Distinct pair : (" + t + " , " + Math.abs( t - k ) + " )" );
                count++;

            }
            else
            {
                set.add( arr[i] );
            }

        }
        return count;
    }

}
