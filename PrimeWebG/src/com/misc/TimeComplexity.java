package com.misc;

import java.util.Arrays;

public class TimeComplexity
{
    public static void main( String[] args )
    {
        int[] arr = new int[100000000];
        Arrays.fill( arr, 1 );
        long a = System.currentTimeMillis();
        System.out.println( a );
        // singlePointerLoop( arr );
        doublePointerLoop( arr );
        long b = System.currentTimeMillis();
        System.out.println( b );
        System.out.println( "Time taken :" + (long) ( b - a ) );
    }

    private static void singlePointerLoop( int[] arr )
    {
        int k = 0;
        for( int i = 0; i < arr.length; i++ )
        {
            int temp = arr[i];
            k = i;
        }
        System.out.println( "single loop : " + k );

    }

    private static void doublePointerLoop( int[] arr )
    {
        int k = 0;
        for( int i = 0, j = arr.length - 1; i <= j; i++, j-- )
        {
            int temp = arr[i];
            k = i;
        }
        System.out.println( "Double loop : " + k );

    }

}
