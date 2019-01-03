package com.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author imssbora
 */
public class StreamLimitSkipExample
{
    public static void main( String[] args )
    {

        List<Integer> numbers = new ArrayList<>();
        for( int i = 0; i < 12; i++ )
        {
            numbers.add( i );
        }

        /* Stream<Integer> stream1 = numbers.stream();
        // Limit - return new stream of 3 elements
        System.out.println( "--------Stream elements after limiting----------" );
        stream1.limit( 3 ).forEach( ( a ) -> {
            System.out.println( a );
        } );*/

        Stream<Integer> stream2 = numbers.stream();
        stream2.skip( 10 ).limit( 5 ).forEach( ( a ) -> {
            System.out.println( a );
        } );
        // Skip - return new stream of remaining elements
        // after skipping first 2 elements
        /* System.out.println( "--------Stream elements after skipping----------" );
        for( int j = 0; j < 100; j = j + 5 )
            stream2.skip( j ).limit( j + 5 ).forEach( ( a ) -> {
                System.out.println( a );
            } );*/
        System.out.println( "------------------------" );
    }
}