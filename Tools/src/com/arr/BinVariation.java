package com.arr;

public class BinVariation
{

    public static void main( String[] args )
    {
        int[] arr = { 1, 1, 3, 3, 5, 5, 5, 5, 5, 9, 9, 11 };
        int x = 12;
        int low = binVar( arr, x, true );
        int high = binVar( arr, x, false );

        System.out.println( low );
        System.out.println( high );

    }

    private static int binVar( int[] arr,
                               int x,
                               boolean firstOccr )
    {
        int start = 0, end = arr.length - 1;
        int result = -1;
        while( start <= end )
        {
            int mid = ( start + end ) / 2;
            if( x == arr[mid] )
            {
                result = mid;
                if( firstOccr )
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else if( x < arr[mid] )
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return result;
    }

}
