package com.Arrays;

public class FormBiggestNumber
{
    public static void main( String[] args )
    {
        int[] arr = { 54, 546, 548, 60 };
        // int res = formBigNumber( arr );
        int a = 60;
        int b = 548;
        // 59 , 548
        // 54 , 548
        // 60 , 548
        // 45,  548 
        int re = compareByPlace( 59, 548 );
        System.out.println( "Result :> " + re );

    }

    private static int formBigNumber( int[] arr )
    {
        int len = arr.length;
        int mid = len / 2;

        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for( int i = 0; i < mid; i++ )
            left[i] = arr[i];

        for( int i = mid; i < len; i++ )
            right[i - mid] = arr[i];

        formBigNumber( left );
        formBigNumber( right );

        merge( left, right, arr );
        return 0;
    }

    private static void merge( int[] left,
                               int[] right,
                               int[] arr )
    {
        int a, b;
        //compareByPlace( a, b );

    }

    private static int compareByPlace( int a,
                                       int b )
    {
        if( a == b )
        {
            return 0;
        }

        if( String.valueOf( a ).length() == String.valueOf( b ).length() )
        {
            if( a > b )
                return 1;
            else
                return -1;
        }

        // 59 , 548
        // 54 , 548
        // 60 , 548
        // 45,  548 

        int aLen = String.valueOf( a ).length();
        int bLen = String.valueOf( b ).length();

        int aM = (int) ( a / Math.pow( 10, ( aLen - 1 ) ) );
        int bM = (int) ( b / Math.pow( 10, ( bLen - 1 ) ) );

        if( aM > bM )
            return 1;
        else if( bM > aM )
            return -1;

        return compareByPlace( a % (int) ( Math.pow( 10, ( aLen - 1 ) ) ), b % (int) ( Math.pow( 10, ( bLen - 1 ) ) ) );

    }

}
