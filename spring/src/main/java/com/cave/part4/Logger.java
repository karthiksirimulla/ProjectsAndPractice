package com.cave.part4;

public class Logger
{
    private ConsoleWriter consoleWriter;
    private FileWriter fileWriter;

    public LogWriter getConsoleWriter()
    {
        return consoleWriter;
    }

    public void setConsoleWriter( ConsoleWriter consoleWriter )
    {
        this.consoleWriter = consoleWriter;
    }

    public LogWriter getFileWriter()
    {
        return fileWriter;
    }

    public void setFileWriter( FileWriter fileWriter )
    {
        this.fileWriter = fileWriter;
    }

    public void writeToConsole( String str )
    {
        consoleWriter.write( str );
    }

    public void writeToFile( String str )
    {
        fileWriter.write( str );
    }

}
