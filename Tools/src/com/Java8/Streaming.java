package com.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Streaming
{
    public static void main( String[] args )
    {
        List<String> words = new ArrayList<>();
        words.add( "Sunday" );
        words.add( "Monday" );
        words.add( "Tuesday" );
        words.add( "Wednesday" );
        words.add( "Thursday" );
        words.add( "Friday" );
        words.add( "Satday" );

        Stream<String> stream = words.stream();
        words.stream().map( String::toLowerCase ).forEach( System.out::println );

    }

}
