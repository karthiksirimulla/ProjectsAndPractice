package com.misc;

import java.util.Arrays;

public class Colony
{
    public static void main( String[] args )
    {

        int[] inputArr = { 1, 1, 1, 0, 1, 1, 1, 1 };
        int days = 2;

        System.out.println( "inputArr : " + Arrays.toString( inputArr ) );

        cellComplete( inputArr, days );

        cellCompleteInPlace( inputArr, days );

    }

    private static void cellCompleteInPlace( int[] inputArr,
                                             int days )
    {
        int len = inputArr.length;
        int prev = 0;

        for( int i = 0; i < len - 1; i++ )
        {

        }

    }

    private static void cellComplete( int[] inputArr,
                                      int days )
    {

        if( days == 0 )
        {
            System.out.println( "Result :" + Arrays.toString( inputArr ) );
            return;
        }

        int len = inputArr.length;
        int[] tempArray = new int[len + 2];

        for( int i = 1; i < tempArray.length - 1; i++ )
        {
            tempArray[i] = inputArr[i - 1];

        }

        System.out.println( "tempArray : " + Arrays.toString( tempArray ) );

        for( int i = 1; i < tempArray.length - 1; i++ )
        {
            if( tempArray[i - 1] == tempArray[i + 1] )
                inputArr[i - 1] = 0;
            else
                inputArr[i - 1] = 1;
        }

        cellComplete( inputArr, --days );

    }

}
