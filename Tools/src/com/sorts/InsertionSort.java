package com.sorts;

import java.util.Arrays;

public class InsertionSort
{
    public static void main( String[] args )
    {
        int[] arr = { 7, 2, 4, 1, 5, 3 };
        sort( arr );
        // {7,2,     4,1,5,3}

        /* int[] rarr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotateArray( rarr, k );*/

    }

    private static void sort( int[] arr )
    {
        int len = arr.length;
        for( int i = 1; i < len; i++ )
        {
            int val = arr[i];
            int hole = i;
            while( hole > 0 && arr[hole - 1] > val )
            {
                arr[hole] = arr[hole - 1];
                hole--;
            }
            arr[hole] = val;

        }
        System.out.println( Arrays.toString( arr ) );

    }

    private static void sortCodeSchool( int[] arr )
    {
        int len = arr.length;
        for( int i = 1; i < len; i++ )
        {
            int val = arr[i];
            int hole = i;
            while( hole > 0 && arr[hole - 1] > val )
            {
                arr[hole] = arr[hole - 1];
                hole = hole - 1;
            }
            arr[hole] = val;
        }

        System.out.println( Arrays.toString( arr ) );

    }

    private static void rotateArray( int[] arr,
                                     int k )
    {
        int len = arr.length;
        while( k > 0 )
        {
            int val = arr[len - 1];
            for( int i = len - 1; i > 0; i-- )
            {
                arr[i] = arr[i - 1];

            }
            arr[0] = val;
            k--;

            System.out.println( Arrays.toString( arr ) );
        }

    }

}
