package com.arr;

import java.util.Arrays;

public class PairSumArray
{

    public static void main( String[] args )
    {

        int[] pairSumArr = { 14, 9, 10, 11, 12, 7 };
        int[] pairSumArr1 = { 15, 13, 11, 10, 12, 10, 9, 8, 7, 5 };

        int[] arr = { 6, 8, 3, 4 };

        int[] geeks = { 8, 7, 5, 3, 2 };

        createPairSumArray( geeks );
        getArrayfromPairSum( pairSumArr1 );
        //System.out.println( factorialSum( 10 ) );
    }

    private static void createPairSumArray( int[] arr )
    {
        int len = arr.length;
        int[] res = new int[factorialSum( len - 1 )];

        for( int i = 0, k = 0; i < len; i++ )
        {
            for( int j = i + 1; j < len; j++ )
            {
                res[k] = arr[i] + arr[j];
                k++;
            }
        }
        System.out.println( "Pair Sum Array :" + Arrays.toString( res ) );

    }

    private static void getArrayfromPairSum( int[] arr )
    {
        int len = arr.length;
        int size = factMinus( len, 1 ) + 1;
        int[] res = new int[size];

        res[size - 3] = ( arr[len - 3] + arr[len - 2] - arr[len - 1] ) / 2;
        res[size - 2] = arr[len - 3] - res[size - 3];
        res[size - 1] = arr[len - 2] - res[size - 3];

        int t = 3;

        for( int i = len - 4, k = size - 1; i > 0 && k - t >= 0; i = i - t, k--, t++ )
        {
            res[k - t] = arr[i] - res[k];

        }

        System.out.println( Arrays.toString( res ) );

    }

    private static int factorial( int n )
    {
        if( n == 1 )
            return n;
        return n * factorial( --n );
    }

    private static int factorialSum( int n )
    {
        if( n == 1 )
            return n;
        return n + factorialSum( --n );
    }

    private static int factMinus( int n,
                                  int i )
    {
        if( n <= 0 )
            return 0;
        i++;
        return 1 + factMinus( n - i, i );
    }
}
