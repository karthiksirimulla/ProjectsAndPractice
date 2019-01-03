package com.cave.annotation.part1;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier( "fileQuality" )
public class FileWriterAnnotation implements LogWriterAnnotation
{
    public void write( String str )
    {
        System.out.println( "Writing to file : " + str );

    }

}
