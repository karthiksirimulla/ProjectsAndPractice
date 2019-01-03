package com.DyP;

public class MagicIndex
{
    /**
     * Magic Index :- A[i] = i
     * 
     * a) Given a sorted array of distinct numbers find out If there exists a magic index
     * b) What if the values are not distinct
     * 
     */

    public static void main( String[] args )
    {

        int[] arr = { -40, -20, -1, 1, 2, 3, 5, 6, 8, 12, 13 };
        //          [  0     1   2  3  4  5  6  7  8   9  10 ]
        int magic = findMagicIndex( arr, 0, arr.length - 1 );

        System.out.println( "Magic Index : " + magic );

    }

    private static int findMagicIndex( int[] arr,
                                       int initIndex,
                                       int lastIndex )
    {
        if( initIndex > lastIndex )
            return -1;
        int mid = ( initIndex + lastIndex ) / 2;
        if( arr[mid] == mid )
            return mid;
        if( arr[mid] > mid )
            lastIndex = mid - 1;
        else if( arr[mid] < mid )
            initIndex = mid + 1;

        return findMagicIndex( arr, initIndex, lastIndex );

    }

}
