package com.misc;

/*
 * Link : https://www.geeksforgeeks.org/maximum-number-chocolates-distributed-equally-among-k-students/
 * 
 */
public class MaxChocs
{
    public static void main( String[] args )
    {
        int[] arr = { 2, 7, 6, 1, 4, 5 };
        int children = 5;
        maxChocs( arr, children );
    }

    private static void maxChocs( int[] arr,
                                  int children )
    {
        int l = 0;
        int r = arr.length - 1;
        int sum = 0;
        while( l <= r )
        {
            sum = sum + arr[l];
            l++;
        }
        l = 0;
        while( l <= r )
        {
            if( sum % children == 0 )
                break;

            int min = Integer.min( arr[l], arr[r] );
            int max = Integer.max( arr[l], arr[r] );

            if( ( sum - min ) % children == 0 )
            {
                l++;
                break;
            }
            if( ( sum - max ) % children == 0 )
            {
                r--;
                break;
            }
            if( ( sum - ( min + max ) ) % children == 0 )
            {
                l++;
                r--;
                break;
            }

        }

        while( l <= r )
        {
            System.out.print( arr[l] + ", " );
            l++;
        }
    }

}
