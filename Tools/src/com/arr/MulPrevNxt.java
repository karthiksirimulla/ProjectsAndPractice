package com.arr;

import java.util.Arrays;

public class MulPrevNxt
{

    public static void main( String[] args )
    {
        int arr[] = { 2, 3, 4, 5, 6 };
        //  Output: arr[] = {6, 8, 15, 24, 30}
        modifyArr( arr );

    }

    private static void modifyArr( int[] arr )
    {
        int len = arr.length;
        int prev = arr[0];
        int i = 1;
        arr[0] = arr[0] * arr[1];
        while( i < len - 1 )
        {
            int curr = arr[i];
            arr[i] = prev * arr[i + 1];
            prev = curr;
            i++;
        }
        arr[len - 1] = arr[len - 1] * prev;
        System.out.println( Arrays.toString( arr ) );

    }

}
