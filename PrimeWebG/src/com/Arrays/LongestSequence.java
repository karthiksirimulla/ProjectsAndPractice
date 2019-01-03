package com.Arrays;

/**
 * Problem Statement
 * 
 * Given a binary array, find the index of 0 such that when that 0 is replaced with 1 results in longest continuous sequence of 1's. 
 * For example, for array {0,1,1,1,0,1,0} replacing 0 at 0th index with 1 results in a sequence of 1's with length 4 and replacing 0 
 * at index 4 with 1 results in a sequence of 1's with length 5. Hence for this input array, output returned should be 4.
    
  For array {0,0,1,1,1,1,0,0,1,1,1,1,0,1,1,0,1,0,1,1,1,1,0} longest sequence of 1's is obtained when we replace 0 at index 12 with 1.
 * 
 * 
 * 
 * @author Sirimulla.Karthik
 *
 */
public class LongestSequence
{

    public static void main( String[] args )
    {
        int[] arr = { 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0 };
        //            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20,21,22
        //          {0,1,6,7,12,15,17,22}
        // 
        int[] resArr = { 0, 1, 6, 7, 12, 15, 17, 22 };
        returnIndex( resArr );
        int k = getIndex( arr );
        System.out.println( "Index : " + k );
    }

    private static void returnIndex( int[] arr )
    {
        int len = arr.length - 1;
        int resIndex = -1;
        int initDiff = arr[1] - arr[0];
        int maxDiff = initDiff;

        for( int i = 0; i < len - 1; i++ )
        {
            int diff = arr[i + 2] - arr[i];
            if( diff > maxDiff )
            {
                maxDiff = diff;
                resIndex = arr[i + 1];
            }
        }

        System.out.println( "resIndex : " + resIndex );

    }

    private static int getIndex( int[] arr )
    {
        int index = 0;
        int init = 0;
        int diff = 0;
        int maxDiff = 0;

        for( int i = 0; i < arr.length; i++ )
        {
            if( arr[i] == 0 )
            {
                diff = i - init;
                init = i;
            }

            if( diff > maxDiff )
            {
                maxDiff = diff;
                index = i;
            }

        }
        System.out.println( "MaxDiff : " + maxDiff );
        return index;
    }

}
