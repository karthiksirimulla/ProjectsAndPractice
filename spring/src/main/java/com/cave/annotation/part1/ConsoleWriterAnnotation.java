package com.cave.annotation.part1;

public class ConsoleWriterAnnotation implements LogWriterAnnotation
{
    private int i;

    public ConsoleWriterAnnotation( int i )
    {
        this.i = i;
    }

    public void write( String str )
    {
        System.out.println( "---> : " + this );
        System.out.println( "Writing to console : " + str );

    }

    @Override
    public String toString()
    {
        return "ConsoleWriterAnnotation [i=" + i + "]";
    }

}
