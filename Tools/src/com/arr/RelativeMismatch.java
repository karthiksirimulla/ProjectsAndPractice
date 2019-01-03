package com.arr;

import java.util.HashMap;
import java.util.Map;

public class RelativeMismatch
{
    public static void main( String[] args )
    {
        int a1[] = { 5, 3, 1, 2, 4 };//{ 3, 1, 2, 4, 5 };
        int a2[] = { 3, 1, 2, 4, 5 };//{ 3, 2, 4, 1, 5 };
        int n = a1.length;

        int mismatch = findMismatch( a1, a2, n );

        System.out.println( "Compatibility : " + mismatch );
    }

    private static int findMismatch( int[] a1,
                                     int[] a2,
                                     int n2 )
    {
        Map<Integer, Integer> map = new HashMap<>();
        // Value - Index
        int misMatch = 0;
        for( int i = 0; i < a1.length; i++ )
        {
            map.put( a1[i], i );
        }

        for( int i = 0; i < a2.length; i++ )
        {
            System.out.println( i + " - " + map.get( a2[i] ) );
            misMatch = misMatch + ( i - map.get( a2[i] ) );
            if( misMatch < 0 )
                misMatch = 0;

        }
        return misMatch;
    }

}
