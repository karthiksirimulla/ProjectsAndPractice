package com.cave.annotation.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component( "logger" )
public class LoggerAnnotation
{
    @Autowired
    private ConsoleWriterAnnotation consoleWriter;

    @Autowired
    private FileWriterAnnotation fileWriter;

    public void setConsoleWriter( ConsoleWriterAnnotation consoleWriter )
    {
        this.consoleWriter = consoleWriter;
    }

    public void setFileWriter( FileWriterAnnotation fileWriter )
    {
        this.fileWriter = fileWriter;
    }

    public void writeToConsole( String str )
    {
        if( consoleWriter != null )
            consoleWriter.write( str );
    }

    public void writeToFile( String str )
    {
        fileWriter.write( str );
    }

}
