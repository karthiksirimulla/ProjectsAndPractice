package com.DP;

import java.util.Arrays;

/*
 * 
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the 
 * longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LIS
{
    public static void main( String[] args )
    {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };//{ 90, 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        int res = getLISCount( arr, arr.length );
        System.out.println( "Res : " + res );
        printLIS( arr, arr.length );

    }

    private static int getLISCount( int[] arr,
                                    int n )
    {
        int lis[] = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for( i = 0; i < n; i++ )
            lis[i] = 1;

        //{ 10, 22, 9, 33, 21, 50, 41, 60 };

        /* Compute optimized LIS values in bottom up manner */
        for( i = 1; i < n; i++ )
            for( j = 0; j < i; j++ )
            {
                if( arr[i] > arr[j] && lis[i] < lis[j] + 1 )
                {
                    lis[i] = lis[j] + 1;
                }
            }

        /* Pick maximum of all LIS values */
        for( i = 0; i < n; i++ )
            if( max < lis[i] )
                max = lis[i];
        System.out.println( "LIS : " + Arrays.toString( lis ) );

        return max;
    }

    private static void printLIS( int[] arr,
                                  int n )
    {
        int lis[] = new int[n];
        int i, j = 0;

        /* Initialize LIS values for all indexes */
        for( i = 0; i < n; i++ )
            lis[i] = 1;

        //{ 10, 22, 9, 33, 21, 50, 41, 60 };
        int index = 0;
        int maxIndex = 0;
        int minIndex = -1;

        /* Compute optimized LIS values in bottom up manner */
        for( i = 1; i < n; i++ )
        {
            for( j = 0; j < i; j++ )
            {
                if( arr[i] > arr[j] && lis[i] < lis[j] + 1 )
                {
                    lis[i] = lis[j] + 1;
                    index = i;
                    if( minIndex == -1 )
                        minIndex = j;
                    if( index > maxIndex )
                        maxIndex = index;
                }
            }
        }

        int temp = arr[minIndex];
        System.out.print( temp + ", " );

        for( int k = minIndex + 1; k <= maxIndex; k++ )
        {
            if( temp < arr[k] )
            {
                System.out.print( arr[k] + ", " );
            }
            temp = arr[k];
        }
    }

    public void logic( int[] arr )
    {
        int len = arr.length;
        int[] L = new int[len];

        Arrays.fill( L, 1 );

        for( int i = 1; i < len; i++ )
            for( int j = 0; j < i; j++ )
                if( arr[i] > arr[j] && L[i] < L[j] + 1 )
                    L[i] = L[j] + 1;

    }

}
