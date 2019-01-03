package com.DP;

import java.util.Arrays;

/*
 * 
 * 
 * Longest Decreasing Subsequence
    Given an array of N integers, find the length of the longest subsequence of a given sequence 
    such that all elements of the subsequence are sorted in strictly decreasing order.
    
    Examples :
    
    Input: arr[] = [15, 27, 14, 38, 63, 55, 46, 65, 85]
    Output: 3
    Explanation: The longest decreasing sub sequence is {63, 55, 46}
    
    Input: arr[] = {50, 3, 10, 7, 40, 80}
    Output: 3
    Explanation: The longest decreasing subsequence is {50, 10, 7}
 */
public class LDS
{
    public static void main( String[] args )
    {
        int[] arr = { 5, 4, 100, 3, 2, 101, 1 };
        int n = arr.length;

        int res = getLDS( arr, n );
        System.out.println( res );

    }

    private static int getLDS( int[] arr,
                               int n )
    {
        int[] lds = new int[n];
        Arrays.fill( lds, 1 );
        int res = 0;

        for( int i = 1; i < n; i++ )
        {
            for( int j = 0; j < i; j++ )
            {
                if( arr[i] < arr[j] && lds[i] < lds[j] + 1 )
                {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        System.out.println( Arrays.toString( lds ) );
        Arrays.sort( lds );
        res = lds[n - 1];
        return res;
    }

}
