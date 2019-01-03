package com.Prac.DP;

public class MaxPossibleRobbery
{
    public static void main( String[] args )
    {
        int[] arr = { 6, 7, 1, 3, 8, 2, 4 };
        int n = arr.length;

        int maxSteal = countMaxSteal( arr, n );
        System.out.println( "max Steal : " + maxSteal );
    }

    private static int countMaxSteal( int[] arr,
                                      int n )
    {
        if( n == 0 )
            return 0;
        if( n == 1 )
            return arr[0];
        if( n == 2 )
            return Math.max( arr[0], arr[1] );

        int[] stolen = new int[n];

        stolen[0] = arr[0];
        stolen[1] = Math.max( arr[0], arr[1] );

        for( int i = 2; i < n; i++ )
            stolen[i] = Math.max( arr[i] + stolen[i - 2], stolen[i - 1] );

        return stolen[n - 1];
    }

}
