package com.Prac;

public class SubsetSubSums
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 4, 2, 3 };
        int n = arr.length;

        printAllSubSets( arr, 0, 0, 0 );

    }

    private static void printAllSubSets( int[] arr,
                                         int start,
                                         int end,
                                         int counter )
    {
        if( start > arr.length )
        {
            System.out.println( "Count : " + counter );
            return;
        }
        int tempEnd = end;
        while( tempEnd < arr.length )
        {
            int sum = 0;
            for( int i = start; i <= tempEnd; i++ )
            {
                sum = sum + arr[i];
                System.out.print( arr[i] + ", " );
            }
            if( isPerfectSquare( sum ) )
                counter++;
            System.out.print( " --------> " + sum );
            System.out.println();
            tempEnd++;
        }
        end++;
        printAllSubSets( arr, start + 1, end, counter );

    }

    static boolean isPerfectSquare( int x )
    {
        double y = Math.sqrt( x );
        return Math.pow( y, 2 ) == x;

    }

}
