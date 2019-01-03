package com.pbms;

import java.util.Arrays;

public class TrapRainWater
{
    public static void main( String[] args )
    {
        int[] walls = { 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] t1 = { 7, 1, 4, 0, 2, 8, 6, 3, 5 };
        int res = trapped( walls );
        System.out.println( "Max Rain Water : " + res );

    }

    public static int trapped( int[] arr )
    {
        int l = 0, r = arr.length - 1;
        int min = Math.min( arr[l], arr[r] );
        int initStorage = Math.min( arr[l], arr[r] ) * ( r - 1 );
        System.out.println( "init : " + initStorage );
        int leftMax = arr[l];
        while( arr[r - 1] > arr[r] )
            r--;

        System.out.println( "Start : " + l );
        System.out.println( "End : " + r );

        for( int i = l + 1; i < r; i++ )
        {
            int temp = arr[i];
            if( leftMax > temp )
            {
                if( temp > min )
                    initStorage = initStorage - min;
                else
                    initStorage = initStorage - temp;
            }
            else
            {
                initStorage = initStorage - min;
                initStorage = initStorage + ( ( leftMax - min ) * ( i - 1 ) );
                leftMax = temp;
            }
        }

        return initStorage;

    }

    public static int trap( int[] height )
    {
        int result = 0;

        if( height == null || height.length <= 2 )
            return result;

        int left[] = new int[height.length];
        int right[] = new int[height.length];

        //scan from left to right
        int max = height[0];
        left[0] = height[0]; // { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        for( int i = 1; i < height.length; i++ )
        {
            if( height[i] < max )
            {
                left[i] = max;
            }
            else
            {
                left[i] = height[i];
                max = height[i];
            }
        }

        System.out.println( Arrays.toString( left ) );

        //scan from right to left
        max = height[height.length - 1];
        right[height.length - 1] = height[height.length - 1];
        for( int i = height.length - 2; i >= 0; i-- )
        {
            if( height[i] < max )
            {
                right[i] = max;
            }
            else
            {
                right[i] = height[i];
                max = height[i];
            }
        }
        System.out.println( Arrays.toString( right ) );

        //calculate total
        for( int i = 0; i < height.length; i++ )
        {
            System.out.println( "Math.min( " + left[i] + "," + right[i] + " ) -" + height[i] );
            result += Math.min( left[i], right[i] ) - height[i];
        }

        return result;
    }

}
