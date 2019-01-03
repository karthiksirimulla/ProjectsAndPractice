package com.Prac;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSortPrac
{
    public static void main( String[] args )
    {
        int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
        minHeapify( arr, arr.length - 1 );
        System.out.println( "Min heaped : " + Arrays.toString( arr ) );

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for( Integer i : arr )
            pQ.add( i );
        System.out.println( "pQ check: " + pQ );

        int[] arr1 = { 7, 2, 1, 6, 8, 5, 3, 4 };
        maxHeapify( arr1, arr1.length - 1 );
        System.out.println( "Max heaped : " + Arrays.toString( arr1 ) );

        int[] minArr = { 7, 2, 1, 6, 8, 5, 3, 4 };
        heapSort( minArr );

    }

    private static void heapSort( int[] arr )
    {
        int lastIndex = arr.length - 1;

        while( lastIndex >= 0 )
        {
            minHeapify( arr, lastIndex );

            // swap
            int temp = arr[0];
            arr[0] = arr[lastIndex];
            arr[lastIndex] = temp;

            lastIndex--;

        }

        System.out.println( "Heap Sorted using minHeap : " + Arrays.toString( arr ) );

    }

    /*
     * Root is less than both the children
     */
    private static void minHeapify( int[] arr,
                                    int lastIndex )
    {
        boolean flag = false;
        for( int i = 0; 2 * i + 2 <= lastIndex; i++ )
        {
            int leftAddr = 2 * i + 1;
            int rightAddr = 2 * i + 2;

            int root = arr[i];
            int leftChild = arr[leftAddr];

            if( root > leftChild )
            {
                int temp = arr[i];
                arr[i] = leftChild;
                arr[leftAddr] = temp;
                flag = true;
            }
            if( rightAddr <= lastIndex )
            {
                int rightChild = arr[rightAddr];
                if( root > rightChild )
                {
                    int temp = arr[i];
                    arr[i] = rightChild;
                    arr[rightAddr] = temp;
                    flag = true;
                }
            }
        }

        if( flag )
            minHeapify( arr, lastIndex );

    }

    /*
     * Root is greater than both the children
     */
    private static void maxHeapify( int[] arr,
                                    int lastIndex )
    {

        boolean flag = false;
        for( int i = 0; ( 2 * i ) + 1 <= lastIndex; i++ )
        {
            int leftAddr = 2 * i + 1;
            int rightAddr = 2 * i + 2;

            int root = arr[i];
            int leftChild = arr[leftAddr];

            if( root < leftChild )
            {
                int temp = arr[i];
                arr[i] = leftChild;
                arr[leftAddr] = temp;
                flag = true;
            }
            if( rightAddr < arr.length )
            {
                int rightChild = arr[rightAddr];
                if( root < rightChild )
                {
                    int temp = arr[i];
                    arr[i] = rightChild;
                    arr[rightAddr] = temp;
                    flag = true;
                }
            }
        }

        if( flag )
            maxHeapify( arr, lastIndex );

    }

}
