package com.flight.book;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FlightSeatBookingSystem
{
    /**
    * Input to the program will be a 2D array that represents the rows and columns [ [3,4], [4,5],[2,3], [3,4] ]
      Number of passengers waiting in queue.
    * 
    * 1. First - fill Aisle seats
    * 2. Second - window seats
    * 3. Third - middle seats
    */
    public static void main( String[] args )
    {
        int[][] seating = { { 3, 2 }, { 4, 3 }, { 2, 3 }, { 3, 4 } };
        // cols, rows 
        int passengers = 30;
        System.out.println( Arrays.deepToString( seating ) );

        System.out.println( seating.length );

        Map<String, Integer> lAisleSeatMap = new LinkedHashMap<>();
        Map<String, Integer> lWindowSeatMap = new LinkedHashMap<>();
        Map<String, Integer> lMiddleSeatMap = new LinkedHashMap<>();

        extractWindowSeats( lWindowSeatMap, lAisleSeatMap, lMiddleSeatMap, (char) ( 65 ), seating[0], true );

        for( int i = 1; i < seating.length - 1; i++ )
        {
            char section = (char) ( 65 + i );
            int[] arr = seating[i];
            extractAisleSeats( lAisleSeatMap, section, arr );
            extractMiddleSeats( lMiddleSeatMap, section, arr );
        }

        extractWindowSeats( lWindowSeatMap,
                            lAisleSeatMap,
                            lMiddleSeatMap,
                            (char) ( 65 + seating.length - 1 ),
                            seating[seating.length - 1],
                            false );

        System.out.println( "------------------------------------" );

        System.out.println( "lWindowSeatMap Size : " + lWindowSeatMap.size() );
        System.out.println( "lAisleSeatMap Size : " + lAisleSeatMap.size() );
        System.out.println( "lMiddleSeatMap Size : " + lMiddleSeatMap.size() );

        System.out.println( "----------------------------------------" );

        while( passengers > 0 )
        {
            for( java.util.Map.Entry<String, Integer> e : lAisleSeatMap.entrySet() )
            {
                System.out.println( e.getKey() + " --" + e.getValue() );
            }

            passengers--;
        }

    }

    private static void extractWindowSeats( Map<String, Integer> lWindowSeatMap,
                                            Map<String, Integer> lAisleSeatMap,
                                            Map<String, Integer> lMiddleSeatMap,
                                            char section,
                                            int[] arr,
                                            boolean isLeftMost )
    {
        int cols = arr[0];
        int rows = arr[1];

        if( isLeftMost )
        {

            for( int i = 0; i < rows; i++ )
            {
                System.out.println( "WINDOW -->" + section + String.valueOf( i ) + "0" );
                lWindowSeatMap.put( section + String.valueOf( i ) + "0", 0 );
            }

            for( int i = 0; i < rows; i++ )
            {
                System.out.println( "AISLE -->" + section + String.valueOf( i ) + String.valueOf( cols - 1 ) );
                lAisleSeatMap.put( section + String.valueOf( i ) + String.valueOf( cols - 1 ), 0 );
            }

            for( int i = 0; i < rows; i++ )
            {
                for( int j = 1; j < cols - 1; j++ )
                {
                    System.out.println( "MID -->" + section + String.valueOf( i ) + String.valueOf( j ) );
                    lMiddleSeatMap.put( section + String.valueOf( i ) + String.valueOf( j ), 0 );
                }
            }

        }
        else
        {
            for( int i = 0; i < rows; i++ )
            {
                System.out.println( "WINDOW -->" + section + String.valueOf( i ) + String.valueOf( cols - 1 ) );
                lWindowSeatMap.put( section + String.valueOf( i ) + String.valueOf( cols - 1 ), 0 );
            }

            for( int i = 0; i < rows; i++ )
            {
                System.out.println( "AISLE -->" + section + String.valueOf( i ) + "0" );
                lAisleSeatMap.put( section + String.valueOf( i ) + "0", 0 );
            }

            for( int i = 0; i < rows; i++ )
            {
                for( int j = 1; j < cols - 1; j++ )
                {
                    System.out.println( "MID -->" + section + String.valueOf( i ) + String.valueOf( j ) );
                    lMiddleSeatMap.put( section + String.valueOf( i ) + String.valueOf( j ), 0 );
                }
            }

        }

    }

    private static void extractAisleSeats( Map<String, Integer> lAisleSeatMap,
                                           char section,
                                           int[] arr )
    {
        int cols = arr[0];
        int rows = arr[1];

        for( int i = 0; i < rows; i++ )
        {
            System.out.println( "AISLE -->" + section + String.valueOf( i ) + "0" );
            lAisleSeatMap.put( section + String.valueOf( i ) + "0", 0 );
        }

        for( int i = 0; i < rows; i++ )
        {
            System.out.println( "AISLE -->" + section + String.valueOf( i ) + String.valueOf( cols - 1 ) );
            lAisleSeatMap.put( section + String.valueOf( i ) + String.valueOf( cols - 1 ), 0 );
        }

    }

    private static void extractMiddleSeats( Map<String, Integer> lMiddleSeatMap,
                                            char section,
                                            int[] arr )
    {
        int cols = arr[0];
        int rows = arr[1];

        for( int i = 0; i < rows; i++ )
        {
            for( int j = 1; j < cols - 1; j++ )
            {
                System.out.println( "MID -->" + section + String.valueOf( i ) + String.valueOf( j ) );
                lMiddleSeatMap.put( section + String.valueOf( i ) + String.valueOf( j ), 0 );
            }
        }

    }
}
