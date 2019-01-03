package com.Prac;

public class FindAllSubsets
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 4, 2, 3 };
        int n = arr.length;
        int k = 1;

        findAllSubsets( arr, n, k );

    }

    private static void findAllSubsets( int[] arr,
                                        int n,
                                        int k )
    {
        for( int i = 0; i < n; i++ )
            System.out.print( arr[i] + ", " );

    }

}
