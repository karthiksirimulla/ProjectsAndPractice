package com.arr;

import java.util.Arrays;

public class FindIfSumExists
{

    public static void main( String[] args )
    {

        int[] arr = { 1, 2, 7, 5 };
        int sum = 11;
        int len = arr.length;

        boolean res = findSum( arr, sum, len );

    }

    private static boolean findSum( int[] arr,
                                    int sum,
                                    int len )
    {
        int rows = len + 1;
        int cols = sum + 1;
        boolean matrix[][] = new boolean[rows][cols];

        for( int i = 0; i < rows; i++ )
            matrix[i][0] = true;

        for( int i = 1; i < cols; i++ )
            matrix[0][i] = false;

        for( int i = 1; i < rows; i++ )
        {
            for( int j = 1; j < cols; j++ )
            {
                //copy data from top
                matrix[i][j] = matrix[i - 1][j];

                if( matrix[i][j] == false && j >= arr[i - 1] )
                    matrix[i][j] = matrix[i][j] || matrix[i - 1][j - arr[i - 1]];

            }
        }

        print2DArray( matrix );
        return matrix[rows - 1][cols - 1];

    }

    private static void print2DArray( boolean[][] arr )
    {
        for( boolean[] row : arr )
            System.out.println( Arrays.toString( row ) );
    }

}
