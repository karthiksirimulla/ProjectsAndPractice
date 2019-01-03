package com.matrix;

public class SearchInRowAndColumnSortedMatrix
{

    public static void main( String[] args )
    {
        int matrix[][] = { { 10, 20, 30, 40, 50 }, { 15, 25, 35, 45, 55 }, { 27, 29, 37, 48, 57 }, { 32, 33, 39, 50, 60 } };

        /*
         * { 10, 20, 30, 40, 50 }, 
           { 15, 25, 35, 45, 55 }, 
           { 27, 29, 37, 48, 57 }, 
           { 32, 33, 39, 50, 60 } 
         * 
         */

        int searK = 129;

        searchEle( matrix, searK );

    }

    private static void searchEle( int[][] matrix,
                                   int searK )
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0, j = cols - 1;

        while( i < rows && j >= 0 )
        {
            if( matrix[i][j] == searK )
            {
                System.out.println( "Found at :" + "( " + i + "," + j + " )" );
                return;
            }

            if( matrix[i][j] > searK )
                j--;
            else
                i++;
        }

        System.out.print( searK + " : Element not found" );
        return;

    }

}
