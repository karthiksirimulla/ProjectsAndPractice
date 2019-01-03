package com.arr;

import java.util.HashMap;
import java.util.Map;

public class FindDistinctPairs
{
    public static void main( String[] args )
    {
        int[] arr = { 6, 6, 3, 9, 3, 5, 1 }; //{ 1, 3, 46, 1, 3, 9 }; // 6,3,9,5,1
        int sum = 12;
        int res = numberOfPairs( arr, sum );
        System.out.println( "Distinct pairs : " + res );

    }

    static int numberOfPairs( int[] arr,
                              int k )
    {
        Map<Integer, Integer> map = new HashMap<>();
        for( int i = 0; i < arr.length; i++ )
        {
            if( map.containsKey( arr[i] ) )
            {
                map.put( arr[i], map.get( arr[i] ) + 1 );

            }
            else
            {
                map.put( arr[i], 1 );
            }
        }

        int count = 0;
        for( Integer j : map.keySet() )
        {
            if( map.containsKey( j ) && map.containsKey( k - j ) )
            {
                count++;
            }

        }

        return count / 2;

    }

}
