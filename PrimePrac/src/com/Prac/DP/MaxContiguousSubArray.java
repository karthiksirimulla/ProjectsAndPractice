package com.Prac.DP;

public class MaxContiguousSubArray
{
    public static void main( String[] args )
    {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

        int maxSum = getMaxSubArraySum( arr );

        System.out.println( "max sum :" + maxSum );

    }

    private static int getMaxSubArraySum( int[] arr )
    {
        int max_until_here = 0;
        int max_so_far = 0;

        for( int i = 0; i < arr.length; i++ )
        {
            max_until_here = max_until_here + arr[i];

            if( max_until_here < 0 )
                max_until_here = 0;

            if( max_until_here > max_so_far )
                max_so_far = max_until_here;

        }
        return max_so_far;
    }

}
