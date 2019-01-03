package com.Prac;

/*
 * Find duplicates in O(n) time and O(1) extra space
 */
public class DupsInArray
{
    public static void main( String[] args )
    {
        int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
        printRepeating( arr );
    }

    private static void printRepeating( int[] arr )
    {
        for( int i = 0; i < arr.length; i++ )
        {
            if( arr[Math.abs( arr[i] )] >= 0 )
                arr[Math.abs( arr[i] )] = -arr[Math.abs( arr[i] )];
            else
                System.out.print( Math.abs( arr[i] ) + " " );

        }

    }

}
