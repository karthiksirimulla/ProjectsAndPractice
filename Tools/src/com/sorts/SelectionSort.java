package com.sorts;

import java.util.Arrays;

public class SelectionSort
{

    public static void main( String[] args )
    {

        int[] arr = { 2, 7, 4, 1, 8, 3 };//{ 4, 1, 1, 1 };
        int[] corr = { 4, 14, 8, 2, 16, 6 };//{ 2, 4, 29, 3 };

        selsort( arr, corr );
    }

    private static void selsort( int[] arr,
                                 int[] corr )
    {
        int n = arr.length;
        for( int i = 0; i < n - 1; i++ )
        {
            int iMin = i;
            for( int j = i + 1; j < n; j++ )
            {
                if( arr[j] < arr[iMin] )
                {
                    iMin = j;
                }
                if( arr[j] == arr[iMin] )
                {
                    if( corr[j] > corr[iMin] )
                        iMin = j;
                }
            }
            System.out.println( "iMin --> : " + iMin );
            int temp = arr[i];
            arr[i] = arr[iMin];
            arr[iMin] = temp;

            int tmp = corr[i];
            corr[i] = corr[iMin];
            corr[iMin] = tmp;

        }
        System.out.println( "Sorted : " + Arrays.toString( arr ) );
        System.out.println( "Sorted Corr: " + Arrays.toString( corr ) );
    }

}
