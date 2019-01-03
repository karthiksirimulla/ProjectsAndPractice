package com.sorts;

import java.util.Arrays;

public class QuickSort
{
    public static void main( String[] args )
    {
        int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };

        quickSort( arr, 0, arr.length - 1 );
        System.out.println( Arrays.toString( arr ) );

    }

    private static void quickSort( int[] arr,
                                   int start,
                                   int end )
    {
        if( start < end )
        {
            int pIndex = partition( arr, start, end );
            quickSort( arr, start, pIndex - 1 );
            quickSort( arr, pIndex + 1, end );
        }
    }

    private static int partition( int[] arr,
                                  int start,
                                  int end )
    {
        int pivot = arr[end];
        int pIndex = start;
        for( int i = start; i < end; i++ )
        {
            if( arr[i] <= pivot )
            {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;

                pIndex++;
            }
        }

        int temp = arr[end];
        arr[end] = arr[pIndex];
        arr[pIndex] = temp;
        return pIndex;
    }

}
