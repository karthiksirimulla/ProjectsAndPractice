package com.Generics;

import java.util.Arrays;

/*
 * Write a generic method to exchange the positions of two different elements in an array.
 */
public class Ex2
{
    public static void main( String[] args )
    {
        String[] arr1 = { "A", "B", "C" };
        String[] arr2 = { "D", "E", "F" };
        int n = 1;
        exchange( arr1, arr2, n );
        System.out.println( Arrays.toString( arr1 ) );
        System.out.println( Arrays.toString( arr2 ) );

        Integer[] arr3 = { 1, 2, 3 };
        Integer[] arr4 = { 4, 5, 6 };
        exchange( arr3, arr4, n );
        System.out.println( Arrays.toString( arr3 ) );
        System.out.println( Arrays.toString( arr4 ) );

    }

    private static <T, U> void exchange( T[] arr1,
                                         U[] arr2,
                                         int pos )
    {
        if( arr1.length - 1 > pos && arr2.length > pos && arr1.getClass().equals( arr2.getClass() ) )
        {
            T temp = arr1[pos];
            arr1[pos] = (T) arr2[pos];
            arr2[pos] = (U) temp;
        }

    }

}
