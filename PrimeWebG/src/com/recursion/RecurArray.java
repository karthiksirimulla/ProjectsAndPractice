package com.recursion;

public class RecurArray
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 2, 3, 4, 5 };

        System.out.println( "Sum:" + sumArray( arr, arr.length - 1 ) );
        printArray( arr, arr.length - 1 );
    }

    private static int sumArray( int[] arr,
                                 int N )
    {
        if( N < 0 )
            return 0;

        return ( arr[N] + sumArray( arr, N - 1 ) );

    }

    private static void printArray( int[] arr,
                                    int N )
    {
        if( N < 0 )
            return;
        else
        {
            printArray( arr, N - 1 );
            System.out.print( arr[N] + " " );
        }

    }

}
