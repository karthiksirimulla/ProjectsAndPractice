package com.Arrays;

public class HeapSorting
{
    public static void main( String[] args )
    {
        int[] arr = { 2, 4, 1, 6, 8, 5, 3, 7 };
        int n = arr.length - 1;
        maxHeapify( arr );
        minHeapify( arr );
    }

    private static void minHeapify( int[] arr )
    {
        int i = 0;
        int root = arr[i];
        int leftEle = arr[2 * i + 1];
        int rightEle = arr[2 * i + 2];

    }

    private static void maxHeapify( int[] arr )
    {
        // TODO Auto-generated method stub

    }

}
