package com.digits;

import java.util.Arrays;

public class MaxNoSwaps
{
    public static void main( String[] args )
    {

        int digit = 432759128;
        int[] arr = { 4, 3, 9, 7, 5, 9, 1, 8 };
        int[] arr1 = { 1, 9, 9, 9 };
        int swaps = 5;

        max( arr, 0, swaps );

    }

    public static int[] max( int[] arr,
                             int initIndex,
                             int swaps )
    {
        int len = arr.length;
        int moves = swaps;

        int lastIndex = initIndex + moves;

        if( swaps > len || lastIndex > len - 1 )
        {
            lastIndex = len - 1;
        }

        int maxIndex = initIndex;

        if( moves <= 0 || initIndex == len - 1 )
        {
            System.out.println( "Init Array : " + Arrays.toString( arr ) );
            return arr;
        }

        for( int i = initIndex; i <= lastIndex; i++ )
        {
            if( arr[i] >= arr[maxIndex] )
                maxIndex = i;
            if( arr[i] == 9 )
                break;
        }

        //        System.out.println( "Max Index : " + maxIndex );
        //      System.out.println( "Init Array : " + Arrays.toString( arr ) );

        if( initIndex != maxIndex )
        {

            int temp = arr[maxIndex];

            // Array Movement
            for( int i = maxIndex; i > initIndex; i-- )
            {
                arr[i] = arr[i - 1];
            }

            arr[initIndex] = temp;

            moves = moves - ( maxIndex - initIndex );
        }
        return max( arr, ++initIndex, moves );

    }

    private static void findMaxIndex( int[] arr,
                                      int swaps )
    {
        int len = arr.length;
        int maxIndex = 0;

        int swapIndex = 0;
        int moves = swaps;

        if( moves <= 0 )
            return;

        for( int i = 0; i < len; i++ )
        {
            if( arr[i] > arr[maxIndex] )
                maxIndex = i;
        }

        System.out.println( "Max Index : " + maxIndex );
        System.out.println( "Init Array : " + arr );

        arr[0] = arr[maxIndex];

        // Array Movement
        for( int i = 0; i < maxIndex; i++ )
        {
            arr[i + 1] = arr[i];
        }

        System.out.println( "After Array : " + arr );

    }

    private static void findMax( int[] arr,
                                 int noOfSwaps )
    {

        int len = arr.length;
        int i = 0;

        arr = getMax( arr, i, noOfSwaps );

    }

    private static int[] getMax( int[] arr,
                                 int i,
                                 int noOfSwaps )
    {
        int max = i;
        int swapsRemaining = noOfSwaps;
        // find max index
        for( int j = i; j <= arr.length - 1; j++ )
        {
            if( arr[j] > arr[max] )
            {
                max = j;
                break;
            }
        }

        // Shifting / Swapping
        int maxNumber = arr[max];
        for( int k = max; k > i; k-- )
        {
            arr[k] = arr[k - 1];
        }

        arr[i] = maxNumber;
        i++;
        swapsRemaining = noOfSwaps - ( max );
        if( swapsRemaining > 0 )
            getMax( arr, i, swapsRemaining );

        System.out.println( Arrays.toString( arr ) );
        return arr;
    }

}
