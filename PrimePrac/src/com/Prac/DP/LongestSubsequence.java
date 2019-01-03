package com.Prac.DP;

import java.util.Arrays;

public class LongestSubsequence
{

    public static void main( String[] args )
    {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };//{ 10, 9, 2, 5, 3, 7, 101, 18 };
        int res = longestIncreasingSubseq( arr );
        System.out.println( "longestIncreasingSubseq : " + res );
        res = longestIncThenDecSubSeq();
    }

    /**
     * For example, given [10, 9, 2, 5, 3, 7, 101, 18], 
       the longest increasing subsequence is [2, 3, 7, 101]. 
       Therefore the length is 4.
     * @return
     */
    private static int longestIncreasingSubseq( int[] arr )
    {
        int[] lis = new int[arr.length];
        Arrays.fill( lis, 1 );

        for( int i = 1; i < arr.length; i++ )
        {
            for( int j = 0; j < i; j++ )
            {
                if( arr[i] > arr[j] && lis[i] < lis[j] + 1 )
                {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for( int i = 0; i < lis.length; i++ )
            if( lis[i] > max )
                max = lis[i];

        return max;
    }

    private static int longestIncThenDecSubSeq()
    {
        return 0;
    }

}
