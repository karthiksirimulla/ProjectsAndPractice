package com.Prac;

/**
 * Given a sorted array and a number x, find a pair in array whose sum is closest to x.
   Examples: 
    Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
    Output: 22 and 30
    
    Input: arr[] = {1, 3, 4, 7, 10}, x = 15
    Output: 4 and 10
 * 
 *
 */
public class FindClosest
{
    public static void main( String[] args )
    {
        int[] sArr = { 1, 3, 4, 7, 10 };//{ 10, 22, 28, 29, 30, 40 };
        int x = 15;//54;
        twoPointersClosestToX( sArr, x );

    }

    static void twoPointersClosestToX( int[] arr,
                                       int x )
    {
        int low = 0;
        int high = arr.length - 1;
        int diff = Integer.MAX_VALUE;
        int iIndex = -1;
        int jIndex = -1;

        while( low < high )
        {
            if( arr[low] + arr[high] == x )
            {
                System.out.println( arr[low] + "," + arr[high] );
                break;
            }
            else
            {
                int sum = arr[low] + arr[high];
                if( Math.abs( sum - x ) < diff )
                {
                    diff = Math.abs( sum - x );
                    iIndex = low;
                    jIndex = high;
                }

                if( x > sum )
                    low++;
                else
                    high--;
            }

        }

        System.out.println( "Pair is " + arr[iIndex] + ", " + arr[jIndex] );

    }

}
