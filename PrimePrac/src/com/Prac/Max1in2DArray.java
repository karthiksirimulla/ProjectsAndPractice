package com.Prac;

/**
 * Given a boolean 2D array, where each row is sorted. 
 * Find the row with the maximum number of 1s.
 *
 */

public class Max1in2DArray
{
    public static void main( String[] args )
    {
        int[][] arr = { { 0, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1 } };

        int rows = arr.length;

        int index = findIndex( arr[0] );
        int rowIndex = 0;

        for( int i = 1; i < rows; i++ )
        {
            if( arr[i][index] == 0 )
                continue;
            int tempIndex = findIndex( arr[i] );
            if( tempIndex < index )
            {
                index = tempIndex;
                rowIndex = i;

            }

        }

        System.out.println( "rowIndex : " + rowIndex );
        System.out.println( "Index : " + index );

    }

    private static int findIndex( int[] arr )
    {
        int low = 0;
        int high = arr.length - 1;
        int resIndex = -1;
        if( arr[0] == 1 )
            return 0;

        while( low < high )
        {
            int mid = ( low + high ) / 2;
            if( arr[mid] == 1 )
            {
                if( arr[mid - 1] == 0 )
                {
                    resIndex = mid;
                    break;
                }
                else
                    high = mid - 1;

            }
            else
            {
                if( arr[mid + 1] == 1 )
                {
                    resIndex = mid + 1;
                    break;
                }
                low = mid + 1;
            }

        }

        return resIndex;

    }

}
