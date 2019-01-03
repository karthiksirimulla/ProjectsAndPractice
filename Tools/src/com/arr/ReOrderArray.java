package com.arr;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Input:  arr[]   = [10, 11, 12];
        index[] = [1, 0, 2];
   Output: arr[]   = [11, 10, 12]
        index[] = [0,  1,  2] 

 * Input:  arr[]   = [50, 40, 70, 60, 90]
        index[] = [3,  0,  4,  1,  2]
Output: arr[]   = [40, 60, 90, 50, 70]
        index[] = [0,  1,  2,  3,   4] 
 * 
 */
public class ReOrderArray
{
    public static void main( String[] args )
    {
        int arr[] = { 50, 40, 70, 60, 90 };
        int index[] = { 3, 0, 4, 1, 2 };

        reorder( arr, index );

    }

    private static void reorder( int[] arr,
                                 int[] index )
    {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for( int i = 0; i < arr.length; i++ )
        {
            tMap.put( index[i], arr[i] );
        }

        AtomicInteger count = new AtomicInteger( 0 );
        tMap.entrySet().stream().forEach( e -> {
            arr[count.get()] = e.getValue();
            index[count.getAndIncrement()] = e.getKey();
        } );

        //tMap.entrySet().stream().collect( Collectors.toM )

        System.out.println( "Arr : " + Arrays.toString( arr ) );
        System.out.println( "Ind : " + Arrays.toString( index ) );

    }

}
