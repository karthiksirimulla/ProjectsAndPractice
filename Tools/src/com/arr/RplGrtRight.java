package com.arr;

import java.util.Arrays;

public class RplGrtRight
{
    public static void main( String[] args )
    {
        int[] arr = { 16, 17, 4, 3, 5, 2 };//{17, 5, 5, 5, 2, -1}.
        grtRight( arr );
    }

    private static void grtRight( int[] arr )
    {
        int len = arr.length;
        int maxEle = -1;
        for( int i = len - 1; i >= 0; i-- )
        {
            int curr = arr[i];
            arr[i] = maxEle;
            if( curr > maxEle )
            {
                maxEle = curr;
            }
        }
        System.out.println( Arrays.toString( arr ) );

    }

}
