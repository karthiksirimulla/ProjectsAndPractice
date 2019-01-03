package com.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heapify
{
    public static void main( String[] args )
    {
        int[] arr = { 4, 2, 15, 6, 17, 11, 8 };

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for( int i = 0; i < arr.length; i++ )
        {
            pQ.add( arr[i] );
        }

        //  System.out.println( pQ );

        //  minHeapify( arr );

        int[] minArr = { 2, 4, 8, 6, 17, 15, 21, 32, 3 }; //{ 8, 17, 15, 2, 6, 4, 11 };
        maxHeapify( minArr );
    }

    /**
     * Logic : Parent should be greater than its children
     * @param arr
     */
    private static void maxHeapify( int[] arr )
    {
        int len = arr.length;
        int largest = arr[0];
        for( int i = 0; 2 * i + 2 < len; i++ )
        {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int parent = i;

            if( arr[parent] < arr[rightChild] )
            {
                int temp = arr[parent];
                arr[parent] = arr[rightChild];
                arr[rightChild] = temp;
            }

            if( arr[parent] < arr[leftChild] )
            {
                int temp = arr[parent];
                arr[parent] = arr[leftChild];
                arr[leftChild] = temp;
            }

            if( arr[parent] > largest )
                largest = arr[parent];
        }

        if( largest != arr[0] )
            maxHeapify( arr );
        System.out.println( "Largest :" + largest );

        System.out.println( "Max Heap : " + Arrays.toString( arr ) );

    }

    /**
     * Logic : Parent should be less than its children
     * @param arr
     */
    private static void minHeapify( int[] arr )
    {
        int len = arr.length;
        for( int i = 0; 2 * i + 2 < len; i++ )
        {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int parent = i;

            if( arr[parent] > arr[leftChild] )
            {
                int temp = arr[parent];
                arr[parent] = arr[leftChild];
                arr[leftChild] = temp;
            }

            if( arr[parent] > arr[rightChild] )
            {
                int temp = arr[parent];
                arr[parent] = arr[rightChild];
                arr[rightChild] = temp;
            }

        }

        System.out.println( "Min Heap : " + Arrays.toString( arr ) );

    }

}
