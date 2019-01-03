package com.cave.annotation.part1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LoggerAnnotation
{
    // @Autowired
    //@Qualifier( "consoleQualify" )
    @Resource( name = "toConsole" )
    private ConsoleWriterAnnotation consoleWriter;

    @Autowired
    @Qualifier( "fileQuality" )
    private LogWriterAnnotation fileWriter;

    public void setConsoleWriter( ConsoleWriterAnnotation consoleWriter )
    {
        this.consoleWriter = consoleWriter;
    }

    public void setFileWriter( LogWriterAnnotation fileWriter )
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

    @PostConstruct
    public void first()
    {
        System.out.println( "init() method" );
    }

    @PreDestroy
    public void last()
    {
        System.out.println( "destroy() method" );
    }

}
