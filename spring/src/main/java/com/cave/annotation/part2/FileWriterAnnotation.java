package com.cave.annotation.part2;

import org.springframework.stereotype.Component;

@Component
public class FileWriterAnnotation implements LogWriterAnnotation
{
    public void write( String str )
    {
        System.out.println( "Writing to file : " + str );

    }

}
