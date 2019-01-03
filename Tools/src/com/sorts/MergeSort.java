package com.sorts;

public class MergeSort
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 3, 5, 2, 4, 6, 8 };//{ 2, 3, 1, 4, 5 };//{ 2, 4, 1, 6, 8, 5, 3, 7 };
        int inv_count = inversionCount( arr );
        //System.out.println( inv_count );
        mergeSort( arr );
        System.out.println( inv_count );

    }

    private static void mergeSort( int[] arr )
    {

        int len = arr.length;
        if( len == 1 )
            return;
        int mid = len / 2;

        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for( int i = 0; i < mid; i++ )
            left[i] = arr[i];

        for( int i = mid; i < len; i++ )
            right[i - mid] = arr[i];

        mergeSort( left );
        mergeSort( right );
        mergeSortedArrays( left, right, arr );
    }

    private static int inversionCount( int[] arr )
    {
        int len = arr.length;
        int inv_count = 0;
        if( len < 2 )
            return 0;
        int mid = len / 2;

        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for( int i = 0; i < mid; i++ )
            left[i] = arr[i];

        for( int i = mid; i < len; i++ )
            right[i - mid] = arr[i];

        inv_count = inv_count + inversionCount( left );
        inv_count = inv_count + inversionCount( right );
        inv_count = inv_count + mergeSortedArrays( left, right, arr );
        return inv_count;

    }

    public static int mergeSortedArrays( int[] L,
                                         int[] R,
                                         int[] A )
    {
        int lenL = L.length;
        int lenR = R.length;

        int inv_count = 0;
        int i = 0, j = 0, k = 0;

        while( i < lenL && j < lenR )
        {
            if( L[i] < R[j] )
            {
                A[k] = L[i];
                i++;

            }
            else
            {
                A[k] = R[j];
                j++;
                inv_count = inv_count + ( lenL - i );
            }
            k++;
        }

        while( j < lenR )
        {
            A[k] = R[j];
            k++;
            j++;
        }

        while( i < lenL )
        {
            A[k] = L[i];
            k++;
            i++;
        }
        return inv_count;
    }
}
