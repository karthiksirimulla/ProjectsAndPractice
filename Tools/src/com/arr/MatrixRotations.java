package com.arr;

public class MatrixRotations
{
    public static void main( String[] args )
    {
        int[][] arr = new int[][] { { 1, 2, 4 }, { 3, 6, 8 }, { 7, 9, 5 }, { 11, 15, 13 } };

        /*
         *   [ 1, 2, 4]                        
             [ 3, 6, 8]    
             [ 7, 9, 5]
             [ 11,15,13]
         * 
         */

        leftRotate( arr );
        rightRotate( arr );

    }

    private static void rightRotate( int[][] arr )
    {
        int cols = arr[0].length - 1;
        int rows = arr.length - 1;

        System.out.println( "------- Right Rotate ---------------" );

        for( int i = 0; i <= cols; i++ )
        {
            for( int j = rows; j >= 0; j-- )
            {
                System.out.print( arr[j][i] + ", " );

            }

            System.out.println();
        }

    }

    private static void leftRotate( int[][] arr )
    {
        int cols = arr[0].length - 1;
        int rows = arr.length - 1;

        System.out.println( "------- Left Rotate ---------------" );

        for( int i = cols; i >= 0; i-- )
        {
            for( int j = 0; j <= rows; j++ )
            {
                System.out.print( arr[j][i] + ", " );

            }

            System.out.println();
        }
    }

}
