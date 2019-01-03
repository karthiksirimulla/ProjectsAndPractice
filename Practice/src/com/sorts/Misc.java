package com.sorts;

import java.util.Arrays;

public class Misc
{
    public static void main( String[] args )
    {
        int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
        int i = 3;
        // segregate( arr, i );

        int arr1[] = { 12, 34, 45, 9, 8, 90, 3 };
        segragateEvenOdd( arr1 );
    }

    private static void segregate( int[] arr,
                                   int i )
    {
        int seg = arr[i];//6
        int a = 0, b = arr.length - 1;
        while( a <= b )
        {
            if( arr[a] > seg && arr[b] < seg )
            {
                int temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
                a++;
                b--;
                continue;
            }

            if( arr[a] <= seg )
            {
                a++;
                continue;
            }

            if( arr[b] > seg )
            {
                b--;
                continue;
            }
        }

        /*for( int h = i; h < arr.length - 1; h++ )
        {
            if( arr[h + 1] < arr[h] )
            {
                int temp = arr[h + 1];
                arr[h + 1] = arr[h];
                arr[h] = temp;
            }
        }*/

        System.out.println( Arrays.toString( arr ) );

    }

    static void segragateEvenOdd( int[] arr )
    {
        int start = 0;
        int end = arr.length - 1;
        //12, 34, 45, 9, 8, 90, 3
        while( start < end )
        {
            // will stop on add
            while( arr[start] % 2 == 0 )
                start++;
            // will stop on even
            while( arr[end] % 2 == 1 )
                end--;

            if( start < end )
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        System.out.println( Arrays.toString( arr ) );

    }

}
