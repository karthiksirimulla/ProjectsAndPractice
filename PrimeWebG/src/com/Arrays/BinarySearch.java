package com.Arrays;

public class BinarySearch
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int k = 2;
        search( arr, k );
    }

    private static void search( int[] arr,
                                int k )
    {
        int low = 0;
        int high = arr.length - 1;
        while( low <= high )
        {
            int mid = ( low + high ) / 2;

            if( arr[mid] == k )
            {
                System.out.println( "Found at pos : " + mid );
                break;
            }

            if( arr[mid] > k )
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }

        }

        System.out.println( "Not Found " );

    }

}
