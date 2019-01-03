package com.DP;

import java.util.Arrays;

/*  
 * 
 * 
 * Maximum Sum Decreasing Subsequence
   Given an array of N positive integers. The task is to find the sum of maximum sum decreasing subsequence(MSDS) of the given array 
   such that the integers in the subsequence are sorted in decreasing order.
   
   Examples:
    Input: arr[] = {5, 4, 100, 3, 2, 101, 1}
    Output: 106
    100 + 3 + 2 + 1 = 106
    
    Input: arr[] = {10, 5, 4, 3}
    Output: 22
    10 + 5 + 4 + 3 = 22
 *
 */
public class MSDS
{
    public static void main( String[] args )
    {
        int[] arr = { 5, 4, 100, 3, 2, 101, 1 };
        int n = arr.length;

        int res = getMaxSum( arr, n );
        System.out.println( res );
    }

    private static int getMaxSum( int[] arr,
                                  int n )
    {
        int[] mds = new int[n];
        mds[0] = arr[0];
        int res = 0;
        int maxTillNow = 0;

        for( int i = 1; i < n; i++ )
        {
            for( int j = 0; j < i; j++ )
            {
                if( arr[i] < arr[j] )// Decreasing
                {
                    mds[i] = mds[j] + arr[i];
                    if( maxTillNow < mds[j] + arr[i] )
                        maxTillNow = mds[j] + arr[i];

                }
                else
                {
                    if( maxTillNow < arr[i] ) // Increasing
                        maxTillNow = arr[i];
                    mds[i] = maxTillNow;
                }

            }
        }

        System.out.println( Arrays.toString( mds ) );
        Arrays.sort( mds );
        res = mds[n - 1];
        return res;
    }

}
