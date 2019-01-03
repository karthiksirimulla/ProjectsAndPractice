package com.Rough;

import java.util.Arrays;

public class HeapSortUsingObj
{
    public static void main( String[] args )
    {
        int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };

        heapSort( arr );

    }

    private static void heapSort( int[] arr )
    {
        int high = arr.length - 1;

        while( high >= 0 )
        {
            minHeapify( arr, high ); // root is less than left and right children
            int temp = arr[0];
            arr[0] = arr[high];
            arr[high] = temp;
            high--;
            System.out.println( Arrays.toString( arr ) );
        }
        System.out.println( "----------" );
        //  maxHeapify( arr, 0, arr.length - 1 ); // root is greater than left and right children
        // System.out.println( Arrays.toString( arr ) );

    }

    private static void minHeapify( int[] arr,
                                    int iEnd )
    {
        boolean flag = false;
        for( int i = 0; 2 * i + 2 <= iEnd; i++ )
        {
            int leftpos = 2 * i + 1;
            int rightpos = 2 * i + 2;

            if( arr[i] < arr[leftpos] && arr[i] < arr[rightpos] )
            {
                continue;
            }
            if( arr[i] > arr[leftpos] )
            {
                int temp = arr[i];
                arr[i] = arr[leftpos];
                arr[leftpos] = temp;
                flag = true;
            }

            if( arr[i] > arr[rightpos] )
            {
                int temp = arr[i];
                arr[i] = arr[rightpos];
                arr[rightpos] = temp;
                flag = true;
            }

        }

        if( flag )
            minHeapify( arr, iEnd );

    }

    private static void maxHeapify( int[] arr,
                                    int iEnd )
    {
        boolean flag = false;
        for( int i = 0; 2 * i + 2 <= iEnd; i++ )
        {
            int leftpos = 2 * i + 1;
            int rightpos = 2 * i + 2;

            if( arr[i] > arr[leftpos] && arr[i] > arr[rightpos] )
            {
                continue;
            }
            if( arr[i] < arr[leftpos] )
            {
                int temp = arr[i];
                arr[i] = arr[leftpos];
                arr[leftpos] = temp;
                flag = true;

            }

            if( arr[i] < arr[rightpos] )
            {
                int temp = arr[i];
                arr[i] = arr[rightpos];
                arr[rightpos] = temp;
                flag = true;

            }

        }

        if( flag )
            maxHeapify( arr, iEnd );

    }

}
