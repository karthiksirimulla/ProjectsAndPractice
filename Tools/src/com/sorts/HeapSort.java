package com.sorts;

import java.util.Arrays;

public class HeapSort
{
    public static void main( String[] args )
    {
        int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };//{ 1, 23, 50, 12, 9, 30, 2 };//{ 2, 4, 1, 6, 8, 5, 3, 7 };
        int n = arr.length - 1;
        heapSort( arr, n );

    }

    private static void heapSort( int[] arr,
                                  int last )
    {
        int lastIndex = last;
        while( lastIndex >= 0 )
        {
            // max-heaped
            minHeapify( arr, lastIndex );

            // swap
            int temp = arr[0];
            arr[0] = arr[lastIndex];
            arr[lastIndex] = temp;

            lastIndex--;

            System.out.println( "MaxHeaped : " + Arrays.toString( arr ) );
        }

        System.out.println( "Final Sorted : " + Arrays.toString( arr ) );
    }

    private static void maxHeapify( int[] arr,
                                    int lastIndex )
    {

        boolean flag = false;

        for( int i = 0; 2 * i + 2 <= lastIndex; i++ )
        {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if( arr[i] < arr[leftChild] )
            {
                int temp = arr[i];
                arr[i] = arr[leftChild];
                arr[leftChild] = temp;
                flag = true;

            }

            if( arr[i] < arr[rightChild] )
            {
                int temp = arr[i];
                arr[i] = arr[rightChild];
                arr[rightChild] = temp;
                flag = true;

            }
        }
        if( flag )
            maxHeapify( arr, lastIndex );

    }

    private static void minHeapify( int[] arr,
                                    int lastIndex )
    {

        boolean flag = false;

        for( int i = 0; 2 * i + 2 <= lastIndex; i++ )
        {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if( arr[i] > arr[leftChild] )
            {
                int temp = arr[i];
                arr[i] = arr[leftChild];
                arr[leftChild] = temp;
                flag = true;

            }

            if( arr[i] > arr[rightChild] )
            {
                int temp = arr[i];
                arr[i] = arr[rightChild];
                arr[rightChild] = temp;
                flag = true;
            }
        }
        if( flag )
            minHeapify( arr, lastIndex );

        System.out.println( "MinHeaped : " + Arrays.toString( arr ) );

    }

    //Geeks Code

    static void heapify( int arr[],
                         int n,
                         int i )
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if( l < n && arr[l] > arr[largest] )
            largest = l;

        // If right child is larger than largest so far
        if( r < n && arr[r] > arr[largest] )
            largest = r;

        // If largest is not root
        if( largest != i )
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify( arr, n, largest );
        }
        System.out.println( "Geeks Heapified : " + Arrays.toString( arr ) );

    }

}
