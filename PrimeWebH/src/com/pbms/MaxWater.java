package com.pbms;

import java.io.IOException;

public class MaxWater
{
    public static void main( String[] args ) throws IOException
    {

        int[] testcase1 = { 4, 8, 2, 9, 3, 2, 5, 7, 6, 1 };

        maxWater( testcase1 );

    }

    private static void maxWater( int[] arr )
    {
        int start = 0;
        int end = arr.length - 1;
        int storage = 0;

        for( int i = start; i < end; i++ )
        {

        }

        System.out.println( "storage :" + storage );

    }

}
