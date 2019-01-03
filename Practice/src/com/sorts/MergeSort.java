package com.sorts;

import java.util.Arrays;

public class MergeSort
{
    public static void main( String[] args )
    {
        int[] arr = { 2, 4, 1, 6, 8, 5, 3, 7 };
        System.out.println( "Initial array :" + Arrays.toString( arr ) );
        mergeSort( arr );
        System.out.println( Arrays.toString( arr ) );

    }

    private static void mergeSort( int[] arr )
    {
        int len = arr.length;
        if( len < 2 )
        {
            return;
        }

        int mid = len / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[len - mid];

        for( int i = 0; i < mid; i++ )
        {
            leftArr[i] = arr[i];
        }

        for( int i = mid; i < len; i++ )
        {
            rightArr[i - mid] = arr[i];
        }
        mergeSort( leftArr );
        mergeSort( rightArr );
        merge( leftArr, rightArr, arr );

    }

    private static void merge( int[] leftArr,
                               int[] rightArr,
                               int[] arr )
    {
        int left = 0;
        int right = 0;
        int i = 0;

        int leftLen = leftArr.length;
        int rightLen = rightArr.length;

        while( left < leftLen && right < rightLen )
        {
            if( leftArr[left] <= rightArr[right] )
            {
                arr[i] = leftArr[left];
                left++;
            }
            else
            {
                arr[i] = rightArr[right];
                right++;
            }
            i++;
        }

        while( left < leftLen )
        {
            arr[i] = leftArr[left];
            i++;
            left++;
        }

        while( right < rightLen )
        {
            arr[i] = rightArr[right];
            i++;
            right++;
        }

    }

}
