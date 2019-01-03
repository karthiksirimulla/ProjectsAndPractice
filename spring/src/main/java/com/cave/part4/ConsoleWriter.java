package com.cave.part4;

public class ConsoleWriter implements LogWriter
{

    public void write( String str )
    {
        System.out.println( "Writing to console : " + str );

    }

}
