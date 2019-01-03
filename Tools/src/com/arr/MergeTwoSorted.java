package com.arr;

import java.util.Arrays;

public class MergeTwoSorted
{

    public static void main( String[] args )
    {
        int[] arr2 = { 1, 3, 5, 7, 9 };//{ 2, 7, 13, 25, 58 };
        int[] arr1 = { 0, 2, 4, 6, 8 };//{ 5, 9, 17, 29, 36, 49, 53 };

        merge( arr1, arr2 );

    }

    private static void merge( int[] arr1,
                               int[] arr2 )
    {
        int len1 = arr1.length;
        int len2 = arr2.length;

        int[] arr = new int[len1 + len2];

        int i = 0, j = 0, k = 0;

        while( i < len1 && j < len2 )
        {

            if( arr1[i] < arr2[j] )
            {
                arr[k] = arr1[i];
                i++;
            }
            else
            {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while( i < len1 )
        {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while( j < len2 )
        {
            arr[k] = arr2[j];
            j++;
            k++;
        }

        System.out.println( Arrays.toString( arr ) );

    }

}
