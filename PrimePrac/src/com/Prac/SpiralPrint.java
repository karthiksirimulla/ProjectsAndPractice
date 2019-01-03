package com.Prac;

import java.util.Arrays;

/**
 * [1,  2,  3,  4,  5]
 * [6,  7,  8,  9,  10]
 * [11, 12, 13, 14, 15]
 * [16, 17, 18, 19, 20]
 * [21, 22, 23, 24, 25]
 * [26, 27, 28, 29, 30]
 * 
 * 
 * 
 *
 */
public class SpiralPrint
{
    public static void main( String[] args )
    {
        int rows = 6;
        int cols = 5;

        int[][] arr = new int[rows][cols];
        buildArr( arr );
        System.out.println( Arrays.deepToString( arr ) );

        for( int i = 0; i < rows; i++ )
        {
            System.out.print( arr[i][4] + ", " );
        }

    }

    private static void buildArr( int[][] arr )
    {
        int rows = arr.length;
        int cols = arr[0].length;
        int k = 1;

        for( int i = 0; i < rows; i++ )
        {
            for( int j = 0; j < cols; j++ )
            {
                arr[i][j] = k;
                k++;

            }
        }

    }

}
