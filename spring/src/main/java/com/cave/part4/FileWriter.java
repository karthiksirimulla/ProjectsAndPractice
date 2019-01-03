package com.cave.part4;

public class FileWriter implements LogWriter
{
    public void write( String str )
    {
        System.out.println( "Writing to file : " + str );

    }

}
