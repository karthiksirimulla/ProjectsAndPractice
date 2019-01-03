package com.arr;

import java.util.Arrays;

public class SortRectangles
{
    public static void main( String[] args )
    {
        int[] L = { 4, 1, 1, 1 };
        int[] R = { 2, 4, 3, 29 };

        align( L.length, L, R );
        System.out.println( Arrays.toString( L ) );
        System.out.println( Arrays.toString( R ) );

    }

    public static void align( int N,
                              int L[],
                              int R[] )
    {

        for( int i = 0; i < N - 1; i++ )
        {
            int iMin = i;
            for( int j = i + 1; j < N; j++ )
            {
                if( L[j] < L[iMin] )
                {
                    iMin = j;
                }
                if( L[j] == L[iMin] )
                {
                    if( R[j] > R[iMin] )
                        iMin = j;
                }
            }
            int temp = L[i];
            L[i] = L[iMin];
            L[iMin] = temp;

            int tmp = R[i];
            R[i] = R[iMin];
            R[iMin] = tmp;

        }
        System.out.println( "Sorted : " + Arrays.toString( L ) );
        System.out.println( "Sorted Corr: " + Arrays.toString( R ) );
    }

    public static void align_rectangles( int N,
                                         int L[],
                                         int R[] )
    {
        int[] arr = new int[N];
        int i;
        int num = (int) Math.pow( 10, 8 );

        for( i = 0; i < N; i++ )
        {
            arr[i] = L[i] * num + R[i];
        }
        System.out.println( "BEFORE SORT : " + Arrays.toString( arr ) );
        Arrays.sort( arr );
        System.out.println( "SORTED : " + Arrays.toString( arr ) );

        for( i = 0; i < N - 1; i++ )
        {
            if( arr[i] / num == arr[i + 1] / num )
            {
                if( arr[i] % num < arr[i + 1] % num )
                {
                    L[i] = arr[i + 1] / num;
                    R[i] = arr[i + 1] % num;
                    L[i + 1] = arr[i] / num;
                    R[i + 1] = arr[i] % num;
                    i++;
                }

            }
            else
            {
                L[i] = arr[i] / num;
                R[i] = arr[i] % num;
            }
        }
        if( i < N )
        {
            L[i] = arr[i] / num;
            R[i] = arr[i] % num;
        }

    }

    public static int[] rotateArray1( int[] arr,
                                      int k )
    {
        int len = arr.length;
        if( k > len )
            return null;
        int[] arrNew = new int[len];
        for( int i = 0; i < len - 1; i++ )
        {
            int temp = i + k;
            if( temp > len - 1 )
            {
                arrNew[temp - len] = arr[i];
            }
            else
            {
                arrNew[temp] = arr[i];
            }
        }
        return arrNew;
    }
}
