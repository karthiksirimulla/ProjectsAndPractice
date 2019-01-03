package com.arrays;

public class CheckSum
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 4, 0, 0, 3, 10, 5 };
        int findSum = 7;

        checkIfSum( arr, findSum );

    }

    private static void checkIfSum( int[] arr,
                                    int findSum )
    {
        int i = 0, j = 1, len = arr.length;
        int tempSum = arr[i] + arr[j];
        while( j < len - 1 )
        {
            if( tempSum == findSum )
            {
                System.out.println( "YES" );
                return;
            }
            else if( tempSum < findSum )
            {
                j++;
                tempSum = tempSum + arr[j];
            }
            else
            {
                tempSum = tempSum - arr[i];
                i++;

            }
        }

        System.out.println( "NO" );

    }

}
