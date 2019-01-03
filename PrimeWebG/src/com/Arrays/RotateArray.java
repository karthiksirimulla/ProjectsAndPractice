package com.Arrays;

import java.util.Arrays;

public class RotateArray
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };// {1,1}
        int k = 11;

        int[] wArr = new int[3];
        System.out.println( Arrays.toString( wArr ) );

        System.out.println( "Left Rotate : " + k );
        System.out.println( "Right Rotate : " + ( arr.length - k ) );
        System.out.println( "Arr len : " + arr.length );

        int[] res = rotateLeft( arr, k );
        System.out.println( Arrays.toString( res ) );

        int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };// {1,1}
        k = 1;

        res = rotateRight( ar, k );
        System.out.println( Arrays.toString( res ) );
    }

    private static int[] rotate( int[] arr,
                                 int k )
    {
        if( k == 0 )
            return arr;
        int len = arr.length - 1;
        int lastEle = arr[len];
        for( int i = len; i > 0; i-- )
        {
            arr[i] = arr[i - 1];

        }
        arr[0] = lastEle;
        k--;
        return rotate( arr, k );

    }

    private static int[] rotateLeft( int[] arr,
                                     int k )
    {
        // [1,2,3,4] -> [2,3,4,1] 
        if( k == 0 )
            return arr;
        int len = arr.length - 1;
        int initEle = arr[0];
        for( int i = 0; i < len; i++ )
        {
            arr[i] = arr[i + 1];
        }
        arr[len] = initEle;
        k--;
        return rotateLeft( arr, k );

    }

    private static int[] rotateRight( int[] arr,
                                      int k )
    {

        while( k > 0 )
        {
            int arrLen = arr.length;
            if( arrLen == 0 )
                return arr;
            if( k > arrLen )
                k = k % arrLen;
            int len = arrLen - 1;
            int lastEle = arr[len];
            for( int i = len; i > 0; i-- )
            {
                arr[i] = arr[i - 1];
            }
            arr[0] = lastEle;
            k--;
        }
        return arr;
    }

}
