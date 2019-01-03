package com.matrix;

public class SpiralPrint
{
    public static void main( String[] args )
    {
        //  int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[][] mm = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
        /*
         *  1    2   3   4
            5    6   7   8
            9   10  11  12
            13  14  15  16
         * 
         */

        // printSpiral( matrix );
        System.out.println();
        printSpiral( mm );
    }

    private static void printSpiral( int[][] matrix )
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowStart = 0;
        int rowsEnd = rows - 1;
        int colsStart = 0;
        int colsEnd = cols - 1;
        int counter = 0;
        int val = rows * cols;

        while( rowStart <= rowsEnd && colsStart <= colsEnd )
        {
            // print 1st row
            for( int i = colsStart; i <= colsEnd; i++ )
            {
                System.out.print( matrix[rowStart][i] + " " );
                counter++;
            }

            if( counter >= val )
                break;

            rowStart++;
            // System.out.println();

            // print last col
            for( int j = rowStart; j <= rowsEnd; j++ )
            {
                System.out.print( matrix[j][colsEnd] + " " );
                counter++;
            }
            colsEnd--;

            if( counter >= val )
                break;

            // System.out.println();

            for( int k = colsEnd; k >= colsStart; k-- )
            {
                System.out.print( matrix[rowsEnd][k] + " " );
                counter++;

            }
            rowsEnd--;
            if( counter >= val )
                break;

            // System.out.println();

            for( int t = rowsEnd; t >= rowStart; t-- )
            {
                System.out.print( matrix[t][colsStart] + " " );
                counter++;
            }

            colsStart++;

            if( counter >= val )
                break;

        }

    }

}
