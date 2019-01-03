package com.Prac;

public class TwoDArray
{
    public static void main( String[] args )
    {
        int[][] arr = {
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 0, 2, 4, 4, 0 },
            { 0, 0, 0, 2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 } };

        int rows = arr.length;
        int cols = arr[0].length;

        for( int i = 0; i < 3; i++ )
        {
            for( int j = 0; j < 3; j++ )
            {
                if( i == 1 )
                {
                    System.out.print( arr[i][1] + "," );
                    break;
                }

                else
                    System.out.print( arr[i][j] + ", " );
            }
            System.out.println();
        }
    }

}
