package com.arr;

public class SaddlePoint
{
    public static void main( String[] args )
    {

        int[][] arr = new int[][] { { 21, 31, 56 }, { 75, 44, 67 }, { 83, 72, 99 } };
        /*
         *  [21,31,56]
            [75,44,67]
            [83,72,99]
         */

        for( int i = 0; i < arr.length; i++ )
        {
            int[] row = arr[i];
            int colIndex = 0;
            int min = row[0];

            for( int k = 0; k < row.length; k++ )
            {
                if( min > row[k] )
                {
                    min = row[k];
                    colIndex = k;
                }
            }

            boolean isSaddlePoint = true;

            for( int j = 0; j < arr[i].length; j++ )
            {
                if( row[colIndex] < arr[j][colIndex] )
                    isSaddlePoint = false;

            }

            if( isSaddlePoint )
            {
                System.out.println( row[colIndex] );
                break;
            }

        }

    }

}
